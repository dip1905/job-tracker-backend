# Use official Eclipse Temurin Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Give permission to mvnw
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render provides PORT dynamically)
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
