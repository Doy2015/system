package com.compose.system.domain.member;

import jakarta.persistence.*;

@Entity
@Table
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public Member() {
	}

	public Member(String name) {
		this.name = name;
	}

	public void updateName(String name) {
		this.name = name;
	}
}
