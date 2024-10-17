# SIGECAP
Sistema de Gestion de Capacitaciones
Proyecto desarrollado como parte del botcamp Fundamentos DevOps 

## Una plataforma de Gestion de Capacitaciones
Aplicacion desarrollada en Spring Boot 3. Cuenta con un sistema de inicio de sesion con tecnologia JWT.  
El proyecto incluye archivos de configuracion para el pipeline en Jenkins, asi como archivos para su despliegue con Docker Compose.  
El pipeline de Jenkins incluye integracion con Kubernetes.

## Requisitos para ejecutar la aplicacion
Para ejecutar la aplicacion, existen 3 caminos: ejecutar como una aplicacion Spring Boot con Maven, como contenedor con Docker y como contenedor dentro de un cluster de Kubernetes.  

### Aplicacion Spring Boot
Se requiere contar con Java 22 y Maven 3.9. Tambien se requiere  de una base de datos Postgres para la ejecucion de la aplicacion.  
La aplicacion se encarga de inicializar los datos de prueba de ser requeridos.

### Contenedor de Docker
Se requiere contar con Docker instalado.  
Al utilizar el comando `docker compose up -d` en la ruta raiz, este se encargara de crear el contenedor con toda la configuracion necesaria. Se requiere indicar las variables de entorno a traves de un archivo .env o en la linea de comandos. Para utilizar las variables de ejemplo, utilice el comando `docker compose --env-file .env.example up -d`

### Despliegue en Kubernetes
Se requiere contar con un cluster de Kubernetes ya configurado.
Se deben desplegar los archivos configmap.yml y deployment.yml, contenidos en la carpeta k8s. En el caso de configmap.yml, este puede ser reemplazado por variables de entorno, realizando el cambio respectivo en deployment.yml.

