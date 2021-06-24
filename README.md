# orderbooking
We have used Springboot for developing the application and used H2 database for storing the order data 
Execute the SpringbootRestApplication.java class and with the help of postman we can create orders and get the order details as well

Booking the order with offers
http://localhost:8080/order/offer/save?appleCount=10&orangeCount=20
the parameters are appleCount and orangeCount for saving the data 
![image](https://user-images.githubusercontent.com/86365167/123276958-4b5eae80-d523-11eb-972a-a9b9104aa960.png)

Booking the order without any offer 
http://localhost:8080/order/save?appleCount=10&orangeCount=22
the parameters are appleCount and orangeCount for saving the data 
![image](https://user-images.githubusercontent.com/86365167/123277406-b27c6300-d523-11eb-8739-2f21bd928713.png)

Get all the order details
http://localhost:8080/order/getall
![image](https://user-images.githubusercontent.com/86365167/123277532-d0e25e80-d523-11eb-8a74-f50ca1ba2134.png)

Get order details by Id
http://localhost:8080/order/getbyid?id=1
![image](https://user-images.githubusercontent.com/86365167/123277621-e788b580-d523-11eb-8b70-d4c16c7a016d.png)

H2 database
![image](https://user-images.githubusercontent.com/86365167/123277745-05561a80-d524-11eb-8b51-6bacf2c68059.png)
