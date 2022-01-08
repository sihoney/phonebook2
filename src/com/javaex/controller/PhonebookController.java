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
public class PhonebookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("controller");
		String act = request.getParameter("action");
		
		if("list".equals(act)) {
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> list = phoneDao.selectPerson();
			
			//System.out.println(list);
			
			// html과 list 섞어서 표현해야 한다.
			// servlet으로는 표현이 복잡해진다. --> jsp를 이욯한다.
			
			request.setAttribute("pList", list);
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);
		} 
		else if("writeForm".equals(act)) {
			System.out.println("write Form");
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
		}
		else if("insert".equals(act)) { // write
			System.out.println(act);
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo personVo = new PersonVo(name, hp, company);
			
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.insertPerson(personVo);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
		}
		else if("delete".equals(act)) {
			System.out.println(act);
			
			int personId = Integer.parseInt(request.getParameter("personId"));
			
			PhoneDao phoneDao = new PhoneDao();
			
			phoneDao.deletePerson(personId);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
		}
		else if("updateForm".equals(act)) {
			System.out.println(act);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
			rd.forward(request, response);			
		}
		else if("update".equals(act)) {
			System.out.println(act);
			
			PhoneDao phoneDao = new PhoneDao();
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			int personId = Integer.parseInt(request.getParameter("personId"));
			
			PersonVo pvo = new PersonVo(personId, name, hp, company);
			
			phoneDao.updatePerson(pvo);
			
			response.sendRedirect("/phonebook2/pbc?action=list");
		}
		else {
			System.out.println("파라미터 값 없음");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
