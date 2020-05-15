package com.example.wangpengfei2.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.example.wangpengfei2.R;
import com.example.wangpengfei2.bean.RechargeInfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
@SuppressLint("SimpleDateFormat")
public class RechargeRecordAdpter extends BaseAdapter {
	Context mcontext;
	ArrayList<RechargeInfo> aList;


	public RechargeRecordAdpter(Context mcontext, ArrayList<RechargeInfo> aList) {
		super();
		this.mcontext = mcontext;
		this.aList = aList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return aList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return aList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View mview, ViewGroup mContainer) {
		LayoutInflater mInflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewHolder mviewholder=null;
		if(mview==null){
			mview=mInflater.inflate(R.layout.item_recharge_record,mContainer,false);
			mviewholder=new ViewHolder();
			mviewholder.mCarIdTv=(TextView)mview.findViewById(R.id.recharge_record_CarId_tv);
			mviewholder.mRechargeJeTv=(TextView)mview.findViewById(R.id.recharge_record_Je_tv);
			mviewholder.mRechargeYeTv=(TextView)mview.findViewById(R.id.recharge_record_Ye_tv);
			mviewholder.mRechargeDateTv=(TextView)mview.findViewById(R.id.recharge_record_Date_tv);
			mview.setTag(mviewholder);
		}else{
			mviewholder=(ViewHolder)mview.getTag();
		}
		RechargeInfo mbean=(RechargeInfo)aList.get(position);
		mviewholder.mCarIdTv.setText(mbean.getCarNumber());
		mviewholder.mRechargeJeTv.setText(mbean.getMoney()+"");
		mviewholder.mRechargeYeTv.setText(mbean.getBalance()+"");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mviewholder.mRechargeDateTv.setText(format.format(new Date(mbean.getRechargeTime())));
		// TODO Auto-generated method stub
		return mview;
	}
	class ViewHolder{
		TextView mCarIdTv;
		TextView mRechargeJeTv;
		TextView mRechargeYeTv;
		TextView mRechargeDateTv;
		
	}

}
