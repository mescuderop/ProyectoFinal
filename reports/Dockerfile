FROM openjdk:11.0-oracle
COPY "./target/reports-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8003
ENTRYPOINT ["java", "-jar", "app.jar"]