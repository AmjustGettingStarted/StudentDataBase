# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY StudentDB_ManagementSystem/pom.xml /app/
COPY StudentDB_ManagementSystem/src /app/src
RUN mvn clean install

# Use an official Tomcat image to run the project
FROM tomcat:9.0.53-jdk11
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/
