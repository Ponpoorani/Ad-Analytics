package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.helper.NB;

/**
 * Servlet implementation class PredictUser
 */
@WebServlet("/PredictUser")
public class PredictUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredictUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String advId = request.getParameter("advId");
		String region = request.getParameter("region");
		String adType = request.getParameter("adType");
		String gender = request.getParameter("gender");
		String autoI = request.getParameter("autoI");
		String eduI = request.getParameter("eduI");
		String litI = request.getParameter("litI");
		String newsI = request.getParameter("newsI");
		String entI = request.getParameter("entI");

		// Call backend method

		System.out.println(advId + "   " + region + "   " + adType + "   "
				+ gender + "   " + autoI + "   " + eduI + "   " + litI
				+ "   " + newsI + "   " + entI);

		
		String label = NB.NaiveByes(advId, region, adType, gender, autoI, eduI, litI, newsI, entI);
		
		
		JSONObject jo = new JSONObject();
		try {
			jo.put("label", label);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.getWriter().write(jo.toString());

	}

}
