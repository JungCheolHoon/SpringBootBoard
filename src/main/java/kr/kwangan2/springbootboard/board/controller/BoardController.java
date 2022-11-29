package kr.kwangan2.springbootboard.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.kwangan2.springbootboard.board.entity.Board;
import kr.kwangan2.springbootboard.board.service.BoardService;
import kr.kwangan2.springbootboard.member.entity.Member;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	@RequestMapping("/listBoard")
	public String listBoard(Model model, Board board, @ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		List<Board> boardList = boardService.listBoard(board);
		model.addAttribute("boardList",boardList);
		return "/board/listBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		return "/board/insertBoard";
	}

	@PostMapping("/insertBoardProc")
	public String insertBoardProc(Board board, @ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		return "redirect:listBoard";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board,Model model, @ModelAttribute("member") Member member) {
		Board findBoard = boardService.getBoard(board);
		findBoard.setCnt(findBoard.getCnt()+1);
		boardService.insertBoard(findBoard);
		model.addAttribute("board",findBoard);
		model.addAttribute("member",member);
		return "/board/getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board, @ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.updateBoard(board);
		return "redirect:listBoard";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board, @ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.deleteBoard(board);
		return "redirect:listBoard";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello Thymeleaf !!!");
		return "/board/hello";
	}
	
}
