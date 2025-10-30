# Teoría de Maven

## Tabla de Contenidos
- [¿Qué es Maven?](#qué-es-maven)
- [Características Principales](#características-principales)
- [¿Por qué usar Maven?](#por-qué-usar-maven)
- [¿Cuándo usar Maven?](#cuándo-usar-maven)
- [Estructura de Proyecto](#estructura-de-proyecto)
- [Archivo POM](#archivo-pom)
- [Comandos Maven](#comandos-maven)
- [Gestión de Dependencias](#gestión-de-dependencias)
- [Ciclo de Vida de Build](#ciclo-de-vida-de-build)
- [Mejores Prácticas](#mejores-prácticas)
- [Conclusión](#conclusión)

## ¿Qué es Maven?

Maven es una herramienta de gestión y comprensión de proyectos de software. Originalmente desarrollada para proyectos Java, ahora soporta otros lenguajes como C#, Ruby, Scala, etc. Maven simplifica el proceso de construcción, gestión de dependencias, documentación y distribución de proyectos.

**Propósito principal**: Proporcionar una forma completa y estandarizada de gestionar el ciclo de vida completo de un proyecto de software.

## Características Principales

### 1. Convención sobre Configuración
Maven sigue el principio de "convención sobre configuración", lo que significa que utiliza una estructura de proyecto estándar y configuraciones predeterminadas, reduciendo la necesidad de configuración manual.

### 2. Gestión de Dependencias
- Descarga automáticamente las bibliotecas necesarias desde repositorios remotos
- Gestiona el versionado y las transiciones de dependencias
- Resuelve conflictos entre versiones
- Mantiene un repositorio local de dependencias

### 3. Ciclo de Vida de Construcción
Maven define un ciclo de vida de construcción estandarizado con fases predefinidas que se ejecutan en orden específico.

### 4. Arquetipos de Proyecto
Proporciona plantillas predefinidas (arquetipos) para crear proyectos rápidamente:
- `maven-archetype-quickstart` - Proyecto Java simple
- `maven-archetype-webapp` - Aplicación web Java
- `maven-archetype-j2ee-simple` - Proyecto J2EE

### 5. Sistema de Plugins
- Arquitectura basada en plugins para extender funcionalidad
- Plugins para compilación, testing, empaquetado, deployment, etc.

## ¿Por qué usar Maven?

### Ventajas

| Ventaja | Descripción |
|---------|-------------|
| **Estandarización** | Proporciona una estructura de proyecto uniforme |
| **Automatización** | Simplifica tareas repetitivas de construcción |
| **Gestión de Dependencias** | Maneja automáticamente las bibliotecas externas |
| **Extensibilidad** | Permite agregar funcionalidades mediante plugins |
| **Documentación** | Genera documentación automáticamente |
| **Integración** | Se integra bien con IDEs y herramientas CI/CD |
| **Reutilización** | Facilita la reutilización de componentes entre proyectos |

### Comparación con otras herramientas

| Herramienta | Ventajas | Desventajas |
|-------------|----------|-------------|
| **Maven** | Convenciones, amplia adopción, maduro | Configuración XML verbosa |
| **Gradle** | Flexibilidad, performance, DSL conciso | Curva de aprendizaje más pronunciada |
| **Ant** | Máxima flexibilidad, control total | Configuración manual extensa |

## ¿Cuándo usar Maven?

### Casos de Uso Ideales ✅

1. **Proyectos Java Enterprise**
2. **Aplicaciones con múltiples dependencias**
3. **Proyectos que requieren builds reproducibles**
4. **Equipos que necesitan estandarización**
5. **Proyectos que serán compartidos o open-source**
6. **Entornos corporativos con repositorios privados**

### Cuándo considerar alternativas ❌

1. Proyectos muy simples con pocas dependencias
2. Proyectos que requieren builds altamente personalizados
3. Proyectos multi-lenguaje que no son principalmente Java
4. Cuando se necesita máximo performance en builds
5. Proyectos con configuraciones de build muy dinámicas

## Estructura de Proyecto Maven

```
proyecto/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/          # Código fuente principal
│   │   ├── resources/     # Recursos (properties, XML, etc.)
│   │   └── webapp/        # Contenido web (para WAR)
│   └── test/
│       ├── java/          # Código de pruebas
│       └── resources/     # Recursos para pruebas
└── target/                # Archivos generados (compilados, jars)
```

## Archivo POM

El `pom.xml` (Project Object Model) es el corazón de un proyecto Maven:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    <modelVersion>4.0.0</modelVersion>
    
    <!-- Información básica del proyecto (GAV) -->
    <groupId>com.miempresa</groupId>
    <artifactId>mi-proyecto</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    
    <!-- Metadatos -->
    <name>Mi Proyecto</name>
    <description>Descripción del proyecto</description>
    
    <!-- Propiedades -->
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <!-- Dependencias -->
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.0</version>
        </dependency>
    </dependencies>
    
    <!-- Build configuration -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## Comandos Maven

### Comandos Básicos

```bash
# Compilar proyecto
mvn compile

# Ejecutar pruebas
mvn test

# Empaquetar proyecto
mvn package

# Instalar en repositorio local
mvn install

# Limpiar proyecto (elimina target/)
mvn clean

# Ejecutar múltiples fases
mvn clean compile package

# Compilar saltando pruebas
mvn compile -DskipTests
```

### Comandos de Desarrollo

```bash
# Crear nuevo proyecto desde arquetipo
mvn archetype:generate -DgroupId=com.miempresa \
                       -DartifactId=mi-proyecto \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DinteractiveMode=false

# Ejecutar aplicación principal
mvn exec:java -Dexec.mainClass="com.miempresa.App"

# Generar sitio de documentación
mvn site

# Actualizar dependencias
mvn versions:display-dependency-updates
```

### Comandos Avanzados

```bash
# Ejecutar pruebas específicas
mvn test -Dtest=MiClaseTest

# Ejecutar con perfil específico
mvn package -P production

# Ver árbol de dependencias
mvn dependency:tree

# Analizar dependencias no utilizadas
mvn dependency:analyze
```

## Gestión de Dependencias

### Ámbitos (Scopes) de Dependencias

| Scope | Descripción | Ejemplo |
|-------|-------------|---------|
| **compile** | Por defecto, disponible en todos los classpaths | `spring-core` |
| **provided** | Proporcionado por el contenedor en tiempo de ejecución | `servlet-api` |
| **runtime** | Necesario en tiempo de ejecución pero no para compilar | `JDBC driver` |
| **test** | Solo para testing | `junit` |
| **system** | Similar a provided pero debe proporcionar el JAR explícitamente | Herramientas internas |
| **import** | Importa dependencias desde otro POM | BOMs |

### Repositorios

- **Local**: `~/.m2/repository` - Dependencias descargadas localmente
- **Central**: `repo.maven.apache.org` - Repositorio público principal
- **Empresarial**: Repositorios internos (Nexus, Artifactory, Archiva)

### Ejemplo de Gestión de Dependencias

```xml
<dependencies>
    <!-- Dependencia de compilación -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.0</version>
    </dependency>
    
    <!-- Dependencia proporcionada por el contenedor -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
    
    <!-- Dependencia de testing -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Ciclo de Vida de Build

### Fases Principales

| Fase | Descripción |
|------|-------------|
| **validate** | Valida que el proyecto es correcto |
| **compile** | Compila el código fuente del proyecto |
| **test** | Ejecuta las pruebas usando un framework adecuado |
| **package** | Empaqueta el código compilado en su formato distribuible |
| **verify** | Ejecuta cualquier verificación sobre los resultados de las pruebas |
| **install** | Instala el paquete en el repositorio local |
| **deploy** | Copia el paquete final al repositorio remoto |

### Relación entre Fases

```
clean → validate → compile → test → package → verify → install → deploy
```

### Plugins Comunes

| Plugin | Propósito |
|--------|-----------|
| `maven-compiler-plugin` | Compilación de código Java |
| `maven-surefire-plugin` | Ejecución de pruebas unitarias |
| `maven-failsafe-plugin` | Ejecución de pruebas de integración |
| `maven-jar-plugin` | Creación de archivos JAR |
| `maven-war-plugin` | Creación de archivos WAR |
| `maven-site-plugin` | Generación de documentación |

## Mejores Prácticas

### 1. Versionado Semántico
Usar versionado semántico: `MAJOR.MINOR.PATCH`
- **MAJOR**: Cambios incompatibles en la API
- **MINOR**: Nuevas funcionalidades compatibles
- **PATCH**: Correcciones de bugs compatibles

### 2. Gestión de Plugins
Definir versiones de plugins en la sección `pluginManagement`:

```xml
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```

### 3. Uso de Perfiles
Usar perfiles para diferentes entornos:

```xml
<profiles>
    <profile>
        <id>development</id>
        <properties>
            <environment>dev</environment>
        </properties>
    </profile>
    <profile>
        <id>production</id>
        <properties>
            <environment>prod</environment>
        </properties>
    </profile>
</profiles>
```

### 4. Múltiples Módulos
Para proyectos grandes, dividir en módulos usando un POM padre:

```
parent-project/
├── pom.xml
├── module-a/
│   └── pom.xml
├── module-b/
│   └── pom.xml
└── module-web/
    └── pom.xml
```

### 5. Propiedades y Variables
Usar propiedades para valores reutilizables:

```xml
<properties>
    <java.version>11</java.version>
    <spring.version>5.3.0</spring.version>
    <junit.version>5.7.0</junit.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>
```

### 6. Gestión de Dependencias
Usar `dependencyManagement` para controlar versiones:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-framework-bom</artifactId>
            <version>5.3.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## Conclusión

Maven es una herramienta poderosa que, cuando se usa correctamente, puede simplificar significativamente el desarrollo y mantenimiento de proyectos Java. Su enfoque basado en convenciones y su ecosistema maduro lo convierten en una excelente opción para la mayoría de proyectos empresariales.

### Resumen de Beneficios
- ✅ **Estandarización** en estructura y procesos
- ✅ **Automatización** de tareas repetitivas
- ✅ **Gestión eficiente** de dependencias
- ✅ **Integración** con ecosistema Java
- ✅ **Extensibilidad** mediante plugins
- ✅ **Documentación** automática

Aunque herramientas más modernas como Gradle han ganado popularidad, Maven sigue siendo ampliamente utilizado y es una habilidad valiosa para cualquier desarrollador Java. Su curva de aprendizaje inicial se ve compensada por la productividad ganada a largo plazo en proyectos mantenibles y bien estructurados.

### Recursos Adicionales
- [Documentación Oficial de Maven](https://maven.apache.org/guides/)
- [Maven Central Repository](https://search.maven.org/)
- [Maven en 5 minutos](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)