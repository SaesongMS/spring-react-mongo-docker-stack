# Spring Boot Login and Registration example with MongoDB

## Run Spring Boot application
```bash
mvn spring-boot:run
```

## Running database only
If you want to run only the database without using docker compose, you can do it by running the following commands:
```bash
docker run -d --name mongo -p 27018:27017 mongo:latest
docker exec -it mongo bash
mongosh
use db
db.roles.insertMany([ { name: "ROLE_USER" }, { name: "ROLE_MODERATOR" }, { name: "ROLE_ADMIN" },])
```
Registration and login will not work without the roles in the database.

## Endpoints
http://localhost:8080/api/
- test/all - test for connection

### Authentication
- auth/signin, POST, body: { username, password }
- auth/signup, POST, body: { username, email, password, fullName }

### Anime
- anime/top_api, GET, admin only
- anime/top, GET
- anime/animes-by-genre, GET, params: genre
- anime/top3, GET
- anime/addJSON, POST, admin only, file
- anime/getJSON, GET, admin only

### Movie
- movies/top_api, GET, admin only
- movies/top, GET
- movies/movies-by-genre, GET, params: genre
- movies/top3, GET

### List
- list/add/planned, POST, user only, body: { id, subject }
- list/add/watched, POST, user only, body: { id, subject }
- list/delete/planned, POST, user only, body: { id, subject }
- list/delete/watched, POST, user only, body: { id, subject }
- list/get/planned, GET, user only, body: { id }
- list/get/watched, GET, user only, body: { id }
- list/get/all, GET, user only, body: { id }

