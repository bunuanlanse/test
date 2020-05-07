FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/ipDetails.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
