# SIGECAP
Sistema de Gestion de Capacitaciones
Proyecto desarrollado como parte del botcamp Fundamentos DevOps 
<br><br>
## Una plataforma de Gestion de Capacitaciones
Aplicacion desarrollada en Spring Boot 3. Cuenta con un sistema de inicio de sesion con tecnologia JWT.  
El proyecto incluye archivos de configuracion para el pipeline en Jenkins, asi como archivos para su despliegue con Docker Compose.  
El pipeline de Jenkins incluye integracion con Kubernetes.
<br><br>
## Requisitos para ejecutar la aplicacion
Para ejecutar la aplicacion, existen 3 caminos: ejecutar como una aplicacion Spring Boot con Maven, como contenedor con Docker y como contenedor dentro de un cluster de Kubernetes.  

### Aplicacion Spring Boot
Se requiere contar con `Java 22` y `Maven 3.9`. Tambien se requiere de una base de datos `Postgres`<sup>*</sup> para la ejecucion de la aplicacion.  
La aplicacion se encarga de inicializar los datos de prueba de ser requeridos (esto debe ser configurado en las variables de entorno).

### Contenedor de Docker
Se requiere contar con Docker instalado.  
Al utilizar el comando `docker compose up -d` en la ruta raiz, este se encargara de crear el contenedor con toda la configuracion necesaria. Se requiere indicar las variables de entorno a traves de un archivo `.env` o en la linea de comandos. Para utilizar las variables de ejemplo, utilice el comando:
```bash
docker compose --env-file .env.example up -d
```

### Despliegue en Kubernetes
Se requiere contar con un cluster de Kubernetes ya configurado.
Se deben desplegar los archivos `configmap.yml` y `deployment.yml`, contenidos en la carpeta `k8s`. En el caso de configmap.yml, este puede ser reemplazado por variables de entorno, realizando el cambio respectivo en deployment.yml.  
Este proyecto esta optimizado para trabajar con minikube. Se requiere crear un namespace para el despliegue de la aplicacion, para hacer esto se utiliza el comando:
```bash
kubectl create namespace sigecap-ns
```
Para realizar el despliegue, ubicandose en la carpeta `k8s` se debe ejecutar el comando:
```bash
kubectl apply -f configmap.yml
```
Luego:
```bash
kubectl apply -f deployment.yml
```
Una vez se realiza el despliegue, es necesario ejecutar el comando:
```bash
minikube tunnel
```
el cual es requerido por minikube para que el Load Balancer que gestiona la aplicacion este disponible para acceder desde el host.
<br><br>
## Monitoreo con ELK
Se incluye una implementacion demo del stack ELK (Elasticsearch, Logstash y Kibana) para el monitoreo de la aplicacion. Para ejecutar esta implementacion, ubicandose en la ruta `logging/ELK/`, se requiere ejecutar el comando (previamente, debe estar desplegada la aplicacion con Docker Compose):
```bash
docker compose up -d
```
Luego de aproximadamente 3 minutos de ejecutado el despliegue, se puede acceder a Kibana en http://localhost:5601/ para acceder al monitoreo. Se incluye un dashboard por defecto para demostracion.
<br><br>
## Datos de prueba y variables de entorno
El proyecto incluye datos de prueba contenidos en la ruta `src/main/resources/data.sql`, los cuales incluyen 2 administradores, 41 alumnos, 20 tutores y 21 capacitaciones. Estos estan disponibles para efectos de prueba, por lo que no contienen informacion real y en el caso de usuarios, las contraseñas son la misma: `Sigecap123`. En el caso de las capacitaciones, estas se encuentran entre el periodo septiembre-octubre de 2024.
En cuanto a las variables de entorno, se incluye el archivo `.env.example` que incluye variables de entorno de pruebas para un despliegue rapido de la aplicacion. Todas estas variables son requeridas para el funcionamiento.
<br><br>
> _<sup>*</sup>La aplicacion esta optimizada para trabajar con Postgres, sin embargo, tambien se puede ejecutar con MySQL, realizando los respectivos cambios en variables de entorno y docker-compose.yml_