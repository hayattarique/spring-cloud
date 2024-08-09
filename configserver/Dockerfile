FROM ubuntu:latest
LABEL authors="takra"
RUN apt update -y
RUN apt install -y openjdk-17-jdk
RUN mkdir -p user/app
WORKDIR user/app
COPY target/configserver-1.0.0.jar .
ENTRYPOINT ["java","-jar","configserver-1.0.0.jar"]