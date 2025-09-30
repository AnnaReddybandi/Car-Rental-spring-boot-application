pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('CarRentalApplication') {
                    withMaven(maven: 'Maven') {
                        sh 'mvn clean install -DskipTests'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                dir('CarRentalApplication') {
                    withMaven(maven: 'Maven') {
                        sh 'mvn test'
                    }
                }
            }
        }

        stage('Package') {
            steps {
                dir('CarRentalApplication') {
                    withMaven(maven: 'Maven') {
                        sh 'mvn package'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deployment stage - add scripts for Docker/K8s deployment here'
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
