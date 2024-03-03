pipeline {
    agent any
    
    triggers {
        pollSCM('*/3 * * * *') 
    }

    stages {
        stage('Clone repo') {
            steps {
                git branch: 'devops', url: 'https://github.com/Lenu-san/devops.git'
            }
        }

        stage('Build project') {
            steps {
                dir('demo') {
                    // Utilisez le script mvn directement du dossier Maven
                    sh "./maven/bin/mvn -B -DskipTests clean package"

                    // Génère le Javadoc
                    sh "./maven/bin/mvn javadoc:javadoc"
                }
            }
        }

        stage('Publish Javadoc') {
            steps {
                dir('demo/target/site/apidocs') {
                    publishHTML(target: [
                        reportDir: '.', 
                        reportFiles: 'index.html', 
                        reportName: "Javadoc", 
                        keepAll: true, 
                        allowMissing: false 
                    ])
                }
            }
        }
    }
}
