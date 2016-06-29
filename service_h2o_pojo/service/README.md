You can start the embedded tomcat server by running the following command in the project root directory
`mvn spring-boot:run`

Then you should be able to see the prediction in your favorite browser
`http://localhost:8080/greeting?sl=1&sw=1&pl=1&pw=1`

TODO: 
1. export the model to be a better name that could be consistent 
2. optimize the restful service so the pojo load only once instead of everytime 
