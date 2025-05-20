FROM openjdk:21
COPY "./target/TallerFutbolClub-1.jar" "app.jar"
EXPOSE 8085
ENTRYPOINT [ "java", "-jar", "app.jar" ]