# spring-data-jpa-sample

A sample spring-boot application that shows off `spring-data-jpa` capabilities. It also shows an example of integration with `liquibase` DB migrations.

## Building

JDK 17+ is required to build/run: 

```
./gradlew clean build
```

## Running

### Run with H2 database

For an in-memory H2 database, just run the application:

```
java -jar build/libs/spring-data-jpa-sample-1.0.jar 
```

### Run with MySQL database

To run with a local MySQL, run with `localmysql` spring profile

```
SPRING_PROFILES_ACTIVE=localmysql java -jar \
    build/libs/spring-data-jpa-sample-1.0.jar
```

For the above to work, start a MySQL instance in docker like so:

```
docker run --name mysql \
    -e MYSQL_DATABASE=testdb \
    -e MYSQL_ROOT_PASSWORD=my-secret-pw \
    -d -p 13306:3306 mysql:8 \
    --default-authentication-plugin=mysql_native_password
```

We can replace `mysql:8` with `mysql:5.7` as the docker image name to target a specific MySQL version. Running MySQL 5.7 on M1 mac requires an extra `platform` parameter since that version of docker image is only available for `amd64` platform:

```
docker run --name mysql \
    --platform linux/amd64 \
    -e MYSQL_DATABASE=testdb \
    -e MYSQL_ROOT_PASSWORD=my-secret-pw \
    -d -p 13306:3306 mysql:5.7 \
    --default-authentication-plugin=mysql_native_password
```

If connecting to a different MySQL database, the DB connection properties defined in  [src/main/resources/application-localmysql.yml](src/main/resources/application-localmysql.yml) might have to be adjusted.

### Run with PostgresSQL database

To run with a local PostgresSQL, run with `localpg` spring profile

```
SPRING_PROFILES_ACTIVE=localpg java -jar \
    build/libs/spring-data-jpa-sample-1.0.jar
```

For the above to work, start a PostgresSQL instance in docker like so:

```
docker run --name postgres \
    -e POSTGRES_PASSWORD=my-secret-pw \
    -d -p 15432:5432 postgres:15
```

If connecting to a different PostgresSQL database, the DB connection properties defined in [src/main/resources/application-localpg.yml](src/main/resources/application-localpg.yml) might have to be adjusted.