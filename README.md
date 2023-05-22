# spring-data-jpa-sample

A sample spring-boot application that shows off `spring-data-jpa` capabilities. It also shows an example of integration with `flyway` DB migrations.

### Building

JDK 17+ is required to run: 

```
./gradlew clean build
```

### Running

For an in-memory H2 database, just run the application:

```
java -jar build/libs/spring-data-jpa-sample-0.0.1-SNAPSHOT.jar 
```

To run with a local PostgresSQL DB, run with `localpostgres` spring profile


```
SPRING_PROFILES_ACTIVE=localpostgres java -jar build/libs/spring-data-jpa-sample-0.0.1-SNAPSHOT.jar
```

For the above to work, start a PostgresSQL instance in docker like so:

```
docker run --name postgres -e POSTGRES_PASSWORD=my-secret-pw -d -p 15432:5432 postgres:15
```

If connecting to a different PostgresSQL database, the DB connection properties defined in [src/main/resources/application-localpostgres.yml](src/main/resources/application-localpostgres.yml) might have to be adjusted.

