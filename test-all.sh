#!/bin/bash

set -e

echo '=================================================================================================================='
echo '--> Spinning up docker compose cluster'
docker-compose up -d proxy

echo '=================================================================================================================='
echo '--> Running regression tests'
docker-compose run regression-test

echo '=================================================================================================================='
echo '--> Running regression tests'
docker-compose up -d selenium
open vnc://localhost:5900
docker-compose run ui-test

echo '=================================================================================================================='
echo '--> Tear down'
docker-compose down --remove-orphans