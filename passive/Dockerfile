FROM openjdk:11.0-oracle
COPY "./target/passive-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "app.jar"]