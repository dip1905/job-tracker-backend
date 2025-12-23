# Step 1: Use official Java 17 image
FROM openjdk:17-jdk-alpine

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Step 4: Copy source code
COPY src ./src

# Step 5: Build the Spring Boot app
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Step 6: Expose port 8080
EXPOSE 8080

# Step 7: Command to run the app
CMD ["java", "-jar", "target/job-tracker-0.0.1-SNAPSHOT.jar"]
