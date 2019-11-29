#!/bin/bash
set -e

echo '------------------------------------------------------------------------------------------------------------------'
echo 'Building regression-test'
docker build --quiet --rm -t regression-test:latest .