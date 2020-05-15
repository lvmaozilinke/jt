package com.example.wangpengfei2.bean;

public class ViewPagerBean {
	String PicName="";
	private int PicId;//定义成员变量
	
	//生成读写器【四个方法】
	public String getPicName() {
		return PicName;
	}
	public void setPicName(String picName) {
		PicName = picName;
	}
	public int getPicId() {
		return PicId;
	}
	public void setPicId(int picId) {
		PicId = picId;
	}
	
	
		

}
