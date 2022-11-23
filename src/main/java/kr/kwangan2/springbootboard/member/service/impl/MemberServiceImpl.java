package kr.kwangan2.springbootboard.member.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springbootboard.member.entity.Member;
import kr.kwangan2.springbootboard.member.repository.MemberRepository;
import kr.kwangan2.springbootboard.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public Member getMember(Member member) {
		
		// null 인지 아닌지 if문을 쓰지않고 optional 클래스를 사용하여 null인지 확인가능, null이더라도 일단 메소드를 제공해줌
		Optional<Member> findMember = memberRepo.findById(member.getId());
		System.out.println(findMember);
		if(findMember.isPresent())	// findMember 객체가 값을 가지고 있다면 true, findMember != null
			return findMember.get();
		else 
			return null;
	}
}
