package kr.kwangan2.springbootboard;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springbootboard.board.entity.Board;
import kr.kwangan2.springbootboard.board.repository.BoardRepository;
import kr.kwangan2.springbootboard.member.entity.Member;
import kr.kwangan2.springbootboard.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;

	@Test
	void testInsert() {

//		Member member1 = new Member("member1", "둘리", "member111", "ROLE_USER");
//		memberRepo.save(member1);
//		Member member2 = new Member("member2", "도우너", "member222", "ROLE_ADMIN");
//		memberRepo.save(member2);
	
		Member member2 = new Member("testid", "testpw", "감자", "ROLE_USER");
		memberRepo.save(member2);
		Member member1 = new Member("testadmin", "testadmin", "고구마", "ROLE_ADMIN");
		memberRepo.save(member1);
		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setWriter("둘리");
//			board.setTitle("둘리가 등록한 게시글 "+i);
//			board.setContent("둘리가 등록한 게시글 내용 "+i);
//			boardRepo.save(board);
//		}
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setWriter("도우너");
//			board.setTitle("도우너가 등록한 게시글 "+i);
//			board.setContent("도우너가 등록한 게시글 내용 "+i);
//			boardRepo.save(board);
//		}

	}

}
