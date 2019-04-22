FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080:8080
ARG JAR_FILE=target/shopping-list-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]