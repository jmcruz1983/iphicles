# base image
FROM jmcruz1983/node:10.9.0 AS build-env

WORKDIR /front-end

# add front-end source
COPY e2e e2e
COPY src src
COPY angular.json       \
    karma.conf.js       \
    package.json        \
    tslint.json         \
    tsconfig.json       \
    tsconfig.app.json   \
    tsconfig.spec.json  \
    ./

# build source
RUN ng build

# build front-end image for release
FROM nginx:1.13.0

# set working directory
WORKDIR /usr/share/nginx/html

# copy generated sources
COPY --from=build-env /front-end/dist/front-end ./
