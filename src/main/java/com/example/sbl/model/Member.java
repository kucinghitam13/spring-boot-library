package com.example.sbl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.sbl.JsonDateSerializer.JsonDataSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity @EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "joinDate" }, allowGetters = true)
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long memberId;
	
	@NotNull
	private String memberName;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonSerialize(using=JsonDataSerializer.class)
	private Date joinDate;
	
	public long getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
}
