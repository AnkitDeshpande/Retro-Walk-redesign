FROM openjdk:17-jdk-slim AS build
COPY . /app
WORKDIR /app
RUN ./gradlew bootJar
RUN mv -f build/libs/*.jar app.jar

FROM openjdk:17-jdk-slim
ARG APP_PORT
ENV PORT=${APP_PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]