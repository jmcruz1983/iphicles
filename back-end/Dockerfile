# base image
FROM maven:3-jdk-8 AS build-env

# setup home directory
WORKDIR /back-end

# copy the project files
COPY pom.xml /back-end/pom.xml

# build all dependencies for offline use
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src /back-end/src

# build for release
RUN mvn package

RUN ls /back-end/target

# final base image
FROM openjdk:8-jre

# set deployment directory
WORKDIR /service

# copy over the built artifact from the maven image
COPY --from=build-env /back-end/target/back-end-*.jar ./

RUN ls /service

# set the startup command
CMD java -jar /service/back-end-1.0.0.jar