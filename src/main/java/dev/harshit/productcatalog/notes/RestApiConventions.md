1. Endpoint should be made around resources
   Eg GET /users
2. Every request should be independent & self-sufficient, since server is 
stateless it will not store any prev request information. Therefore your request itself should contain all the 
information. Why ? It allows system to scale
3. Don't always have 1:1 mapping with DB tables
Which means frontend dev needs to call /books, /categories,/author to
render a page. It will make it too chatty. There should be a discussion between
frontend & backend team and the api should combine all these resources in 1 request
4. Rest APIs will use an exchange format to talk to each other like json, protobuffs, xml
5. Endpoints should be purals
eg. /users not /user

[Rest API notes from Microsoft](https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design)