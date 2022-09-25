FROM registry.access.redhat.com/ubi8/openjdk-11

WORKDIR /usr/app

COPY target/todo-service*.jar .

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar todo-service-1.0-SNAPSHOT.jar"]
