package com.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Advertiser implements Serializable {
	
	private int noOfBids,noOfImp,noOfClicks,noOfConv;
	
	private Map<String,Integer> bidMap=new HashMap<String,Integer>();
	private Map<String,Integer> impMap=new HashMap<String,Integer>();
	private Map<String,Integer> clkMap=new HashMap<String,Integer>();
	private Map<String,Integer> convMap=new HashMap<String,Integer>();
	
	private Map<Integer,Integer> bidMapFormat=new HashMap<Integer,Integer>();
	private Map<Integer,Integer> impMapFormat=new HashMap<Integer,Integer>();
	private Map<Integer,Integer> clkMapFormat=new HashMap<Integer,Integer>();
	private Map<Integer,Integer> convMapFormat=new HashMap<Integer,Integer>();
	
	
	public Map<String, Integer> getBidMap() {
		return bidMap;
	}

	public void setBidMap(Map<String, Integer> bidMap) {
		this.bidMap = bidMap;
	}

	public Map<String, Integer> getImpMap() {
		return impMap;
	}

	public void setImpMap(Map<String, Integer> impMap) {
		this.impMap = impMap;
	}

	public Map<String, Integer> getClkMap() {
		return clkMap;
	}

	public void setClkMap(Map<String, Integer> clkMap) {
		this.clkMap = clkMap;
	}

	public Map<String, Integer> getConvMap() {
		return convMap;
	}

	public void setConvMap(Map<String, Integer> convMap) {
		this.convMap = convMap;
	}

	public Map<Integer, Integer> getBidMapFormat() {
		return bidMapFormat;
	}

	public void setBidMapFormat(Map<Integer, Integer> bidMapFormat) {
		this.bidMapFormat = bidMapFormat;
	}

	public Map<Integer, Integer> getImpMapFormat() {
		return impMapFormat;
	}

	public void setImpMapFormat(Map<Integer, Integer> impMapFormat) {
		this.impMapFormat = impMapFormat;
	}

	public Map<Integer, Integer> getClkMapFormat() {
		return clkMapFormat;
	}

	public void setClkMapFormat(Map<Integer, Integer> clkMapFormat) {
		this.clkMapFormat = clkMapFormat;
	}

	public Map<Integer, Integer> getConvMapFormat() {
		return convMapFormat;
	}

	public void setConvMapFormat(Map<Integer, Integer> convMapFormat) {
		this.convMapFormat = convMapFormat;
	}

	
	
	
	
	public int getNoOfBids() {
		return noOfBids;
	}

	public void setNoOfBids(int noOfBids) {
		this.noOfBids = noOfBids;
	}

	public int getNoOfImp() {
		return noOfImp;
	}

	public void setNoOfImp(int noOfImp) {
		this.noOfImp = noOfImp;
	}

	public int getNoOfClicks() {
		return noOfClicks;
	}

	public void setNoOfClicks(int noOfClicks) {
		this.noOfClicks = noOfClicks;
	}

	public int getNoOfConv() {
		return noOfConv;
	}

	public void setNoOfConv(int noOfConv) {
		this.noOfConv = noOfConv;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb=new StringBuilder();
		sb.append("No. Of Bids: "+noOfBids+"\n"+"No. Of Imp: "+noOfImp+"\n"
					+"No. Of Clks: "+noOfClicks+"\n"+"No. Of Conv: "+noOfConv+"\n");
		sb.append("BidMapSize: "+bidMap.size()+" ImpMapSize: "+impMap.size()+" ClkMapSize: "+clkMap.size()+" ConvMapSize: "+convMap.size());
		sb.append(" BidMapFormatSize: "+bidMapFormat.size()+" ImpMapFormatSize: "+impMapFormat.size()+" ClkMapFormatSize: "+clkMapFormat.size()+" ConvMapFormatSize: "+convMapFormat.size());
		
		
		return sb.toString();
		
		
	}

}
