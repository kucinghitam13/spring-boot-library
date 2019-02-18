package com.example.sbl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbl.model.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	List<Borrow> findByBorrowerId(long borrowerId);
	List<Borrow> findByBookId(long bookId);
}
