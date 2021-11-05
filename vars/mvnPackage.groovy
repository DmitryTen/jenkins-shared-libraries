#!/usr/bin/env groovy

def call(String dbUrl, String dbCredsId) {
    new Maven(this).mvnPackage(dbUrl, dbCredsId)
}