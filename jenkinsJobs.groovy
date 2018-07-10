def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("build")){
            buildService()
        } else if(env.JOB_NAME.contains("test")) {
            //buildAndTest()
        }
    }
}

def buildService(){
    stage("Package artifact") {
        sh "mvn clean install"
    }
}
