FROM openjdk:11.0.9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patient.jar
CMD ["java","-jar","patient.jar"]
