FROM openjdk:8
MAINTAINER asllani94@gmail.com
COPY target/assigment-*.jar assigment-app.jar
ENTRYPOINT ["java","-jar","/assigment-app.jar"]