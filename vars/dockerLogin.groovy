#!/usr/bin/env groovy

def call(String dockerHost, String credentialsId) {
    new Docker(this).dockerLogin(dockerHost, credentialsId)
}