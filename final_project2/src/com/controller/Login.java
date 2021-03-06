package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.CharVO;
import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	// 로그인 성공시 안드로이드에게
	// "성공"을 리턴한다.
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		serverLog("Login");
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("m_id");
		String pwd = request.getParameter("m_pwd");
		
		System.out.println("입력받은 id = "+id+", pwd = "+pwd);
		
		String m_id = new MemberDAO().login(id, pwd);

		if (!m_id.equals("")) {
			System.out.println("조회 후 가지고 온 id : " + m_id);
			// 로그인성공했을때 조건문이니까 성공 보내기~
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("성공"); // id를 서버로 보낸다.
		}
		
		//		try {
////			String result = member_vo.getM_nickname();
//			
////			System.out.println("nickname = "+result);
//			
//			
//			// 안드에 쏴주기
//			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); //  DateFormat변경후 생성
//			String json = gson.toJson(char_vo);
//			System.out.println("json 객체 = "+json);
//			
//			response.setContentType("application/json");
//		    response.setCharacterEncoding("UTF-8");
//		    response.getWriter().write(json);
//		    
//			
////			PrintWriter out = response.getWriter();
////			out.print(result);
//			
//		} catch (NullPointerException e) {
//			System.out.println("객체 = null");
//		}
		
		
		
//		if(member_vo != null) {
//			
//		} else {
//			
//		}
		
	}
	
	public void serverLog(String serverName) {
		Date dt = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String time = sdf.format(dt);
		System.out.println();
		System.out.println(serverName+"서버 진입(" + time + ")");
	}

}
