   pipeline {
        agent any
        
            triggers {
            pollSCM('*/3 * * * *') 
        }

        tools {
        
            maven 'maven-3.5.2'
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
                    
                        sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean package"
                        
                        // Génère le Javadoc
                        sh "'${tool 'maven-3.5.2'}/bin/mvn' javadoc:javadoc"
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