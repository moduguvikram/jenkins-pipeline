def call(){
    node {
        stage('Checkout') {
            checkout scm
        }
        if(env.JOB_NAME.contains("build")){
            buildService()
        }else if(env.JOB_NAME.contains("publish")) {
             buildService()
        }else if(env.JOB_NAME.contains("test")) {
 
        }
        stage('Docker') {
            
        }
        stage('Publish') {
            
        }
        
    }
}

def buildService(){
    stage("Build") {
         //"mvn clean install"
        "cmd /c mvn clean install"
    }
}
