FROM openjdk:8-jdk-alpine
#COPY target/restlet-app-1.1-jar-with-dependencies.jar restlet-app-1.1-jar-with-dependencies.jar
#ENTRYPOINT java -jar restlet-app-1.1-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar"]
