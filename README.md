# AREP-TALLER5

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
![ejecución del comando build]("README-IMG/docker-build")

Luego se pone a correr una serie de contenedores con los siguientes comandos
```bash
docker run -d -p 34000:57000 --name firstdockercontainer dockersparkprimer
docker run -d -p 34001:57000 --name firstdockercontainer2 dockersparkprimer
docker run -d -p 34002:57000 --name firstdockercontainer3 dockersparkprimer
```
![imagen corriendo containers]("README-IMG/docker-run")

### Usando docker compose u MongoDb

usando el archivo docker-compose.yml y el siguiente comando para componer nuestros containers y un container de MongoDb:
```bash
docker-compose up -d
```
![iamgen containers correindo en el dashboard]("README-IMG/dashboard-allContainers")
![imagen comando usado](README-IMG/docker-compose)

### Subiendo imagen a docker hub
 usamos el siguiente comando mostrado en la imagen para hacer el push, anteriormente damos un tag a la imagen
 ![imagen push]("README-IMG/docker-push")

* comando usado para el tag
  ```
  docker tag dockersparkprimer foreman1018/arep-taller5 
  ```

## AUTOR
Santiago Forero Yate, Estudiante de ingeneria de Sistemas
