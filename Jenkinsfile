pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Maven_3.5.2') {
                    sh 'mvn clean install'
                }
            }
        }

        stage ('Test Stage') {

            steps {
                withMaven(maven : 'Maven_3.5.2') {
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
