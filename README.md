# BeekeepingApi
Spring REST Api for "Beekeeping" project.

# Docker Deployment
Create .jar file.
> gradlew clean jar

Build docker image.
> docker build -t beekeeping-api:latest .

Run docker compose.
> docker compose up
