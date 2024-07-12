pipeline {
    agent any

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
		if(isUnix()){
                	sh 'mvn test'
		}else{
			bat 'mvn test'
		}
            }
        }
        stage('Build') {
            steps {
                // Construye el proyecto Maven
                if(isUnix()){
                	sh 'mvn clean package'
		}else{
			bat 'mvn clean package'
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
