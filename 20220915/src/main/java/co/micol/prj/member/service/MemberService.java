package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	
	 List<MemberVO> memberSelectList(); //모든목록
	
	 MemberVO memberSelect(MemberVO vo); //단건 조회/ 로그인 정보 담을때
	
	 int memberInsert(MemberVO vo); //단건 입력
	 
	 int memberDelete(MemberVO vo); //단건 삭제
	
	 int memberUpdate(MemberVO vo);//단건 수정
	 
	 boolean isMemberId(String id); // 아이디 중복 체크 //exist = false
	
	 
	

}
