package com.example.wangpengfei2.bean;

public class BusItemBean {
	private String busNo;//公交编号
	//距离
	private String distance;
	private int busIcon;//公交图片
	public BusItemBean(String busNo, String distance, int busIcon) {
//		super();
		this.busNo = busNo;
		this.distance = distance;
		this.busIcon = busIcon;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getBusIcon() {
		return busIcon;
	}
	public void setBusIcon(int busIcon) {
		this.busIcon = busIcon;
	}
	
}
