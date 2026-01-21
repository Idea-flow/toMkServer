# Build stage: use a maintained JDK with Maven to produce the jar
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# Run stage: lightweight JRE image
FROM eclipse-temurin:17-jre-jammy
COPY --from=build /app/target/article_to_markdown.jar /article_to_markdown.jar
EXPOSE 7860
ENTRYPOINT ["java", "-Dspring.profiles.active=h2", "-jar", "/article_to_markdown.jar"]
