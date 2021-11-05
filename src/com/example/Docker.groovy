#!/usr/bin/env groovy

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuild(String tag){
        script.sh "docker build -t $tag ."
    }

    def dockerLogin(String dockerHost, String credentialsId){
        script.withCredentials([
                script.usernamePassword(credentialsId: "$credentialsId", usernameVariable: 'USER', passwordVariable: 'PASSWORD')
        ]){
            script.sh "echo $script.PASSWORD | docker login -u $script.USER --password-stdin $dockerHost"
//            script.sh "docker login -u $script.USER -p $script.PASSWORD 192.168.31.141:8083"
        }
    }

    def dockerPush(String tag){
        script.sh "docker push $tag"
    }
}