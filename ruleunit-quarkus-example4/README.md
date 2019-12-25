

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"maxAmount":5000,"loanApplications":[{"id":"ABC10001","amount":2000,"deposit":100,"applicant":{"age":45,"name":"John"},"approved":false}, {"id":"ABC10002","amount":5000,"deposit":100,"applicant":{"age":25,"name":"Paul"},"approved":false}, {"id":"ABC10015","amount":1000,"deposit":100,"applicant":{"age":12,"name":"George"},"approved":false}]}' http://localhost:8080/find-approved
```

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"maxAmount":5000,"loanApplications":[{"id":"ABC10001","amount":2000,"deposit":100,"applicant":{"age":45,"name":"John"},"approved":false}, {"id":"ABC10002","amount":5000,"deposit":100,"applicant":{"age":25,"name":"Paul"},"approved":false}, {"id":"ABC10015","amount":1000,"deposit":100,"applicant":{"age":12,"name":"George"},"approved":false}]}' http://localhost:8080/find-not-approved-id-and-amount
```
