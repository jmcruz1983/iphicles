# base image
FROM gradle:6.0-jre8 AS build-env

WORKDIR /ui-test

# add ui-test sources
COPY src src
COPY config config
COPY settings.gradle    \
    build.gradle        \
    ./

# compiling the code
RUN gradle

# Multi stage build
# final base image
FROM openjdk:8-jre-alpine

# set deployment directory
WORKDIR /service

# copy over the built artifact from the maven image
COPY --from=build-env /ui-test/build/libs/ui-test-1.0.0.jar ./

# set the startup command
CMD java -jar /service/ui-test-1.0.0.jar