# Solicitud de crédito de un vehículo

## Descripción

Este proyecto implementa un motor de workflow con Camunda, automatizando el proceso de solicitud de crédito para vehículo en Colombia. El proceso inicia cuando un solicitante, mayor de edad y con capacidad legal, decide adquirir un vehículo mediante financiación. El sistema gestiona la recopilación de documentos necesarios, evalúa el historial crediticio y la capacidad de pago del solicitante, y determina la aprobación del crédito y sus condiciones.

---

## Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

- **Java JDK 20**
    - Para verificar la versión de Java, se debe ejecutar `java -version` en la terminal. Si es necesario instalar Java, se puede visitar la [página oficial de Oracle](https://www.oracle.com/java/technologies/javase-jdk20-downloads.html) para descargar e instalar el JDK.
- **Maven 3.6 o superior**
    - Para comprobar si Maven está instalado, se debe ejecutar `mvn -v` en la terminal. Si es necesario instalar Maven, se debe seguir las instrucciones en la [página oficial de Maven](https://maven.apache.org/install.html).
- **Git**
    - Para clonar el repositorio, es necesario tener Git instalado. Para verificarlo, se puede ejecutar  `git --version`. Si es necesario instalar Git, se pueden seguir las instrucciones en la [página oficial de Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).
  - **Node.js**
    - Para verificar si Node.js está instalado, se debe ejecutar `node -v` en la terminal. Si es necesario instalar Node.js, se puede visitar la [página oficial de Node.js](https://nodejs.org/es/download/) para descargar e instalar la versión LTS.

---

## Configuración Inicial

### Clonar el Repositorio

Para obtener una copia del repositorio Git mediante comandos, seguir estos pasos:

```bash
git clone https://github.com/Cristian-Infante/Proyecto-Camunda.git
cd Proyecto-Camunda
```

En caso de que se prefiera descargar el repositorio como un archivo `.zip`, se puede hacer clic en el botón azul "Code" en la página del repositorio y seleccionar "Download ZIP". Luego, descomprimir el archivo descargado y acceder al directorio del proyecto.
```bash
cd Proyecto-Camunda-CFIC
```


### Instalar Dependencias y Construir el Proyecto

Una vez obtenido el código fuente, y estando en el directorio del proyecto y ejecutar:

```bash
mvn clean install
```

Este comando realiza lo siguiente:
- **mvn clean**: Elimina la carpeta `target`, asegurando que no haya residuos de construcciones anteriores.
- **mvn install**: Descarga todas las dependencias necesarias y compila el proyecto, creando el archivo `.jar` necesario para ejecutar la aplicación.

---

## Ejecución del Proyecto

### Iniciar la Aplicación

Para iniciar el proyecto, se debe ejecutar el siguiente comando en el directorio raíz del proyecto:

```bash
java -jar target/Proyecto-1.0.0-SNAPSHOT.jar
```

### Iniciar el Worker

Para iniciar el worker encargado del envío de mensajes, se deben ejecutar los siguientes comandos:

1. Entrar a la carpeta `worker` dentro del proyecto: `cd worker`
2. Ejecutar el comando: `npm i`
3. Ejecutar el comando: `node .\sendStatus.js`

## Verificación de la Instalación

Para asegurar que el proyecto se está ejecutando correctamente, se debe acceder al dashboard de Camunda y realizar una prueba simple:

### Acceso al Dashboard de Camunda

El dashboard de Camunda se puede acceder a través de:

```
http://localhost:8082/camunda/app/welcome/default/#!/login
```

Utilizar las siguientes credenciales predeterminadas para iniciar sesión:

- **Username:** `demo`
- **Password:** `demo`

### Realizar una Prueba Simple

Entrar al tasklist y crear una nueva tarea de usuario. Para ello, seguir estos pasos:
1. 
2. Dar clic en el botón `Start process` que se encuentra en la esquina superior derecha.
3. Seleccionar el proceso `Solicitud de Crédito de Vehículo`.
4. Ingresar los datos solicitados y dar clic en `Start`.
5. Actualizar la lista de tareas y seleccionar la tarea creada `Recibir Solicitud`.
6. Dar clic en `Claim` para asignar la tarea al usuario, ingresar los datos solicitados y dar clic en `Complete`.
7. Ahora, van a aparecer las tareas `Verificar historial crediticio`, `Verificar RUT` y dependiendo de la situación laboral escogida anteriormente `Verificar certificado laboral`, `Verificar declaración de impuestos` y `Verificar comprobante de pago de pensión`. En cada una de estas tareas se debe dar clic en `Claim`, seleccionar el estado de los documentos y dar clic en `Complete`.
8. En caso de cumplir con los requisitos, se debe dar clic en `Claim` en la tarea `Entregar contrato de crédito`, revisar el número de cuotas y el porcentaje de interesés, después, dar clic en `Complete`.

- En caso de que sea rechazada o cancelada la solicitud aparecerá una tarea explicando el motivo.

---

## Documentación y Recursos Adicionales

- [Documentación de Camunda BPM](https://docs.camunda.org)
- [Documentación de Spring Boot](https://spring.io/projects/spring-boot)
