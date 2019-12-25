
```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"adultAge":18,"persons":[{"adult":false,"age":45,"name":"Mario"}],"loanApplications":[{"amount":2000,"applicant":{"adult":false,"age":45,"name":"Mario"},"approved":false}]}' http://localhost:8080/find-approved
```
