FROM ubuntu:24.04
LABEL authors="takra"
RUN mkdir -p /u01/app
RUN apt update -y
RUN apt install -y openjdk-17-jdk
RUN apt install -y curl
WORKDIR /u01/app
COPY target/inventorymanagement-1.0.jar .
EXPOSE 8081
HEALTHCHECK --interval=30s --timeout=10s --retries=3 CMD curl -f http://localhost:8081/actuator/health || exit 1
ENTRYPOINT ["java","-jar","inventorymanagement-1.0.jar"]