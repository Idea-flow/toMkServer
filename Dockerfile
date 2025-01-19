FROM openjdk:8

ADD ./target/article_to_markdown.jar /article_to_markdown.jar


EXPOSE 9998


ENTRYPOINT ["java", "-jar", "/article_to_markdown.jar"]
