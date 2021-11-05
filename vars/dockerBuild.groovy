#!/usr/bin/env groovy
import com.example.Docker

def call(String tag) {
    return new Docker(this).dockerBuild(tag)
}