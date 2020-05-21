# manageating
## REST CRUD Application that manages the orders, the staff and the products of a restaurant.
##### Made with Spring Boot, Spring Security, MySQL and Tymeleaf

## Acces the app [here](https://manageating.herokuapp.com/)

##### WIP to translate the app into english

How to run it:

1. Using IntelliJ IDEA open the pom.xml file. (or search for a tutorial of `how to open a Maven project`)
2. Inside the `sqlScripts` folder you have the MySQL script for the database. Run it on your desired server.
3. Make sure to update your database connection properties in the `application.properties` file inside `src/main/resources`.
4. Go on localhost:8080 and login with the user "bogdan" and the default password "parola".



##### Current features:

- Login as waiter/manager.
- Register as waiter and get promoted by a manager.
- As a waiter:
  - Take orders.
  - Add products in orders.
  - Finish and see details only on your orders.
- As a manager:
  - Edit/Delete products.
  - See details of any order.
  - See details about your staff and promote the waiters.
  
##### Upcoming features:

- Search orders between two dates.
- A profile page with the user details and reports.
- Ability to fire waiters and demote managers.
- Better UI and frontend.
- Password change.
- Probably deploy on herokku.
