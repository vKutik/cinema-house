#Cinema app

This is application implemented
on the Spring and Hibernate frameworks. In which
there is an opportunity to buy a ticket to the cinema in
concrete hall using and order picker
There is also a personal account and order history.
Users have the roles **ADMIN** with full access and **USER** with limited access to endpoints.



### Structure application

The application has 3 layers 

* DAO
* Service
* Controller


####Used tehnologies

* Java 8
* SOLID
* HIBERNATE and Spring 
* TomCat 
* JSON

#### Instruction use 

1. To run the project on your PC, clone it into your local directory and then open it in an IDE.
2. Install MySQL and MySQL Workbench, configure connection to your database by editing _db.properties_ file: <br>
   **YOUR_DRIVER:** _com.mysql.cj.jdbc.Driver_ or any other suitable driver <br>
   **YOUR_URL:** _jdbc:mysql://localhost:3306/<b>database_name</b>?serverTimezone=UTC_ <br>
   **YOUR_LOGIN:** MySQL username <br>
   **YOUR_PASSWORD:** MySQL password <br>

4. Configure TomCat Local server (_Add New Configuration_ -> _TomCat Server_ -> _Local_ -> _Fix_ -> _cinema:war exploded_ -> set _Application context_ to "/" -> _OK_).
5. Admin and user will be added by default in DataInitializer.<br><br>

   **User: user@theater.ua Password: user111** <br>
   Available: /register <br>
   Get: /cinema-halls, /movies, /movie-sessions/, /orders, /shopping-carts <br>
   Post: /orders, /shopping-carts <br><br>
   **Admin: admin@theater.ua pass: admin111** <br>
   Available: /register <br>
   Get: /cinema-halls, /movies, /movie-sessions/, /users/<br>
   Post: /cinema-halls, /movies, /movie-sessions/<br>
   Put, Delete: /movie-sessions/<br>
6. Run your project.
<hr>
