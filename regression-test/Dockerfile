# base image
FROM node:8.16-slim

# set working directory
WORKDIR /regression-test

# install and cache app dependencies
COPY package.json .
RUN npm --quiet install 1>/dev/null

ARG VERSION=undefined
ENV APPLICATION_VERSION=${VERSION:-1.0.0}

# add regression-test source
COPY .eslintrc.js .
COPY features features
COPY report report

# run js linter tool
RUN ./node_modules/.bin/eslint features

# start app
CMD npm start