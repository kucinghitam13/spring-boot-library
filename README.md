# spring-boot-library
Simple RESTful web service for library borrowing system using spring boot framework on Spring Tool Suite 4.

## Prerequisites
* JDK 1.8+
* Spring Tool Suite 4.1.1+ (might work on other IDE like eclipse or IDEA, but I recommend to use STS).
* MySQL

You also need to add some records beforehand (either manually from MySQL or using POST request) to use GET method for retrieving data.

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
Pretty much the same as BookController but with `http://localhost:8080/member/` as its endpoint.

## BorrowController
### Borrowing a book
You only need to specify the borrower ID (or member ID) and the book ID. It will automatically creates a borrowing date and reduces the book stock by 1, or fails to do so if out of stock. The returned date field is obviously null as default and can be used for creating further function like filtering all unreturned books or unreturned books from specific user.  
Method : `POST`  
Endpoint : `http://localhost:8080/borrow/`
![borrowing book](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/c.PNG)

### Returning a book
You only need to specify the borrow ID. It will update the returned date field to the current date as a mark for returned book, and can be used for creating further function such as simple arithmetic operation to count how much days the book has been borrowed. It also adds the particular book's stock by 1.  
Method : `PUT`  
Endpoint : `http://localhost:8080/borrow/`
![returning book](https://raw.githubusercontent.com/kucinghitam13/spring-boot-library/master/img/d.PNG)
