pipeline {
    agent any

    stages {
        stage('Build - compile') {
            steps {
                echo 'Building..'
                sh 'chmod 777 ./setjava'
                sh './setjava'
                sh './gradlew clean build -x test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}