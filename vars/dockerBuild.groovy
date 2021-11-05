#!/usr/bin/env groovy

def call(String tag) {
    new Docker(this).dockerBuild(tag)
}