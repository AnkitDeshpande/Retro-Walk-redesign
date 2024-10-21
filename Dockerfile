# Base image: OpenJDK 17 (slim version for smaller image size)
FROM openjdk:17-jdk-slim

# ARG to pass the jar file and other build-time configurations
ARG JAR_FILE
ARG BASE_JAR_FILE
ARG BASE_DIR
ARG APP_ARGS
ARG APP_PORT

# Setting environment variables that will be used at runtime
ENV APP_JAR_FILE=$BASE_JAR_FILE
ENV APP_START_ARGS=$APP_ARGS
ENV APP_START_PORT=$APP_PORT

# Create the base directory inside the container
RUN mkdir -p /app/${BASE_DIR}

# Copy the JAR file into the container's base directory with the specified name
COPY ${JAR_FILE} /app/${BASE_DIR}/${BASE_JAR_FILE}

# Expose the application port to allow outside access to the container (e.g., HTTP requests)
EXPOSE $APP_START_PORT

# Create a 'logs' directory inside the base directory for application logs (if used)
RUN mkdir -p /app/${BASE_DIR}/logs

# Set the working directory for the container (where commands will run from)
WORKDIR /app/${BASE_DIR}

# The main command to run the Spring Boot application
ENTRYPOINT ["java", "$APP_START_ARGS", "-jar", "$APP_JAR_FILE"]
