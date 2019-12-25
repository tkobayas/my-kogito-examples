

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"applicants":[{"adult":false,"age":45,"name":"Mario"}],"loanApplications":[{"id":"ABC10001", "amount":2000,"approved":false}, {"id":"ABC10002", "amount":8000,"approved":false}, {"id":"ABC10005", "amount":1500,"approved":false}]}' http://localhost:8080/find-approved
```

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"applicants":[{"adult":false,"age":45,"name":"Mario"}],"loanApplications":[{"id":"ABC10001", "amount":2000,"approved":false}, {"id":"ABC10002", "amount":8000,"approved":false}, {"id":"ABC10005", "amount":1500,"approved":false}]}' http://localhost:8080/find-not-approved-id-and-amount
```
