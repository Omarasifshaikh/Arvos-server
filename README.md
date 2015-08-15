#Arvos Server [![Build Status](https://travis-ci.org/Omarasifshaikh/Arvos-server.svg?branch=master)](https://travis-ci.org/Omarasifshaikh/Arvos-server)


<B>ARVOS</B> - <B>A</B>ugmented <B>R</B>eality <B>V</B>iewer <B>O</B>pen <B>S</B>ource -  http://www.arvos-app.com/


Main Repository: https://github.com/ARVOS-APP/ARVOS

running instructions:

`./gradlew build && java -jar build/libs/arvos-server-0.1.0.jar`


Travis CI supported [![Build Status](https://travis-ci.org/Omarasifshaikh/Arvos-server.svg?branch=master)](https://travis-ci.org/Omarasifshaikh/Arvos-server)


To test the server through your browser:

`localhost:8080`

`localhost:8080/health`

`localhost:8080/augmentTest`

`localhost:8080/directory-service`

`localhost:8080/augmentCreate?name=AwesomeAugment`


HSQLDB and Hibernate:

The database is automatically created inside the folder db. The database is deleted automatically on every JVM instance. 


To remove file based persistence, remove `spring.datasource.url = jdbc:hsqldb:file:./db/testedb` from application.properties.


To allow persistence across JVM instances, change `create-drop` to `update` inside application.properties.  


