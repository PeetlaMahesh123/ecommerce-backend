FROM maven:3.9.9-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests=true

EXPOSE 8080

CMD ["java", "-jar", "target/ecommerce-backend-0.0.1-SNAPSHOT.jar"]