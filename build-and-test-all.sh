#!/bin/bash

set -e

echo '--> Building front-end'
pushd front-end
sh ./build.sh
popd