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
 * Servlet implementation class MemberSelect
 */
@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo =new MemberVO();
		
		System.out.println(request.getParameter("id"));
		
		vo.setMemberId(request.getParameter("id"));
		vo=dao.memberSelect(vo);
		System.out.println(vo.getMemberName());
		request.setAttribute("member", vo);
		
		
		String viewPage = "WEB-INF/views/member/memberSelect.jsp"; //결과를 반환 하는 페이지
		
		RequestDispatcher dis  = request.getRequestDispatcher(viewPage);//검색하기
		dis.forward(request, response);          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
