# base image
FROM jmcruz1983/maven:3-jdk-8 AS build-env

WORKDIR /back-end

# compile and test the sources
COPY ./src /back-end/src
RUN mvn package -DskipTests

# final base image
FROM openjdk:8-jre

WORKDIR /service

# copy generated artifact from build env
COPY --from=build-env /back-end/target/back-end-*.jar ./

# set the startup command
CMD java -jar /service/back-end-1.0.0.jar