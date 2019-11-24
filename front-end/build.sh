#!/bin/bash
set -e

echo 'Building front-end enviroment'
docker build --quiet --target=build-env -t front-end:latest .

echo 'Running tests'
docker run -it front-end:latest ng test --watch=false

echo 'Running e2e tests'
docker run -it front-end:latest ng e2e

echo 'Building release front-end image'
docker build --quiet --rm -t front-end:latest .
