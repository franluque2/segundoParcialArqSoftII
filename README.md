# baseService
post task
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/baseService/task --data '{"taskName":"name","userId":1,"projectId":1,"stateId":1,"body":"task"}'
comments post
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/baseService/comment --data '{"name":"name","body":"hello","userId":1,"taskId":1}'
Esto tira error  (como debería)
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/baseService/comment --data '{"name":"name","body":"hello","userId":1,"taskId":3}'
post user
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/baseService/user --data '{"name":"name","lastName":"ribetti", "adress":"123","email":"123","phone":"123","DNI":"12313","inscription":"2020-03-08","birthday":"2020-03-08","username":"root","password":"root","permits":"admin" }'
post project
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/baseService/project --data '{"name":"name","description":"prueba del post","start":"2020-03-08","state":"1" }'



w 
