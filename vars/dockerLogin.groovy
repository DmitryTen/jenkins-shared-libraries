#!/usr/bin/env groovy
import com.example.Docker

def call(String dockerHost, String credentialsId) {
    return new Docker(this).dockerLogin(dockerHost, credentialsId)
}