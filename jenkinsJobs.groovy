def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("SpringRestServices")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            //buildAndTest()
        }
    }
}

def packageArtifact(){
    stage("Package artifact") {
        sh "mvn clean install"
    }
}


}
