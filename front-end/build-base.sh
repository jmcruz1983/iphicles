#!/bin/bash
set -e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building front-end base image'
docker build -f DockerfileBase --quiet --target=base-img -t jmcruz1983/node:10.9.0 .

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Push image to registry'
docker push jmcruz1983/node:10.9.0
