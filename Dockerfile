FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/ecommerce-backend-0.0.1-SNAPSHOT.jar"]