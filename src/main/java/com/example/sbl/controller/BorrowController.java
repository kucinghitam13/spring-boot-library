package com.example.sbl.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbl.model.Book;
import com.example.sbl.model.Borrow;
import com.example.sbl.model.Member;
import com.example.sbl.repository.BookRepository;
import com.example.sbl.repository.BorrowRepository;
import com.example.sbl.repository.MemberRepository;

@RestController
@RequestMapping("borrow")
public class BorrowController {

	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	MemberRepository memberRepository;

	@GetMapping
	public List<Borrow> getAllBorrow() {
		return borrowRepository.findAll();
	}
	
	@GetMapping("/findByBorrowerId")
	public List<Borrow> getByBorrowerId(@RequestParam(value="borrowerId")long borrowerId){
		return borrowRepository.findByBorrowerId(borrowerId);
	}
	
	@GetMapping("/findByBookId")
	public List<Borrow> getByBookId(@RequestParam(value="bookId")long bookId){
		return borrowRepository.findByBookId(bookId);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Borrow>> getBorrowById(@PathVariable(value = "id") long id) {
		Optional<Borrow> borrow = borrowRepository.findById(id);
		return ResponseEntity.ok().body(borrow);
	}
	
	@PostMapping
	public String addBorrow(@Valid @RequestBody Borrow borrow) {
		Member member = memberRepository.findById(borrow.getBorrowerId()).get();
		Book book = bookRepository.findById(borrow.getBookId()).get();
		
		if (book.getStock() < 1) {
			return "Your requested book \"" + book.getTitle() + "\" is out of stock!";
		}
		
		book.borrowedOne();
		bookRepository.save(book);
		
		borrowRepository.save(borrow);
		return member.getMemberName() + " has borrowed one copy of \"" + book.getTitle() + "\"!";
	}
	
	@PutMapping
	public Borrow returnBorrow(@RequestBody Borrow borrowBody) {
		long borrowId = borrowBody.getBorrowId();
		Borrow borrow = borrowRepository.findById(borrowId).get();
		Book book = bookRepository.findById(borrow.getBookId()).get();
		
		book.returnedOne();
		bookRepository.save(book);
		Date currentDate = new Date();
		borrow.setReturnedDate(currentDate);
		return borrowRepository.save(borrow);
	}
	


//	@PostMapping
//	public String addBorrow(@RequestParam(value = "memberId") long memberId,
//			@RequestParam(value = "bookId") long bookId) {
//		Optional<Member> member = memberRepository.findById(memberId);
//		Optional<Book> book = bookRepository.findById(bookId);
//
//		if (member == null)
//			return "Member with id \"" + memberId + "\" doesn't exist!";
//		else if (book == null)
//			return "Book with id \"" + bookId + "\" doesn't exist!";
//
//		Book borrowedBook = book.get();
//		Member borrowingMember = member.get();
//		
//		if (book.get().getStock() < 1) {
//			return "Your requested book \"" + book.get().getTitle() + "\" is out of stock!";
//		}
//
//		borrowedBook.borrowedOne();
//		bookRepository.save(borrowedBook);
//
//		Borrow borrow = new Borrow(memberId, bookId);
//		borrowRepository.save(borrow);
//		return borrowingMember.getMemberName() + " has borrowed one copy of \"" + borrowedBook.getTitle() + "\"";
//	}
}
