FROM openjdk:11.0-oracle
COPY "./target/initial-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "app.jar"]