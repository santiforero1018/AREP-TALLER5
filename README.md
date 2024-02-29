# AREP-TALLER5

## PREREQUISITOS
Estos son los requisitos con los cuales se trabajó este proyecto

1. Docker desktop actualizado
2. Maven
3. Java 17

## MONTAJE Y EJECUCIÓN

### ejecución del proyecto

```bash
java -cp "target/classes;target/dependency/*" edu.eci.arep.taller5.SparkWebServer
```
se usa el puerto PORT = 57000

### Montaje del docker
Dentro de la carpeta taller5, ejecutamos el siguiente comando que usara el Dockerfile

```bash
docker build --tag dockersparkprimer .
```
![ejecución del comando build](README-IMG/docker-build.png)

Luego se pone a correr una serie de contenedores con los siguientes comandos
```bash
docker run -d -p 34000:57000 --name firstdockercontainer dockersparkprimer
docker run -d -p 34001:57000 --name firstdockercontainer2 dockersparkprimer
docker run -d -p 34002:57000 --name firstdockercontainer3 dockersparkprimer
```
![imagen corriendo containers](README-IMG/docker-run.png)

### Usando docker compose u MongoDb

usando el archivo docker-compose.yml y el siguiente comando para componer nuestros containers y un container de MongoDb:
```bash
docker-compose up -d
```
![iamgen containers correindo en el dashboard](README-IMG/dashboard-allContainers.png)
![imagen comando usado](README-IMG/docker-compose.png)

### Subiendo imagen a docker hub
 usamos el siguiente comando mostrado en la imagen para hacer el push, anteriormente damos un tag a la imagen
 ![imagen push](README-IMG/docker-push.png)

* comando usado para el tag
  ```
  docker tag dockersparkprimer foreman1018/arep-taller5 
  ```
## EJERCICIO PARA DOCKER, MODIFICACION DE PROYECTO CON SERVICIOS REST
Se modifico la clase de **SpartWebServer.java** para que retorne diferentes servicios para realizar dichas operaciones:
![ejemplo codigo](README-IMG/basic-code.png)

y siguiendo esta estructura, se añadieron los diferentes servicios.

Luego se volvió a crear la imagen correspondiente en docker para montar un contenedor con el servidor java funcionando
![build 2](README-IMG/docker-build(2).png)

Ademas, con esta modificacion, se volvió a crear la composición de contenedores
![segundo compose](README-IMG/docker-compose(2).png)

como prueba de ello, se muestra el resultado final de los contenedores montados:
![final containers](README-IMG/final-Containers.png)

y el resultado se sube a ![Docker Hub](https://hub.docker.com/)
![final push](README-IMG/push-final)
### Servicio para calcular Sin
### Servicio para calcular Cos
### Servicio para Calcular palindormos
### Servicio para calcular la magnitud de un vector
## AUTOR
Santiago Forero Yate, Estudiante de ingeneria de Sistemas
