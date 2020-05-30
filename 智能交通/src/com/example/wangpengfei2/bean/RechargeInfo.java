package com.example.wangpengfei2.bean;

public class RechargeInfo {
	private String carNumber;//小车编号
	private int money;//充值金额
	private int balance;//余额
	//private StringrechargeUser;//充值用户名
	private long rechargeTime;//充值时间编写对应的Get和Set方法。
	
	
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
