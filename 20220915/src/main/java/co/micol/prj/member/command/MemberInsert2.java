package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberInsert2 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		System.out.println("ID : "+vo.getMemberId());
		
		vo.setMemberPassword(request.getParameter("memberPassWord"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor(request.getParameter("memberAuhor"));
		System.out.println(vo);
		int result  = dao.memberInsert(vo);
		
		String viewPage = null;
		
		if(result !=0) {
		viewPage = "memberSelectList.do";
		}else {
			request.setAttribute("message", "실패");
			viewPage = "member/memberMessage";
		}
		
		return viewPage;
	}

}
