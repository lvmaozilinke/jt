package com.example.wangpengfei2.adapter;

import java.util.ArrayList;

import com.example.wangpengfei2.R;
import com.example.wangpengfei2.bean.TrafficLightBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TrafficLightLVAdapter extends BaseAdapter {
	ArrayList<TrafficLightBean> mList;//路口红绿灯信息数组
	Context mcontext;
	
	
	public TrafficLightLVAdapter(ArrayList<TrafficLightBean> mList,
			Context mcontext) {
		
		super();
		this.mList = mList;
		this.mcontext = mcontext;
	}

	
	@Override
	public int getCount() {//获得列表的条目数
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {

		return mList.get(arg0);
		
	}

	@Override
	public long getItemId(int arg0) {

		return arg0;
	}
//生成每个小条目的视图
	@Override
	public View getView(int position, View mView, ViewGroup mContainer) {
		ViewHolder holder=null;//内部类对象
		LayoutInflater mInflater=LayoutInflater.from(mcontext);//布局转换器
		if(mView==null){
			mView=mInflater.inflate(R.layout.item_rgblight_listview_layout,mContainer, false);
			holder=new ViewHolder();
			holder.mRoadNoTv=(TextView) mView.findViewById(R.id.across_id_Tv);
			holder.mRedTimeTv=(TextView) mView.findViewById(R.id.red_light_Tv);
			holder.mGreenTimeTv=(TextView) mView.findViewById(R.id.green_light_Tv);
			holder.mYellowTimeTv=(TextView) mView.findViewById(R.id.yellow_light_Tv);
			mView.setTag(holder);
			
		}else{
			holder=(ViewHolder) mView.getTag();
		}
		
		TrafficLightBean bean=mList.get(position);
		holder.mRoadNoTv.setText(bean.getRoadNo()+"");
		holder.mRedTimeTv.setText(bean.getRedTime()+"");
		holder.mGreenTimeTv.setText(bean.getGreenTime()+"");
		holder.mYellowTimeTv.setText(bean.getYellowTime()+"");
		

		return mView;
	}
	class ViewHolder{//内部类
		
		TextView mRoadNoTv;
		TextView mRedTimeTv;
		TextView mGreenTimeTv;
		TextView mYellowTimeTv;
		
		
		
		
	}

	
}
