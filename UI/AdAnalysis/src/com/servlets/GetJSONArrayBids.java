package com.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.helper.Advertiser;
import com.helper.Populate_Vold;
import com.java.dto.AdvertiserDTO;

/**
 * Servlet implementation class GetJSONArrayBids
 */
@WebServlet("/GetJSONArrayBids")
public class GetJSONArrayBids extends HttpServlet {
	private static Map<String, Advertiser> advMap = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetJSONArrayBids() {
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

		if (null == advMap) {
			advMap = Populate_Vold.getAdvIdAdvertiserMap();
			System.out.println("Called Once for map");
		}
		System.out.println("returning vaues for"
				+ request.getParameter("advId"));
		JSONArray jarray = new JSONArray();

		Advertiser advertiser = advMap.get(request.getParameter("advId"));

		jarray.put(advertiser.getNoOfBids());
		jarray.put(advertiser.getNoOfImp());
		jarray.put(advertiser.getNoOfClicks());
		jarray.put(advertiser.getNoOfConv());
		JSONObject jo = new JSONObject();

		try {
			jo.put("listVal", jarray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.getWriter().write(jo.toString());
		System.out.println(jo.toString());
	}

}
