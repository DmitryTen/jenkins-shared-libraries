#!/usr/bin/env groovy
import com.example.Maven

def call(String dbUrl, String dbCredsId) {
    return new Maven(this).mvnPackage(dbUrl, dbCredsId)
}