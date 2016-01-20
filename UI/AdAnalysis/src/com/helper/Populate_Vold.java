package com.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Populate_Vold {

	static Map<String, Advertiser> advMap = new HashMap<>();

	public static void populate(List<BufferedReader> brList) throws IOException {
		int count = 1;
		for (BufferedReader br : brList) {

			String line = null;

			while ((line = br.readLine()) != null) {
				String[] values = line.split("\t");

				if (!advMap.containsKey(values[0])) {
					Advertiser temp = new Advertiser();

					temp.setNoOfBids(Integer.parseInt(values[1]));
					Map<String, Integer> tempBid = new HashMap<>();

					for (int i = 2; i < 37; i++) {

						String[] keyVal = values[i].split("\\|");
						tempBid.put(keyVal[0], Integer.parseInt(keyVal[1]));
					}
					temp.setBidMap(tempBid);

					Map<Integer, Integer> tempBidformat = new HashMap<>();
					for (int i = 37; i < values.length; i++) {
						String[] keyVal = values[i].split("\\|");
						tempBidformat.put(Integer.parseInt(keyVal[0]),
								Integer.parseInt(keyVal[1]));
					}
					temp.setBidMapFormat(tempBidformat);

					advMap.put(values[0], temp);

				} else {

					Advertiser temp = advMap.get(values[0]);

					if (count == 2) {
						temp.setNoOfImp(Integer.parseInt(values[1]));
						Map<String, Integer> tempImp = new HashMap<>();

						for (int i = 2; i < 37; i++) {
							String[] keyVal = values[i].split("\\|");
							tempImp.put(keyVal[0], Integer.parseInt(keyVal[1]));
						}
						temp.setImpMap(tempImp);

						Map<Integer, Integer> tempImpformat = new HashMap<>();
						for (int i = 37; i < values.length; i++) {
							String[] keyVal = values[i].split("\\|");
							tempImpformat.put(Integer.parseInt(keyVal[0]),
									Integer.parseInt(keyVal[1]));
						}

						temp.setImpMapFormat(tempImpformat);

					} else if (count == 3) {
						temp.setNoOfClicks(Integer.parseInt(values[1]));
						Map<String, Integer> tempclk = new HashMap<>();

						for (int i = 2; i < 37; i++) {
							String[] keyVal = values[i].split("\\|");
							tempclk.put(keyVal[0], Integer.parseInt(keyVal[1]));
						}
						temp.setClkMap(tempclk);

						Map<Integer, Integer> tempClkformat = new HashMap<>();
						for (int i = 37; i < values.length; i++) {
							String[] keyVal = values[i].split("\\|");
							tempClkformat.put(Integer.parseInt(keyVal[0]),
									Integer.parseInt(keyVal[1]));
						}

						temp.setClkMapFormat(tempClkformat);

					} else {

						temp.setNoOfConv(Integer.parseInt(values[1]));
						Map<String, Integer> tempConv = new HashMap<>();

						for (int i = 2; i < 37; i++) {
							String[] keyVal = values[i].split("\\|");
							tempConv.put(keyVal[0], Integer.parseInt(keyVal[1]));
						}
						temp.setConvMap(tempConv);

						Map<Integer, Integer> tempConvformat = new HashMap<>();
						for (int i = 37; i < values.length; i++) {
							String[] keyVal = values[i].split("\\|");
							tempConvformat.put(Integer.parseInt(keyVal[0]),
									Integer.parseInt(keyVal[1]));
						}

						temp.setConvMapFormat(tempConvformat);

					}

					advMap.put(values[0], temp);
				}

			}
			count++;
		}

	}

	/*
	 * public static Advertiser getAdvertiser(String adv_Id){
	 * 
	 * if(adv_Id==null) return null; else{ String
	 * bootStrapURl="tcp://localhost:6666"; StoreClientFactory factory = new
	 * SocketStoreClientFactory(new
	 * ClientConfig().setBootstrapUrls(bootStrapURl));
	 * 
	 * StoreClient<String, Object> client = factory.getStoreClient("Adv_Data");
	 * Advertiser version = (Advertiser)client.getValue("3358");
	 * 
	 * return version; }
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println(getAdvIdAdvertiserMap().size());
		//System.out.println(advMap.get("1458"));
	}

	public static Map<String, Advertiser> getAdvIdAdvertiserMap()
			throws IOException {
		// TODO Auto-generated method stub
		List<BufferedReader> brList = new ArrayList<>();
		String[] args = new String[4];
		args[0] = "bid-red";
		args[1] = "imp-red";
		args[2] = "clk-red";
		args[3] = "conv-red";

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				BufferedReader br = new BufferedReader(new FileReader("C:/Users/Master/workspace/AdAnalysis/"+args[i]));
				brList.add(br);
			}
		}
		populate(brList);
		return advMap;

	}
}
