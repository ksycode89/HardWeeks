package co.micol.prj.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
	vo.setMemberId(request.getParameter("memberId"));
	vo= dao.memberSelect(vo);
	request.setAttribute("member", vo);
		
		
		String viewPage = "WEB-INF/views/member/memberInsert.jsp"; //결과를 반환 하는 페이지
		
		RequestDispatcher dis  = request.getRequestDispatcher(viewPage);//검색하기
		dis.forward(request, response);          
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
