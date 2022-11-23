package kr.kwangan2.springbootboard.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.kwangan2.springbootboard.member.entity.Member;
import kr.kwangan2.springbootboard.member.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("loginProc")
	public String login(Member member,Model model) {
		Member findMember = memberService.getMember(member);
		if(findMember !=null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member",findMember);
			return "redirect:listBoard";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
	
}
