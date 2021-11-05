#!/usr/bin/env groovy
package com.example

class Maven implements Serializable {
    def script
    Maven(script) {
        this.script = script
    }

    def mvnPackage(String dbUrl, String dbCredsId){
        script.withCredentials([
                script.usernamePassword(credentialsId: "$dbCredsId", usernameVariable: 'USER', passwordVariable: 'PASSWORD')
        ]){
            script.sh """mvn clean package \
            -DskipTests \
            -Ddatabase.url=$dbUrl \
            -Ddatabase.user=$script.USER \
            -Ddatabase.password=$script.PASSWORD"""
        }
    }

    def mvnDeploy(String nexusId, String nexusCredsId){
        script.withCredentials([
                script.usernamePassword(credentialsId: "$nexusCredsId", usernameVariable: 'USER', passwordVariable: 'PASSWORD')
        ]){
            script.sh """mvn jar:jar deploy:deploy \
            -Drepo.id=$nexusId \
            -Drepo.login=$script.USER \
            -Drepo.pwd=$script.PASSWORD"""
        }
    }
}