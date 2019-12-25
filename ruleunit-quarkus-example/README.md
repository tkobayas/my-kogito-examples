# RuleUnit + Quarkus example

## Description

A simple rule service to validate `Person` fact. 

REST endpoints are generated from query rules. You can insert `Person` facts and query a result via the REST endpoints. Rule resources are assembled as a RuleUnit.

## Installing and Running

### Prerequisites
 
You will need:
  - Java 1.8.0+ installed 
  - Environment variable JAVA_HOME set accordingly
  - Maven 3.5.4+ installed

When using native image compilation, you will also need: 
  - [GraalVM 19.2.0](https://github.com/oracle/graal/releases/tag/vm-19.2.0) installed 
  - Environment variable GRAALVM_HOME set accordingly
  - Note that GraalVM native image compilation typically requires other packages (glibc-devel, zlib-devel and gcc) to be installed too.  You also need 'native-image' installed in GraalVM (using 'gu install native-image'). Please refer to [GraalVM installation documentation](https://www.graalvm.org/docs/reference-manual/aot-compilation/#prerequisites) for more details.

### Compile and Run in Local Dev Mode

```
mvn clean package quarkus:dev    
```

### Compile and Run in JVM mode

```
mvn clean package 
java -jar target/ruleunit-quarkus-example-{version}-runner.jar    
```

or on windows

```
mvn clean package
java -jar target\ruleunit-quarkus-example-{version}-runner.jar
```

### Compile and Run using Local Native Image
Note that this requires GRAALVM_HOME to point to a valid GraalVM installation

```
mvn clean package -Pnative
```
  
To run the generated native executable, generated in `target/`, execute

```
./target/ruleunit-quarkus-example-{version}-runner
```

Note: This does not yet work on Windows, GraalVM and Quarkus should be rolling out support for Windows soon.

## Swagger documentation

You can take a look at the [swagger definition](http://localhost:8080/docs/swagger.json) - automatically generated and included in this service - to determine all available operations exposed by this service.  For easy readability you can visualize the swagger definition file using a swagger UI like for example available [here](https://editor.swagger.io). In addition, various clients to interact with this service can be easily generated using this swagger definition.

When running in Quarkus development mode, we also leverage the Quarkus openapi extension that exposes [swagger UI](http://localhost:8080/swagger-ui/) that you can use to look at available REST endpoints and send test requests. 

## Example Usage

Once the service is up and running, you can use the following examples to interact with the service.  Note that rather than using the curl commands below, you can also use the [swagger UI](http://localhost:8080/swagger-ui/) to send requests.

### POST /find-adults

Returns adult persons from the given facts:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"persons":[{"name":"Mario","age":45,"adult":false},{"name":"Marilena","age":47,"adult":false},{"name":"Sofia","age":7,"adult":false}]}' http://localhost:8080/find-adults
```
or on windows

```sh
curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d "{\"adultAge\":18,\"persons\":[{\"name\":\"Mario\",\"age\":45,\"adult\":false},{\"name\":\"Marilena\",\"age\":47,\"adult\":false},{\"name\":\"Sofia\",\"age\":7,\"adult\":false}]}" http://localhost:8080/find-adults
```

As response an array of persons is returned.

Example response:
```json
[
   {
      "name":"Mario",
      "age":45,
      "adult":true
   },
   {
      "name":"Marilena",
      "age":47,
      "adult":true
   }
]
```

### POST /find-adult-names

Returns names of adult persons from the given facts:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"persons":[{"name":"Mario","age":45,"adult":false},{"name":"Marilena","age":47,"adult":false},{"name":"Sofia","age":7,"adult":false}]}' http://localhost:8080/find-adult-names
```

As response an array of person names is returned.

Example response:
```json
[
   "Marilena",
   "Mario"
]
```

### POST /find-not-adult-names-and-age

Returns names and ages of not-adult persons from the given facts:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"persons":[{"name":"Mario","age":45,"adult":false},{"name":"Marilena","age":47,"adult":false},{"name":"Sofia","age":7,"adult":false}]}' http://localhost:8080/find-not-adult-names-and-age
```

As response an array of person names and ages is returned.

Example response:
```json
[
   {
      "$name":"Sofia",
      "$age":7
   }
]
```
