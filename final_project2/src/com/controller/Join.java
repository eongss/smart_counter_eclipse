package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.MemberDAO;
import com.model.MemberVO;


@WebServlet("/Join")
public class Join extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String admin_yn = "N";
		
		
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		String m_gender = request.getParameter("m_gender");
		String m_name = request.getParameter("m_name");
		String m_nickname = request.getParameter("m_nickname");
		String m_email = request.getParameter("m_email");
		String m_phone = request.getParameter("m_phone");
		String m_push_yn = request.getParameter("m_push_yn");

		
		// 여기서도 joindate는 받지 않음. joindate는 db에 insert할 때 sysdate로 들어간다.
	
		if(m_id.equals("이것이관리자아이디다")) {
			admin_yn = "Y";
		}

		
		int cnt = new MemberDAO().join(m_id, m_pwd, m_gender, m_name, m_nickname, m_email, m_phone, m_push_yn, admin_yn);
		

		
	
		try {
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    
			PrintWriter out = response.getWriter();
			
			if(cnt>0) {
			
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			out.print("회원가입성공"); //회원가입성공을 서버로 보낸다.
		   
			}else {
				out.print("회원가입실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
