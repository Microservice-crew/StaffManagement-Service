FROM openjdk:8
EXPOSE 8082
ADD target/Staff-Management-0.0.1-SNAPSHOT.jar Staff.jar
ENTRYPOINT ["java", "-jar", "Staff.jar"]
