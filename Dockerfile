# Etapa de build: usa Maven + JDK para compilar el proyecto
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar pom y wrapper para aprovechar cache de capas
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Descargar dependencias para cache
RUN mvn -B -ntp dependency:go-offline

# Copiar el código fuente y compilar (por defecto se omiten tests)
COPY src ./src
RUN mvn -B -DskipTests package

# Etapa runtime: imagen ligera con JRE
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=target/*.jar
# Copiar el artefacto generado desde la etapa de build
COPY --from=build /app/${JAR_FILE} /app/app.jar

# Puerto por defecto. En Render se usará la variable PORT y localmente 8080.
EXPOSE 8080

# Opcional: ajuste de memoria vía JAVA_OPTS
ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]

