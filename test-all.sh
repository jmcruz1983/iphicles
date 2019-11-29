#!/bin/bash

set -e

echo '=================================================================================================================='
echo '--> Spinning up docker compose cluster'
docker-compose up -d proxy

echo '=================================================================================================================='
echo '--> Running regression tests'
docker-compose up regression-test

echo '=================================================================================================================='
echo '--> Running regression tests'
docker-compose up ui-test

echo '=================================================================================================================='
echo '--> Tear down'
docker-compose down --remove-orphans