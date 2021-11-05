#!/usr/bin/env groovy

def call(String nexusId, String nexusCredsId) {
    new Maven(this).mvnDeploy(nexusId, nexusCredsId)
}