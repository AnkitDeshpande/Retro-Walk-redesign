# Base image: OpenJDK 17 (slim version for smaller image size)
FROM openjdk:17-jdk-slim

# ARG to pass the jar file and other build-time configurations
# These are build-time arguments that will be passed during the docker build command
# 1. The path to the JAR file that will be packaged into the Docker image
ARG JAR_FILE

# 2. The name of the JAR file once copied into the container
ARG BASE_JAR_FILE

# 3. The base directory inside the container where the JAR file will be copied
ARG BASE_DIR

# 4. Optional application arguments to be passed during startup (like JVM options)
ARG APP_ARGS

# 5. The port the application will listen on (exposed by the container)
ARG APP_PORT

# Setting environment variables that will be used at runtime
# 1. Setting the JAR file name as an environment variable
ENV APP_JAR_FILE=$BASE_JAR_FILE

# 2. Setting the application start arguments as an environment variable
ENV APP_START_ARGS=$APP_ARGS

# 3. Setting the application port as an environment variable
ENV APP_START_PORT=$APP_PORT

# Create the base directory inside the container
RUN mkdir /${BASE_DIR}

# Copy the JAR file into the container's base directory with the specified name
COPY ${JAR_FILE} /${BASE_DIR}/${BASE_JAR_FILE}

# Expose the application port to allow outside access to the container (e.g., HTTP requests)
EXPOSE $APP_START_PORT

# Create a 'logs' directory inside the base directory for application logs (if used)
RUN mkdir -p /${BASE_DIR}/logs

# Set the working directory for the container (where commands will run from)
WORKDIR /${BASE_DIR}

# The main command to run the Spring Boot application
# Uses the java command with any passed arguments, and runs the specified JAR file
ENTRYPOINT java $APP_START_ARGS -jar $APP_JAR_FILE

