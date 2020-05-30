package com.example.wangpengfei2.bean;
//保存每个路口的bean灯信息
public class TrafficLightBean {
	private int roadNo;//路口编号
	private int redTime;//红灯时间
	private int greenTime;//绿灯时间
	private int yellowTime;//黄灯时间
	
	

	public TrafficLightBean(int roadNo, int redTime, int greenTime,
			int yellowTime) {
		
		super();
		this.roadNo = roadNo;
		this.redTime = redTime;
		this.greenTime = greenTime;
		this.yellowTime = yellowTime;
	}
	
	public int getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(int roadNo) {
		this.roadNo = roadNo;
	}

	public int getRedTime() {
		return redTime;
	}

	public void setRedTime(int redTime) {
		this.redTime = redTime;
	}

	public int getGreenTime() {
		return greenTime;
	}

	public void setGreenTime(int greenTime) {
		this.greenTime = greenTime;
	}

	public int getYellowTime() {
		return yellowTime;
	}

	public void setYellowTime(int yellowTime) {
		this.yellowTime = yellowTime;
	}
	
	
}
