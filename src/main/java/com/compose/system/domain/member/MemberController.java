package com.compose.system.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

	private final MemberService memberService;

	@GetMapping
	public List<Member> findAll() {
		return memberService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Member findById(Long id) {
		return memberService.findById(id);
	}

	@GetMapping(value = "/create")
	public void createMember(String name) {
		final Member member = new Member(name);
		memberService.createMember(member);
	}
}
