pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Maven_3.9.4') {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage ('Test Stage') {

            steps {
                withMaven(maven : 'Maven_3.9.4') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Cucumber Reports'){

            steps {
            cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
            }
        }

    }
}