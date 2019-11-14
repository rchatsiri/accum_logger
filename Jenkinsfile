pipeline {
    agent {
        docker {
            image 'hseeberger/scala-sbt'
        }
    }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "sbt test"
            }
        }
    } 
	stages {
        stage('Compile') {
            steps {
                echo 'Compiling..'
                sh "sbt compile"
            }
        }
    } 
	stages {
        stage('Packaging') {
            steps {
                echo 'Packaging..'
                sh "sbt package"
            }
        }
    } 
}