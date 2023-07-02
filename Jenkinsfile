pipeline {
    agent any

    stages {
        stage('Define JAVA') {
            steps {
                sh 'chmod 777 ./setjava'
                sh './setjava'
            }
        }
        stage('Build - compile') {
            steps {
                echo 'Building..'
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