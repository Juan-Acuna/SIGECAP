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
                            bat '/var/jenkins_home/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarQube/bin/sonar-scanner'
                        }
                    }
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
