package com.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import naivebayes.Class1;

import com.mathworks.toolbox.javabuilder.MWException;

public class NB {

	public static void main(String[] args) throws RuntimeException, IOException {

		/*NaiveByes("3386", "15(jilin)", "5(Floating)", "F", "1", "1", "1", "1",
				"1");*/
		
		checkFile();
	}

	public static String NaiveByes(String advId, String region, String adType,
			String gender, String autoI, String eduI, String litI,
			String newsI, String entI) {
		try {

			BufferedReader bReader = new BufferedReader(new FileReader("C:/Users/Master/workspace/AdAnalysis/data"));

			HashMap<Integer, Integer> adId = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> regId = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> userTagId = new HashMap<Integer, Integer>();
			HashSet<String> bidId = new HashSet<String>();

			adId.put(1458, 0);
			adId.put(3358, 1);
			adId.put(3386, 2);
			adId.put(3427, 3);
			adId.put(3476, 4);

			String line;
			int data[][] = new int[2600][9];
			int label[][] = new int[2600][1];
			int i = 0;
			int regCount = 0;

			for (int z = 0; z < 1289; z++)
				label[z][0] = 1;

			while ((line = bReader.readLine()) != null) { // line =
															// bReader.readLine();
				String datavalue[] = line.split("\t");

				int adIdtemp = Integer.parseInt(datavalue[0]);
				if (adId.containsKey(adIdtemp))
					data[i][0] = adId.get(adIdtemp);

				int regIdtemp = Integer.parseInt(datavalue[1]);
				if (regId.containsKey(regIdtemp))
					data[i][1] = regId.get(regIdtemp);
				else {
					regId.put(regIdtemp, regCount++);
					data[i][1] = regId.get(regIdtemp);
				}

				data[i][2] = Integer.parseInt(datavalue[2]);

				String temp[] = datavalue[3].split(",");

				for (int k = 0; k < temp.length; k++) {
					if (temp[k].equalsIgnoreCase("10110")
							|| temp[k].equalsIgnoreCase("null")) {
						data[i][3] = 1;
					}

					if (temp[k].equalsIgnoreCase("10031")) {
						data[i][4] = 1;
					} else if (temp[k].equalsIgnoreCase("10024")) {
						data[i][5] = 1;
					} else if (temp[k].equalsIgnoreCase("13866")) {
						data[i][6] = 1;
					} else if (temp[k].equalsIgnoreCase("10006")) {
						data[i][7] = 1;
					} else if (temp[k].equalsIgnoreCase("10063")) {
						data[i][8] = 1;
					}
				}

				bidId.add(datavalue[4]);
				i++;

			}
			System.out.println(i);
			for (int m = 0; m < 1; m++) {
				BufferedReader bfReader = new BufferedReader(new FileReader(
						"C:/Users/Master/workspace/AdAnalysis/data0000" + m));

				while ((line = bfReader.readLine()) != null && i < 2600) {
					String datavalue[] = line.split("\t");

					if (!bidId.contains((datavalue[4]))) {

						int adIdtemp = Integer.parseInt(datavalue[0]);
						if (adId.containsKey(adIdtemp)) {
							// System.out.println(i);
							data[i][0] = adId.get(adIdtemp);
						}

						int regIdtemp = Integer.parseInt(datavalue[1]);
						if (regId.containsKey(regIdtemp))
							data[i][1] = regId.get(regIdtemp);
						else {
							regId.put(regIdtemp, regCount++);
							data[i][1] = regId.get(regIdtemp);
						}

						data[i][2] = Integer.parseInt(datavalue[2]);

						String temp[] = datavalue[3].split(",");

						for (int k = 0; k < temp.length; k++) {
							if (temp[k].equalsIgnoreCase("10110")
									|| temp[k].equalsIgnoreCase("null")) {
								data[i][3] = 1;
							}

							if (temp[k].equalsIgnoreCase("10031")) {
								data[i][4] = 1;
							} else if (temp[k].equalsIgnoreCase("10024")) {
								data[i][5] = 1;
							} else if (temp[k].equalsIgnoreCase("13866")) {
								data[i][6] = 1;
							} else if (temp[k].equalsIgnoreCase("10006")) {
								data[i][7] = 1;
							} else if (temp[k].equalsIgnoreCase("10063")) {
								data[i][8] = 1;
							}
						}

						label[i][0] = 0;
						i++;
					}

				}

			}

			Class1 nb = new Class1();

			// double test[][]={{3,15,5,1,1,0,1,0,1}};
			double test[][] = new double[1][9];

			if (adId.containsKey(Integer.parseInt(advId)))
				test[0][0] = adId.get(Integer.parseInt(advId));

			StringBuilder sb = new StringBuilder();

			for (int c = 0; c < region.length(); c++) {
				if (region.charAt(c) == '(')
					break;
				else
					sb.append(region.charAt(c));

			}

			if (regId.containsKey(Integer.parseInt(sb.toString())))
				test[0][1] = regId.get(Integer.parseInt(sb.toString()));

			// System.out.println("Adtype:"+adType);
			StringBuilder sb2 = new StringBuilder();
			sb2.append(adType.charAt(0));
			test[0][2] = Double.parseDouble(sb2.toString());
			// System.out.println("Adtype:"+test[0][2]);

			if (gender.equalsIgnoreCase("M"))
				test[0][3] = 1;
			else
				test[0][3] = 0;

			if (autoI.equalsIgnoreCase("1"))
				test[0][4] = 1;
			else
				test[0][4] = 0;

			if (eduI.equalsIgnoreCase("1"))
				test[0][5] = 1;
			else
				test[0][5] = 0;

			if (litI.equalsIgnoreCase("1"))
				test[0][6] = 1;
			else
				test[0][6] = 0;

			if (newsI.equalsIgnoreCase("1"))
				test[0][7] = 1;
			else
				test[0][7] = 0;

			if (entI.equalsIgnoreCase("1"))
				test[0][8] = 1;
			else
				test[0][8] = 0;

			/*
			 * for(int z=0;z<9;z++) System.out.println(test[0][z]);
			 */
			/*
			 * test[0][0]=0;test[0][1]=10;test[0][2]=0;test[0][3]=1;test[0][4]=0;
			 * test[0][5]=0;test[0][6]=0;test[0][7]=0;test[0][8]=0;
			 */

			Object[] classObtained = nb.naivebayes(1, data, label, test, 0.0);
			System.out.println(classObtained[0]);
			return classObtained[0].toString();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}
	
	public static void checkFile() throws FileNotFoundException{
		BufferedReader bReader = new BufferedReader(new FileReader("bid-red"));

	}
}
