#!/bin/bash
set -e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building back-end enviroment'
docker build --quiet --rm --target=build-env -t back-end:latest .

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Running tests'
docker run -it back-end:latest mvn test

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building release back-end image'
docker build --quiet --rm -t back-end:latest .