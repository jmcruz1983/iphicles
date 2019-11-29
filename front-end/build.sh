#!/bin/bash
set -e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building front-end enviroment'
docker build --quiet --rm --target=build-env -t front-end:latest .

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Running tests'
docker run -it front-end:latest ng test --watch=false

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Running e2e tests'
docker run -it front-end:latest ng e2e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building release front-end image'
docker build --quiet --rm -t front-end:latest .
