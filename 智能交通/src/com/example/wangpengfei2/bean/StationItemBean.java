package com.example.wangpengfei2.bean;

import java.util.List;



public class StationItemBean {
	private String Stationtitle;
	private List<BusItemBean> childList;
	public StationItemBean(String stationtitle, List<BusItemBean> childList) {
//		super();
		Stationtitle = stationtitle;
		this.childList = childList;
	}
	public String getStationtitle() {
		return Stationtitle;
	}
	public void setStationtitle(String stationtitle) {
		Stationtitle = stationtitle;
	}
	public List<BusItemBean> getChildList() {
		return childList;
	}
	public void setChildList(List<BusItemBean> childList) {
		this.childList = childList;
	}
	public CharSequence getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
