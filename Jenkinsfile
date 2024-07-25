pipeline {
    agent any
    tools {
        jdk 'Java 22'
	    maven 'Maven 3'
    }
    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio
                git branch: 'main', url: 'https://github.com/Juan-Acuna/SIGECAP.git'
            }
        }
    	stage('Test') {
            steps {
                // Construye el proyecto Maven
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
                // Construye el proyecto Maven
                script {
    			    if (isUnix()) {
                    	sh 'mvn clean package'
    			    } else {
    				    bat 'mvn clean package'
    			    }
    		    }
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv('SonarQubeServer'){
                    script {
                        if (isUnix()) {
                            sh '/var/jenkins_home/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarQube/bin/sonar-scanner'
                        } else {
                            def sonarScannerHome = tool name: 'SonarQube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                            bat '${sonarScannerHome}\\bin\\sonar-scanner.bat'
                        }
                    }
                }
            }
        }
        stage('Subir a Nexus') {
            steps {
                script{
                    def servidorNexus = ''
                    if (isUnix()) {
                        servidorNexus = 'nexus:8081'
                    } else {
                        servidorNexus = 'localhost:8081'
                    }
                    nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol:'http',
                    nexusUrl:'${servidorNexus}',
                    groupId:'maryjaneslastdance',
                    version: '${env.BUILD_ID}-${env.BUILD_TIMESTAMP}',
                    repository:'sigecap-repo',
                    credentialsId:'nexus',
                    artifacts:[
                        [artifactId:'sigecap',
                        classifier:'',
                        file:'target/sigecap-0.0.1-SNAPSHOT.jar',
                        type:'jar']
                    ]
                )
                }
            }
        }
    	stage('Cleanup'){
    		steps{
    			//Limpieza despues de cada build
    			cleanWs()
    		}
    	}
    }
}
