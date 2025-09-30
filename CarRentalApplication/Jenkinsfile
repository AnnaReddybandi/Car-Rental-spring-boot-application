pipeline {
    agent any
    environment {
        MVN_HOME = '/usr/share/maven' // Adjust as per your Jenkins setup
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk' // Adjust as per your Jenkins setup
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AnnaReddybandi/Car-Rental-spring-boot-application.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh "${MVN_HOME}/bin/mvn clean install -DskipTests"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "${MVN_HOME}/bin/mvn test"
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    sh "${MVN_HOME}/bin/mvn package"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying to your environment..."
                    // Add your deployment scripts here (e.g., Docker, Kubernetes)
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}

