https://localhost:8443/bluepoodle-rest/api/foos

Zugriff mit Firefox RESTClient:
Authentication-Header: BasicAuthentication -> Username: guest, Password: guest
http://localhost:8080/bluepoodle-rest/api/foos


Zugriff mit curl:

D:\tools\curl-7.23.1-win64-nossl>curl -i -X POST -d j_username=guest -d j_password=guest -H Content-Type=application/x-w
ww-form-urlencoded -c mycookies.txt http://localhost:8080/bluepoodle-rest/session
HTTP/1.1 302 Found
Set-Cookie: JSESSIONID=9eaqvw943jagvn4zrjawixh8;Path=/bluepoodle-rest
Expires: Thu, 01 Jan 1970 00:00:00 GMT
Location: http://localhost:8080/bluepoodle-rest/
Content-Length: 0
Server: Jetty(7.6.4.v20120524)


D:\tools\curl-7.23.1-win64-nossl>curl -i --header "Accept:application/json" -X GET -b mycookies.txt http://localhost:808
0/bluepoodle-rest/api/foos
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Server: Jetty(7.6.4.v20120524)

[{"id":0,"name":"MdxCas"}]
D:\tools\curl-7.23.1-win64-nossl>