#Dockerfile for payslip project
#Raspberry-PI image
FROM eclipse-temurin:17-jdk

WORKDIR /clipboard

COPY target/clipboard-0.0.1-SNAPSHOT.jar /app/clipboard.jar

ENTRYPOINT ["java", "-jar", "/app/clipboard.jar"]