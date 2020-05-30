package com.example.wangpengfei2.dialog;

import com.example.wangpengfei2.Fragment.EnvFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;


@SuppressLint("ValidFragment")
public class Base extends DialogFragment  {
	protected Context mcontext;
	boolean isRechargeSuccess=false;
	
	


	public Base(Context mcontext) {
//		super();
		this.mcontext = mcontext;
	}

	public Base(EnvFragment envFragment) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onActivityCreated(Bundle arg0) {
		this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onActivityCreated(arg0);
	}
	
	OnRechargeListener onRechargelistener=null;
	
	public interface OnRechargeListener{//充值接口类
		public void OnRecharge(int mMoney,boolean isSuccess);
		
		
		
	}
	
	public void SetOnRechargeListener(OnRechargeListener mOnRechargeListener){
		this.onRechargelistener=mOnRechargeListener;
	}
	


	
	

}
