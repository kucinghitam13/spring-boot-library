# spring-boot-library
Simple RESTful web service for library borrowing system using spring boot framework on Spring Tool Suite 4.

## Prerequisites
* JDK 1.8+
* Spring Tool Suite 4.1.1+ (might work on other IDE but use I recommend STS).
* MySQL

You also need to add some records beforehand to use GET method for retrieving data. Execute .sql files in resource directory.

## BookController
### Get all existing books
Method : `GET`  
Endpoint : `http://localhost:8080/book/`
![get all books](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/01.PNG)

### Get a book by id
Method : `GET`  
Endpoint : `http://localhost:8080/book/{id}`
![get book by id](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/02.PNG)

### Add new book
Method : `POST`  
Endpoint : `http://localhost:8080/book/`
![add book](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/03.PNG)

## MemberController
Pretty much the same as BookController but with `http://localhost:8080/book/` as its endpoint.

## BorrowController
### Borrowing a book
You only need to specify the borrower ID (or member ID) and the book ID. It will automatically created a borrowing date and remove the book stock by 1, or fail to do so if out of stock.
Method : `POST`  
Endpoint : `http://localhost:8080/borrow/`
![borrowing book](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/c.PNG)

### Returning a book
Only need to specify the borrow ID.
Method : `PUT`  
Endpoint : `http://localhost:8080/borrow/`
![returning book](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/d.PNG)
