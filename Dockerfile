FROM eclipse-temurin:17-jdk-alpine
COPY out/artifacts/BeekeepingApi_jar/BeekeepingApi.jar .
CMD ["java", "-jar", "BeekeepingApi.jar"]