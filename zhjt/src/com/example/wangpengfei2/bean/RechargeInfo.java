package com.example.wangpengfei2.bean;

public class RechargeInfo {
	private String carNumber;//С�����
	private int money;//��ֵ���
	private int balance;//���
	//private StringrechargeUser;//��ֵ�û���
	private long rechargeTime;//��ֵʱ���д��Ӧ��Get��Set������
	
	
	public String getCarNumber(){
		return carNumber;
		
		
	}
	
	
	public void setCarNumber(String carNumber){
		this.carNumber=carNumber;
		
	}
	
	public int getMoney(){
		return money;
		
	}
	
	public void setMoney(int money){
		this.money=money;
	}
	
	
	public long getRechargeTime() {
		return rechargeTime;
		
		
	}
	
	public void setRechargeTime(long rechargeTime) {
		this.rechargeTime=rechargeTime;
		
		
	}

public int getBalance(){
	return balance;
	
}
	public void setBalance(int balance){
		this.balance=balance;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
