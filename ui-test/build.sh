#!/bin/bash
set -e

echo 'Building ui-test enviroment'
docker build --quiet --target=build-env -t ui-test:latest .

echo 'Building release ui-test image'
docker build --quiet --rm -t ui-test:latest .