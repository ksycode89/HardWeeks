package co.micol.prj;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.EqualsOperator;

import co.micol.prj.common.Command;
import co.micol.prj.member.command.IsMemberId;
import co.micol.prj.member.command.MemberInsert;
import co.micol.prj.member.command.MemberInsert2;
import co.micol.prj.member.command.MemberSelect;
import co.micol.prj.member.command.MemberSelectList;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
		//등록하는곳
		map.put("/main.do",new MainCommand());
		map.put("/memberSelectList.do",new MemberSelectList());
		map.put("/MemberSelect.do",new MemberSelect());
		map.put("/memberInsert.do",new MemberInsert());
		map.put("/memberInsert2.do", new MemberInsert2());
		map.put("/isMemberId.do", new IsMemberId() );
		
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String idCheck = request.getParameter("do");
		
		if("do".equals(idCheck)) {
			MemberService dao = new MemberServiceImpl();
			String id =request.getParameter("memberId");
			boolean result = dao.isMemberId(id);
			try {
				sop
				if(result) {
//					 request.setAttribute("result", "can");
					response.getWriter().print("Can using");
				}else {
//					request.setAttribute("result", "cant");
					response.getWriter().print("Already Using");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		String uri = request.getRequestURI(); //도메인 모양 
		String contextPath = request.getContextPath();//Path
		String page = uri.substring(contextPath.length());
		
		System.out.println(uri);
		System.out.println(page);
		
		Command command = map.get(page);//처리할 커멘드
//		======================
		System.out.println("command : "+ command);
		String viewPage = command.exec(request,response);
		//view reserve
		if(!viewPage.endsWith(".do")) {
			viewPage = "/WEB-INF/views/"+viewPage+".jsp";
			System.out.println("viewPage : "+ viewPage);
			
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
			
		}else {
			response.sendRedirect(viewPage);
		}
		
		
		
		
	}


}
