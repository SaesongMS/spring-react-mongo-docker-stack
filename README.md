# spring-react-mongo-docker-stack

This Docker stack is a simple example of how to run a Spring Boot, React, and MongoDB in Docker containers. The stack is composed of the following components:
- Spring Boot 3.1.4 as the backend
- React as the frontend
- MongoDB as the database
- Additional MongoDB container for seeding the database with data

It also includes the following features:
- Authentication and authorization with JWT token
- Admin panel for managing exporting/importing data from/to database to/from JSON file
- Charts for visualizing data
- List of movies/anime filtered by genre
- Data is obtained from external APIs. You can find the documentations for them here: https://rapidapi.com/SAdrian/api/moviesdatabase/details and https://docs.api.jikan.moe/
- List of watched/planned to watch movies/anime for each user, with the ability to add/remove them from the list and change them to the opposite list

## Installation
The instructions assume that you have already installed Docker and Docker Compose.

In order to get started be sure to clone this project onto your Docker Host. Create a directory on your host. Please note that the demo webservices will inherit the name from the directory you create. If you create a folder named test. Then the services will all be named test-web, test-redis, test-lb.

### Clone the project
```
git clone https://github.com/SaesongMS/spring-react-mongo-docker-stack.git
```

### Build and run the project
```
docker-compose up --build
```
If you encounter an error during docker-compose up, try to change file type of mvnw to Unix format. You can do it in VS Code, by clicking on CRLF in the bottom right corner and selecting LF.

After the build is complete, you should be able to access the application at http://localhost:3000.

Database contains two created users:
- username: admin, password: 123456 - admin user
- username: user, password: 123456 - regular user

List of endpoints can be found in [backend/README.md](backend/README.md)

## Views of the application

|![login page](examples/login.JPG)|
|:--:|
|*Login page*|

|![register page](examples/register.JPG)|
|:--:|
|*Register page*|

|![home page](examples/home.JPG)|
|:--:|
|*Home page*|

|![genre chart](examples/genre-chart.JPG)|
|:--:|
|*Genre chart*|

|![list of movies by genre](examples/genre-movies.JPG)|
|:--:|
|*List of movies by genre*|

|![admin panel](examples/admin-panel.PNG)|
|:--:|
|*Admin panel*|

|![list of watched/planned](examples/list.JPG)|
|:--:|
|*List of watched/planned*|

|![add to list](examples/list_add.jpg)|
|:--:|
|*Add to list*|

|![edit element in list](examples/list_edit.JPG)|
|:--:|
|*Edit element in list*|

This project was created and maintained by [SaesongMS](https://github.com/SaesongMS), [Bobozia](https://github.com/Bobozia) and [70masz](https://github.com/70masz)
