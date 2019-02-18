package com.example.sbl.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbl.model.Member;
import com.example.sbl.repository.MemberRepository;

@RestController
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Member>>getMemberById(@PathVariable(value = "id") long memberId) {
		Optional<Member> member = memberRepository.findById(memberId);
		return ResponseEntity.ok().body(member);
	}
	
	@PostMapping
	public Member addMember(@Valid @RequestBody Member member) {
		return memberRepository.save(member);
	}

}
