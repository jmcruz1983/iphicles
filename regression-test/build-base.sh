#!/bin/bash
set -e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building regression-test base image'
docker build -f DockerfileBase --quiet --target=base-img -t jmcruz1983/node:8.16-slim .

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Push image to registry'
docker push jmcruz1983/node:8.16-slim
