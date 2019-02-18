package com.example.sbl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbl.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByMemberName(String memberName);
}
