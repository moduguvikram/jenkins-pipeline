def createBuildJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}



def buildPipelineJobs() {
    def repo = "https://github.com/moduguvikram/"
    def repoUrl = repo + jobName + ".git"
    def buildName = jobName + "_build"
    def deployName = jobName + "_deploy"
    def testName = jobName + "_test"


    createBuildJob(buildName, repoUrl)
}

buildPipelineJobs()
