package com.example.wangpengfei2.bean;
//����ÿ��·�ڵ�bean����Ϣ
public class TrafficLightBean {
	private int roadNo;//·�ڱ��
	private int redTime;//���ʱ��
	private int greenTime;//�̵�ʱ��
	private int yellowTime;//�Ƶ�ʱ��
	
	

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
