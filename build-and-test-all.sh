#!/bin/bash

set -e

echo '--> Building back-end'
pushd back-end
sh ./build.sh
popd

echo '--> Building front-end'
pushd front-end
sh ./build.sh
popd