pipeline {
    agent any
    tools {
        jdk 'Java 22'
	    maven 'Maven 3'
    }
    environment {
        SLACK_CHANNEL = '#builds'
        DOCKERHUB_REPO = 'jacunav/sigecap-docker'
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-credentials'
        KUBECONFIG = '/home/jenkins/.kube/config'
    }
    stages {
        stage('Checkout') {
            steps {
                //Se espera en este pipeline que el BRANCH corresponda a dev o main.
                git branch: "${env.BRANCH}", url: 'https://github.com/Juan-Acuna/SIGECAP.git'
            }
        }
    	stage('Test') {
            steps {
        		script {
        			if (isUnix()) {
                        sh 'mvn test'
        			} else {
        				bat 'mvn test'
        			}
        		}
            }
        }
        stage('Build') {
            steps {
                script {
    			    if (isUnix()) {
                    	sh 'mvn clean package -DskipTests'
    			    } else {
    				    bat 'mvn clean package -DskipTests'
    			    }
    		    }
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv('SonarQubeServer'){
                    script {
                        def sonarScannerHome = tool name: 'SonarQube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                        if (isUnix()) {
                            sh "${sonarScannerHome}/bin/sonar-scanner"
                            
                        } else {
                            bat "${sonarScannerHome}\\bin\\sonar-scanner.bat"
                        }
                    }
                }
            }
        }
        stage('Construir imagen de Docker'){
            steps{
                script {
    			    docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_TAG}")
    			    //Crear Tag latest para imagen
    			    if (isUnix()) {
                        sh "docker tag ${env.DOCKERHUB_REPO}:${env.DOCKER_TAG} ${env.DOCKERHUB_REPO}:latest"
                    } else {
                        bat "docker tag ${env.DOCKERHUB_REPO}:${env.DOCKER_TAG} ${env.DOCKERHUB_REPO}:latest"
                    }
    		    }
            }
        }
        stage('Subir imagen a Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${env.DOCKERHUB_CREDENTIALS_ID}") {
                        docker.image("${env.DOCKERHUB_REPO}:${env.DOCKER_TAG}").push()
                        docker.image("${env.DOCKERHUB_REPO}:latest").push()
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'kubectl apply -f k8s/configmap.yml'
                        sh 'kubectl apply -f k8s/deployment.yml'
                    } else {
                        bat 'kubectl apply -f k8s/configmap.yml'
                        bat 'kubectl apply -f k8s/deployment.yml'
                    }
                }
            }
        }
    	stage('Cleanup'){
    		steps{
    			cleanWs()
    		}
    	}
    }
    post {
        success {
            slackSend (
                channel: env.SLACK_CHANNEL,
                color: 'good',
                message: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) finalizó correctamente."
            )
        }
        failure {
            slackSend (
                channel: env.SLACK_CHANNEL,
                color: 'danger',
                message: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) falló."
            )
        }
        unstable {
            slackSend (
                channel: env.SLACK_CHANNEL,
                color: 'warning',
                message: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) es inestable."
            )
        }
    }
}