pipeline {
    agent any

    stages {
        stage('Define JAVA') {
            steps {
                sh './setjava.sh'
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