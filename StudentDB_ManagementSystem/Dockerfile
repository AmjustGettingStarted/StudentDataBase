# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

# Use an official Tomcat image to run the project
FROM tomcat:9.0.53-jdk11
COPY --from=build /app/target/your-app.war /usr/local/tomcat/webapps/
