#!/bin/bash

set -e

echo '=================================================================================================================='
echo '--> Pulling base images'
docker pull --quiet jmcruz1983/maven:3-jdk-8
docker pull --quiet jmcruz1983/node:8.16-slim
docker pull --quiet jmcruz1983/node:10.9.0
docker pull --quiet selenium/standalone-chrome-debug:3.14
docker pull --quiet gradle:6.0-jre8

echo '=================================================================================================================='
echo '--> Building back-end'
pushd back-end
sh ./build.sh
popd

echo '=================================================================================================================='
echo '--> Building front-end'
pushd front-end
sh ./build.sh
popd

echo '=================================================================================================================='
echo '--> Building regression-test'
pushd regression-test
sh ./build.sh
popd

echo '=================================================================================================================='
echo '--> Building ui-test'
pushd ui-test
sh ./build.sh
popd