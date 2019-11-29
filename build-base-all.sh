#!/bin/bash

set -e

echo '=================================================================================================================='
echo '--> Building back-end base image'
pushd back-end
sh ./build-base.sh
popd

echo '=================================================================================================================='
echo '--> Building front-end base image'
pushd front-end
sh ./build-base.sh
popd

echo '=================================================================================================================='
echo '--> Building regression-test base image'
pushd regression-test
sh ./build-base.sh
popd