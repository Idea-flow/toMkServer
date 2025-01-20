FROM openjdk:17-jdk-slim

ADD ./target/article_to_markdown.jar /article_to_markdown.jar


EXPOSE 9998


ENTRYPOINT ["java", "-Dspring.profiles.active=h2","-jar", "/article_to_markdown.jar"]
