package com.servlets;

import java.io.IOException;
import java.util.HashMap;
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

/**
 * Servlet implementation class GetPieChartData
 */
@WebServlet("/GetPieChartData")
public class GetPieChartData extends HttpServlet {
	private static Map<String, Advertiser> advMap = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPieChartData() {
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

		if (advMap == null) {
			advMap = Populate_Vold.getAdvIdAdvertiserMap();
			System.out.println("Called once for pie chart");
		}

		String pageId = request.getParameter("pageId");
		String selection = request.getParameter("selection");
		String advId = request.getParameter("advId");

		System.out.println("Request Values" + advId + "   " + selection
				+ "    " + pageId);

		Map<String, Integer> bidMap = advMap.get(advId).getBidMap();
		Map<String, Integer> impMap = advMap.get(advId).getImpMap();
		Map<String, Integer> clkMap = advMap.get(advId).getClkMap();
		Map<String, Integer> convMap = advMap
				.get(request.getParameter("advId")).getConvMap();

		Map<Integer, Integer> bidMapFormat = advMap.get(advId)
				.getBidMapFormat();
		Map<Integer, Integer> impMapFormat = advMap.get(advId)
				.getImpMapFormat();
		Map<Integer, Integer> clkMapFormat = advMap.get(advId)
				.getClkMapFormat();
		Map<Integer, Integer> convMapFormat = advMap.get(advId)
				.getConvMapFormat();

		JSONArray jf = new JSONArray();

		if (pageId.equalsIgnoreCase("reg")) {
			Map<String, Integer> currentMap = new HashMap<String, Integer>();
			if (selection.equalsIgnoreCase("Bids")) {
				currentMap = bidMap;
			} else if (selection.equalsIgnoreCase("Impressions")) {
				currentMap = impMap;
			} else if (selection.equalsIgnoreCase("Clicks")) {
				currentMap = clkMap;
			} else if (selection.equalsIgnoreCase("Converts")) {
				currentMap = convMap;
			}

			for (String str : currentMap.keySet()) {
				JSONArray j1 = new JSONArray();
				j1.put(str);
				j1.put(currentMap.get(str));
				jf.put(j1);
			}
		}

		else if (pageId.equalsIgnoreCase("cat")) {
			Map<Integer, Integer> currentMap = new HashMap<Integer, Integer>();
			if (selection.equalsIgnoreCase("Bids")) {
				currentMap = bidMapFormat;
			} else if (selection.equalsIgnoreCase("Impressions")) {
				currentMap = impMapFormat;
			} else if (selection.equalsIgnoreCase("Clicks")) {
				currentMap = clkMapFormat;
			} else if (selection.equalsIgnoreCase("Converts")) {
				currentMap = convMapFormat;
			}

			for (Integer integer : currentMap.keySet()) {
				JSONArray j1 = new JSONArray();
				String type = "";
				if (integer == 0) {
					type = "Fixed Slot Ad";
				} else if (integer == 1) {
					type = "Pop Up Ad";
				} else if (integer == 2) {
					type = "Back Ground Ad";
				} else if (integer == 3) {
					type = "Floating Ad";

				} else if (integer == 4) {
					type = "Blur Image Ad";

				} else {
					type = "Not Mentioned";
				}
				j1.put(type);
				j1.put(currentMap.get(integer));
				jf.put(j1);
			}
		}

		/*
		 * else {
		 * 
		 * System.out.println("will return this");
		 * 
		 * JSONArray j1 = new JSONArray(); j1.put("Fixed Ad Slot"); j1.put(236);
		 * 
		 * JSONArray j2 = new JSONArray(); j2.put("Pop Up Ad"); j2.put(109);
		 * 
		 * JSONArray j3 = new JSONArray(); j3.put("Video Ad"); j3.put(16);
		 * 
		 * jf.put(j1); jf.put(j2); jf.put(j3);
		 * 
		 * }
		 */
		JSONObject jo = new JSONObject();
		try {
			jo.put("keyVal", jf);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.getWriter().write(jo.toString());

	}

}
