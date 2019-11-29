#!/bin/bash
set -e

echo '=================================================================================================================='
echo 'Building back-end base image'
docker build -f DockerfileBase --quiet --target=base-img -t jmcruz1983/maven:3-jdk-8 .

echo '=================================================================================================================='
echo 'Push image to registry'
docker push jmcruz1983/maven:3-jdk-8
