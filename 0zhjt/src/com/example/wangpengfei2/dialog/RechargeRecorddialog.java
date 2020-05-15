package com.example.wangpengfei2.dialog;

import java.util.ArrayList;

import com.example.wangpengfei2.R;
import com.example.wangpengfei2.adapter.RechargeRecordAdpter;
import com.example.wangpengfei2.bean.RechargeInfo;
import com.example.wangpengfei2.db.RechargeHistoryDao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class RechargeRecorddialog extends Base {
Context mcontext;
Button btn1;

ListView mListview;
RechargeRecordAdpter mAdapter;
ArrayList<RechargeInfo>mList;
Button mReturnBtn;

TextView mShowInfoTv;


	public RechargeRecorddialog(Context mcontext) {
		super(mcontext);
		
		this.mcontext=mcontext;
		mList=new ArrayList<RechargeInfo>();
		
		

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
	
			InitData();
			InitView();

	
	}

	private void InitView() {
		//初始化控件
		
		mListview=(ListView)getView().findViewById(R.id.car_recharge_record_listview);
		mAdapter=new RechargeRecordAdpter(mcontext, mList);
		
		
		mShowInfoTv=(TextView) getView().findViewById(R.id.tv_no_record_message);
		
		if(mList.size()<1){
			mShowInfoTv.setVisibility(1);
		
		}else{
				mShowInfoTv.setVisibility(-1);//消失
		}
		
		mListview.setAdapter(mAdapter);
		
		mReturnBtn=(Button) getView().findViewById(R.id.car_return_btn);
		mReturnBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				RechargeRecorddialog.this.dismiss();
				
			}
		});
	}

	private void InitData() {
		//查询充值记录信息
//		
		mList.clear();
		mList=(ArrayList<RechargeInfo>)RechargeHistoryDao.getInstance(mcontext).queryAll();
//		
//		RechargeInfo mRechargeInfo=null;
//		for(int i=0;i<4;i++){
//			mRechargeInfo=new RechargeInfo();
//			mRechargeInfo.setCarNumber(i+"");
//			mRechargeInfo.setMoney(i*100+i);
//			mRechargeInfo.setBalance(i*100+i*10);
//			mRechargeInfo.setRechargeTime(System.currentTimeMillis());
//			mList.add(mRechargeInfo);
//			
		}
		


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.car_recharge_record, container, false);
		
	}
	

}
