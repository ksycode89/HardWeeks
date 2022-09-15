package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		MemberService dao = new MemberServiceImpl();
		MemberVO vo =new MemberVO();
		
		System.out.println(request.getParameter("id"));
		
		vo.setMemberId(request.getParameter("id"));
		vo=dao.memberSelect(vo);
		System.out.println(vo.getMemberName());
		request.setAttribute("member", vo);
		
		return "member/memberSelect";
	}

}
