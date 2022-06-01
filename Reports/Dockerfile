FROM openjdk:11.0.9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lab.jar
CMD ["java","-jar","lab.jar"]
