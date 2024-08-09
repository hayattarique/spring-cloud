FROM ubuntu:24.04
LABEL authors="hayat"
RUN apt update -y && \
    apt install -y curl && \
    apt install -y openjdk-17-jdk
RUN mkdir -p /usr/app
WORKDIR usr/app
COPY target/distributor-network-1.0.jar .

HEALTHCHECK --interval=30s --timeout=10s --start-period=30s --retries=3 \
  CMD curl --fail http://localhost:8080/actuator/health || exit 1
ENTRYPOINT ["java","-jar", "distributor-network-1.0.jar"]