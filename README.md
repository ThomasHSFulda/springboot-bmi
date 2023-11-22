# springboot-bmi
This application uses the Azure services **Azure Spring Apps** and **Azure DB for MySQL flexible server** for its deployment.

To deploy this app, you first need to create a fat jar File with the maven command (while being in the project folder):


```
mvwn clean install
```

After that, you switch to the newly created /targets folder, where the jar file is located.

To publish this jar to the Azure Spring Apps service, you need to run the following command:
```
cd PATH TO JAR ; /usr/bin/env 
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java 
-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:63334 
@/var/folders/jb/thwk1h2x4d7_bk8h77hp09240000gn/T/cp_29mmnb9xgdrgx2ohfx4bdy580.argfile 
com.example.bmi.BmiApplication
```


This command varies for each Azure Spring Apps server, so be sure to put in the correct information for your project.

To connect your application to the MySQL server, use the following example and adjust to your connection details:

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://{ip or dns name to your server}:3306/{yourdatabasename}?serverTimezone=UTC&useSSL=true&requireSSL=false
spring.datasource.username={yourusername}
spring.datasource.password={yourpassword}
```
