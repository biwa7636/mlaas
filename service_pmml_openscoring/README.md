1. start the openscoring server

```bash
git clone https://github.com/jpmml/openscoring.git
cd openscoring
mvn clean install 
java -jar openscoring-server/target/server-executable-1.2-SNAPSHOT.jar```

2. deploy the model and query

```bash
curl -X PUT --data-binary "@<path to your desktop>/iris.xml" -H "Content-type: text/xml" http://localhost:8080/openscoring/model/modeliris
curl -X POST --data-binary \
'{"id":"record-001","arguments":{"Sepal.Length":5.1,"Sepal.Width":3.5,"Petal.Length":1.4,"Petal.Width":0.2}}' \
 -H "Content-type: application/json" http://localhost:8080/openscoring/model/modeliris
```
