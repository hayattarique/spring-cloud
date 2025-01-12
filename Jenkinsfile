pipeline {
    agent any
    environment {
        MODULES = ['configserver', 'distributornetwork', 'inventorymanagement']
        VERSION = '1.0'
    }
    stages {
        stage('checkout code from scm') {
            steps {
                git branch: 'main', url: 'https://github.com/hayattarique/spring-cloud.git'
                echo 'code cloned successfully'
            }
        }
        stage('building images for docker') {
            steps {
                script {
                    for (module in env.MODULES) {
                        dir(module) {
                            def imageName = "${module}:${env.VERSION}"
                           docker build -t ${imageName} .
                        }
                    }
                }
            }
        }
    }
}