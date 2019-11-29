# base image
FROM jmcruz1983/node:8.16-slim

# set working directory
WORKDIR /regression-test

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