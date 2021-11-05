#!/usr/bin/env groovy
import com.example.Maven

def call(String nexusId, String nexusCredsId) {
    return new Maven(this).mvnDeploy(nexusId, nexusCredsId)
}