# Base image: OpenJDK 17 (slim version for smaller image size)
FROM openjdk:17-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Give execution rights to the Gradle wrapper
RUN chmod +x gradlew

# Build the specific module (auth-app)
RUN ./gradlew :auth-app:bootJar

# Stage for the runtime environment
FROM openjdk:17-jdk-slim

# ARG to pass the jar file and other build-time configurations
ARG BASE_JAR_FILE=auth-app-0.0.1-SNAPSHOT.jar
ARG APP_ARGS=""
ARG APP_PORT=8080

# Setting environment variables that will be used at runtime
ENV APP_JAR_FILE=$BASE_JAR_FILE
ENV APP_START_ARGS=$APP_ARGS
ENV APP_START_PORT=$APP_PORT

# Copy the JAR file into the container's base directory with the specified name
COPY --from=build /build/libs/$APP_JAR_FILE $APP_JAR_FILE

# Create the base directory inside the container
RUN mkdir -p /${BASE_DIR}/logs

# Expose the application port to allow outside access to the container (e.g., HTTP requests)
EXPOSE $APP_START_PORT

# Set the working directory for the container (where commands will run from)
WORKDIR /${BASE_DIR}

# The main command to run the Spring Boot application
# Uses the java command with any passed arguments, and runs the specified JAR file
ENTRYPOINT ["java", "-jar", "$APP_JAR_FILE"]
