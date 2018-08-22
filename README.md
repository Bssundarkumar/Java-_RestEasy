# Java-_RestEasy


Java Application can run on Toomcat Server

Here You can add the new user, delete User, It had a dummy user, You can see all the Users in the JSON Format
It is implemented using RESTEasy, Json using maven

API: You can Implement on PostMan
a. Add New User:
http://localhost:8080/RestEasy-User/user/add
Header values:
[{"key":"Accept","value":"application/json","description":""},{"key":"Content-Type","value":"application/json","description":""}]

b. Get Dummy User 
http://localhost:8080/RestEasy-User/user/12/getDummy

c. Delete User
http://localhost:8080/RestEasy-User/user/154/delete

D. Get Single User
http://localhost:8080/RestEasy-User/user/154/get
 
E. Get All Users
http://localhost:8080/RestEasy-User/user/getAll
