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
		if ("list".equals(action)) {
			System.out.println("리스트처리");
			
			PhoneDao phonedao = new PhoneDao();
			List<PersonVo> personList = phonedao.getPersonList();

			// html --> 엄청 복잡하다 -->jsp가 편하다
			// 데이터 전달
			request.setAttribute("pList", personList);

			// jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp"); // jsp 파일 위치
			rd.forward(request, response);

			// action = wform -->등록폼
		}else if("wform".equals(action)) {
			System.out.println("등록 폼 처리");
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/writeForm.jsp");
			rs.forward(request, response);
			
			
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
			response.sendRedirect("/phonebook2/pbc?action=list");
		}else if("delete".equals(action)) {
			System.out.println("삭제");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
	}

}
