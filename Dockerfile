FROM gradle:8.8.0-jdk21
COPY build/libs/rapid-ticket-ms-0.0.1-SNAPSHOT.jar rapid-ticket-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "rapid-ticket-ms-0.0.1-SNAPSHOT.jar"]