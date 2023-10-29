### PROBLEM DEFINITION
Create an Application having Login, Registration Page & navigate that request to post endpoint at the backend layer developed using the Spring boot/Spring MVC & invoke the Oracle Database.

### UI 
#### Login Page details:
Username, password , Submit, Forgot password, Registration page (New User)
<br> Client side validation for the given fields.

#### Registration Page details:
Employee name, Employee ID, Department, Designation, Technology, Reporting Manager Designation, Reporting Manager & do the client side validation for these given fields.

#### Backend Page:
Spring boot/Spring mvc using java(jdk 17), do the authentication(Auth 2.0) & server side validation At Backend layer there would be MVC architecture, UI request would be handles by Controller layer, Controller layer would invoke to the Service layer(Authentication) & Service layer would invoke to the DAO/Repository layer. This Repository layer would hit to the Oracle DB to to facilitate all CRUD operations. DataBase;

Oracle: Normalized table 

#### Employee Table:
Employee name, Employee ID, Department, Designation, Technology, Reporting to Manager
#### Manager Table : 
Name, Manager ID, Teams . Reporting to SeniorVP 

#### Application Server:
Tomcat gets the request & share the response to the End user.