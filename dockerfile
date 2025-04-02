# Primera etapa: Construcción de la aplicación
FROM maven:3.8.6-eclipse-temurin AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y resuelve dependencias antes de copiar el código fuente
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente y compila
COPY src ./src
RUN mvn clean package -DskipTests

# Segunda etapa: Imagen final con OpenJDK
FROM eclipse-temurin:21-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto donde corre la aplicación
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
