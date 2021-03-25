# spring-data-jpa-sample

A sample spring-boot application that shows off `spring-data-jpa` capabilities. It also shows an example of integration with `flyway` DB migrations.

### Building

JDK 11 is required to run: 

```
./gradlew clean build
```

### Running

For an in-memory H2 database, just run the application:

```
java -jar build/libs/spring-data-jpa-sample-0.0.1-SNAPSHOT.jar 
```

To run with a local MySQL DB, run with `localmysql` spring profile

```
SPRING_PROFILES_ACTIVE=localmysql java -jar build/libs/spring-data-jpa-sample-0.0.1-SNAPSHOT.jar
```

For the above to work, the DB connection properties defined in [src/main/resources/application-localmysql.yml](src/main/resources/application-localmysql.yml) might have to be adjusted. For the above to work without any change, start a MySQL instance in docker like so:

```
docker run --name mysql -e MYSQL_DATABASE=testdb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -p 13306:3306 mysql:latest
```
