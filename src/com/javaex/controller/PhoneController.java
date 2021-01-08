package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;
import com.javaex.webutil.WebUtil;


@WebServlet("/pbc")
public class PhoneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Controller");
		// 리스트 출력관련

		// 파라미터 action 값을 읽어서
		String action = request.getParameter("action");
		System.out.println(action);

		// action = list ---> 리스트 출력처리
		if("wform".equals(action)) {
			System.out.println("등록 폼 처리");
			
			/*WebUtil클래스에 forward 메소드를 만들어 사용함
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/writeForm.jsp");
			rs.forward(request, response);
			*/
			WebUtil.forward(request,response,"./WEB-INF/writeForm.jsp");
		}else if("insert".equals(action)) {
			System.out.println("전화번호 저장");
			//파라미터 3개 받기
			String name = request.getParameter("name");
			String ph = request.getParameter("hp");
			String company = request.getParameter("company");
			//personvo 묵고
			PersonVo personvo = new PersonVo(name,ph,company);
			//new dao
			PhoneDao phonedao = new PhoneDao();
			//dao personInsert
			phonedao.personInsert(personvo);
			
			//response.sendRedirect("/phonebook2/pbc");
			//WebUtil클래스의 redirect메소드를 이용함
			
			WebUtil.redirect(request, response, "/phonebook2/pbc");
		}else if("delete".equals(action)) {
			System.out.println("삭제");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			PhoneDao phonedao=new PhoneDao();
			phonedao.personDelete(id);
			
			//response.sendRedirect("/phonebook2/pbc");
			WebUtil.redirect(request, response, "/phonebook2/pbc");
		}else if("updateform".equals(action)) {
			System.out.println("수정폼");
			int id = Integer.parseInt(request.getParameter("id"));
			
			//보낼 객체 얻기
			PhoneDao phoneDao = new PhoneDao();
			PersonVo personvo = phoneDao.getPerson(id);
			
			request.setAttribute("personvo", personvo);
			
			/*WebUtil클래스에 forward 메소드를 만들어 사용함
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/updateform.jsp");
			rd.forward(request, response);
			*/
			
			WebUtil.forward(request,response,"./WEB-INF/updateform.jsp");
		
		}else if("update".equals(action)) {
			System.out.println("수정");
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			int id = Integer.parseInt(request.getParameter("id"));
			
			//수정을 위해 객체생성
			PersonVo personvo = new PersonVo(id,name,hp,company);
			PhoneDao phoneDao = new PhoneDao();
			
			//수정
			phoneDao.personUpdate(personvo);
			
		//	response.sendRedirect("/phonebook2/pbc");
			//웹유틸 이용
			WebUtil.redirect(request, response, "/phonebook2/pbc");
			
		}else {
			//리스트는 디폴트로 놓고싶기 때문에 따로 액션처리 없게 만든다
			System.out.println("리스트처리");
			
			PhoneDao phonedao = new PhoneDao();
			List<PersonVo> personList = phonedao.getPersonList();

			// html --> 엄청 복잡하다 -->jsp가 편하다
			// 데이터 전달
			request.setAttribute("pList", personList);

			// jsp에 포워드 시킨다.
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp"); // jsp 파일 위치
			rd.forward(request, response);
			*/
			
			WebUtil.forward(request, response, "./WEB-INF/list.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
		 doGet(request, response);
	}

}
