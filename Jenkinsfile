pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compile..'
                sh './gradlew clean build -x test'
            }
        }
        stage('Unit Tests') {
            steps {
                echo 'Unit testing..'
                sh "./gradlew test --tests '*UT' -i"
            }
        }
        stage('Functional Tests') {
            steps {
                echo 'Functional testing..'
                sh "./gradlew test --tests '*FT' -i"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}