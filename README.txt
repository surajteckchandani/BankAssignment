1) create Account
url: http://localhost:8080/api/createAccount
method : post
Header : Content-Type: application/json
body:
{
"username" : "test",
"password" : "test",
"email":"test@abc.com",
"type":"saving"
}
Expected Response: Account created successfully


2) Get Balance
url: http://localhost:8080/api/getBalance
method : post
Header : Content-Type: application/json
body:
{
"username" : "test"
}
Expected Response: Your current balance is=0.0


3) Withdraw Amount
url: http://localhost:8080/api/withdrawAmount/{username}
method : post
Header : Content-Type: application/json
body:
{
"amount": 200000
}
Expected Response: Your current balance is=1980.0


4) Add Amount
url: http://localhost:8080/api/addAmount/{username}
method : post
Header : Content-Type: application/json
body:
{
"amount": 200000
}
Expected Response: Your current balance is=1980.0