package com.example.wangpengfei2.dialog;



import android.annotation.SuppressLint;

import android.app.DialogFragment;



import android.content.Context;
import android.os.Bundle;


import android.view.Window;


@SuppressLint("ValidFragment")
public class Base extends DialogFragment  {
	protected Context mcontext;
	boolean isRechargeSuccess=false;
	
	


	public Base(Context mcontext) {
//		super();
		this.mcontext = mcontext;
	}



	@Override
	public void onActivityCreated(Bundle arg0) {
		this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onActivityCreated(arg0);
	}
	
	OnRechargeListener onRechargelistener=null;
	
	public interface OnRechargeListener{//��ֵ�ӿ���
		public void OnRecharge(int mMoney,boolean isSuccess);
		
		
		
	}
	
	public void SetOnRechargeListener(OnRechargeListener mOnRechargeListener){
		this.onRechargelistener=mOnRechargeListener;
	}
	


	
	

}
