FROM openjdk:17-jdk
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/Payroll-API-0.0.1-SNAPSHOT.jar"]