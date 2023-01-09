FROM java:8
COPY ./todo-list.jar /todo-list.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/todo-list.jar", "--spring.profiles.active=prod"]