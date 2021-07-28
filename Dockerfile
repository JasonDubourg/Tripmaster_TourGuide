FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tourguide.jar
ENTRYPOINT ["java","-jar","/tourguide.jar"]