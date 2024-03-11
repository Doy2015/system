package com.compose.system.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;

	public Member findById(Long id) {
		return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found member"));
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Transactional
	public void createMember(Member member) {
		memberRepository.save(member);
	}

	@Transactional
	public void updateMember(Long id, String name) {
		final Member findMember = findById(id);
		findMember.updateName(name);
	}
}
