FROM registry.access.redhat.com/ubi8/openjdk-11

WORKDIR /usr/app

COPY target/user-service*.jar .

EXPOSE 8081

ENTRYPOINT ["sh", "-c", "java -jar user-service-1.0-SNAPSHOT.jar"]
