# Multiple RuleUnits + Quarkus example

### POST /get-results

Returns names of adult persons from the given facts:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"persons":[{"age":45,"name":"John"},{"age":17,"name":"Paul"}]}' http://localhost:8080/get-results
```
