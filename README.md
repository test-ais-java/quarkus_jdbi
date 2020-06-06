# quarkus-jdbi-project project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

# Starting Postgres database
Change directory to ./docker/postgres

Start docker-compose: 
```text
docker-compose up
```

You should see confirmation that postgres started

# Create Fruit ( sample entity ) table inside the postgres

Connect to `adminer` : `http://localhost:18080/`

Connect to Postgres database using `postgres`/`example` as `user`/`password` credentials

Create `fruit` database.

Create `fruit` table:

```text
Column	Type	Comment
uuid	character varying(256)	
name	character varying	
description	character varying	
```
# Import postman collection into Postman
Postman collection is located in `./postman` directory

# After that you can start application

## Running application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

# Using appliction
Open up collection in Postman. 

It has a number of CRUD methods defined along with pre-defined `POST`

You should be able to examine application from that point using different REST methods.

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `quarkus-jdbi-project-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-jdbi-project-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/quarkus-jdbi-project-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .# quarkus-jdbi-project
