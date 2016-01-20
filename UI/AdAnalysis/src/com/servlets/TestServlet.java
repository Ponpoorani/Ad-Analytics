package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    	System.out.println("Timerrrrrr");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		System.out.println("timepassssss");
		request.setCharacterEncoding("utf8");
        PrintWriter out = response.getWriter(); 
      //  JSONObject jsonObj = (JSONObject) JSONValue.parse(request.getParameter("para"));
        String tp = request.getParameter("data");
        System.out.println(tp);       
        
        tp = "Ashik Axis";
       // JSONObject obj = new JSONObject();
        //obj.put("message", "hello from server");
        out.print(tp);
 
	}

}
