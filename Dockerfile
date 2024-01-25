FROM maven:3.9.6-amazoncorretto-17-al2023 as stage1
WORKDIR /app

COPY pom.xml .
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:17-jdk-alpine AS build
ARG JAR_FILE=target/*.jar
COPY --from=stage1 /app/target/rpbackend-0.1.jar rpbackend.jar
ENTRYPOINT [ "java", "-jar", "/rpbackend.jar" ]