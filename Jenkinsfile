pipeline {
    agent any
    environment {
        MODULES = 'configserver,distributornetwork,inventorymanagement' // Comma-separated string
        VERSION = '1.0'
    }
    stages {
        stage('Checkout Code from SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/hayattarique/spring-cloud.git'
                echo 'Code cloned successfully'
            }
        }
        stage('Building Images for Docker') {
            steps {
                script {
                    // Convert MODULES string to a list
                    def modules = env.MODULES.split(',')
                    
                    for (module in modules) {
                        dir(module) {
                            def imageName = "${module}:${env.VERSION}"
                            echo "Building Docker image for module ${module} with name ${imageName}..."
                            // Build the Docker image
                            sh """
                            docker build -t ${imageName} .
                            """
                        }
                    }
                }
            }
        }
    }
    post {
        success {
            echo 'All stages completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }
    }
}
