#!/bin/bash
set -e

echo 'Building back-end enviroment'
docker build --quiet --target=build-env -t back-end:latest .

echo 'Running tests'
docker run -it back-end:latest mvn test

echo 'Building release front-end image'
docker build --quiet --rm -t back-end:latest .