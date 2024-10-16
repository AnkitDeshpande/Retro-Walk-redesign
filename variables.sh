#!/bin/bash

# Set the RabbitMQ credentials from VM options
export RABBITMQ_USERNAME=retrowalk #${RABBITMQ_USERNAME}
export RABBITMQ_PASSWORD=retrowalk@123 # ${RABBITMQ_PASSWORD}

# Start the Docker Compose service
docker compose down -v
docker compose up -d
