pipeline {
    agent any

    tools {
        maven 'maven-3.5.2'
    }

    stages {
        stage('Clone repo') {
            steps {
                git branch: 'devops', url: 'https://github.com/SHODELACAILLE/Jenkins_Test.git'
            }
        }

        stage('Build and Test') {
            steps {
                dir('demo') {
                    script {
                        // Compilation
                        sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean compile"
                        // Tests JUnit
                        sh "'${tool 'maven-3.5.2'}/bin/mvn' test"
                    }
                }
            }
        }

        stage('Modify and Fail Test') {
            steps {
                script {
                    // Modify a test to fail
                    sh "echo \"assertNotEquals(Integer.valueOf(5), calculator.add(2, 3));\" >> demo/src/test/java/CalculatorTest.java"
                    // Ensure compilation works
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean compile"
                    // Run tests
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' test"
                }
            }
        }

        stage('Ignore Test') {
            steps {
                script {
                    // Ignore a test
                    sh "echo '@Ignore' >> demo/src/test/java/CalculatorTest.java"
                    // Ensure compilation works
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' -B -DskipTests clean compile"
                    // Run tests
                    sh "'${tool 'maven-3.5.2'}/bin/mvn' test"
                }
            }
        }

        stage('Publish Test Report') {
            steps {
                script {
                    // Assuming surefire-reports are generated
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
