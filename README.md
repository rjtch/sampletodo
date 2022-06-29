# Sample Todo


Sample Todo is a microservice application aiming to demonstrate the use of rabbitmq and databases such as MongoDB and Postgres.

## Features

- User-service managing user data
- Todo-service for to-do tasks created by the user.
- Notification-service who get informed by the todo-service when something new happens.
- [MongoDB] database for the todos.
- [Postgres] database for managing users and notifications.


## Tech

For running the application you need:

- [Openjdk 18] 
- [Maven 3]
- [Docker]


## Running the application locally

To run this application docker is needed or any other container manager such as [Rancher]. To run it navigate to the root directory
and run to following command:

```sh
docker-compose up --build
```

## Development

This project is in developement and more features will be added. 

## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Openjdk 18]: <https://openjdk.org/projects/jdk/18/>
[Maven 3]: <https://maven.apache.org/docs/3.0/release-notes.html>
[Docker]: <https://www.docker.com/>
[MongoDB]: <https://www.mongodb.com/>
[Postgres]: <https://www.postgresql.org/>
[Rancher]: <https://rancher.com/>