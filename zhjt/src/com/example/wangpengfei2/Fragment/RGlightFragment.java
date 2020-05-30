package com.example.wangpengfei2.Fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.R.id;
import com.example.wangpengfei2.adapter.TrafficLightLVAdapter;
import com.example.wangpengfei2.bean.TrafficLightBean;
import com.example.wangpengfei2.network.HttpAPI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class RGlightFragment extends Fragment {
	Spinner mReguSpinner;
	Button mSortBtn;
	ListView mLightLV;
	ArrayList<TrafficLightBean>mList=null;
	TrafficLightLVAdapter mAdapter;
	
	int mOrderType=0;//保存选择的排序数字方法
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		
		InitView();
		QueryData();
		SetListener();
		
		
	}

	private void SetListener() {
		mReguSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				mOrderType=arg2;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			
			
			}});
		mSortBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				
				sortLight(mOrderType);
				
			}});
	}
	protected void sortLight(int position) {
		if(mList!=null){
			sortLight(position,mList);
			
		}
		

		
	}

	private void sortLight(final int position,
			ArrayList<TrafficLightBean> mList) {
		Collections.sort(mList,new Comparator<TrafficLightBean>() {

			@Override
			public int compare(TrafficLightBean bean1,
					TrafficLightBean bean2) {
				
				switch (position) {
					case 0://降
						return bean2.getRedTime()-bean1.getRedTime();
					case 1://升
						return bean1.getRedTime()-bean2.getRedTime();
						
						
					case 2://降
						return bean2.getYellowTime()-bean1.getYellowTime();
					case 3://升
						return bean1.getYellowTime()-bean2.getYellowTime();
						
						
					case 4://降
						return bean2.getGreenTime()-bean1.getGreenTime();
					case 5://升
						return bean1.getGreenTime()-bean2.getGreenTime();
						
					default:
						return 0;		
					}
			}
		});
//		Log.i("**********排序*******","********排序结果2********");
		if(mAdapter!=null){
//			Log.i("**********排序*******","********排序结果3********");
			mAdapter.notifyDataSetChanged();
			
		}
		
	}
		
		
	

	private void QueryData() {
		if(mList==null){
			mList=new ArrayList<TrafficLightBean>();
			
		}else{
			mList.clear();
			
		}
//		getTrafficLightTimes(1);
		getTrafficLightTimes2(1);
	}

	private void getTrafficLightTimes2(final int RoadId) {
		Random mrandom=new Random();
		int mredTime=mrandom.nextInt(60);
		int mgreenTime=mrandom.nextInt(60);
		int myellowTime=mrandom.nextInt(60);
		TrafficLightBean mbean=new TrafficLightBean
				(RoadId, mredTime, mgreenTime, myellowTime);
		mList.add(mbean);
		
		if(mList.size()==5){
			if(mAdapter==null){
				mAdapter=new TrafficLightLVAdapter(mList, getActivity());
				mLightLV.setAdapter(mAdapter);
				
			}else{
				mAdapter.notifyDataSetChanged();
				
			}
		}else{
			getTrafficLightTimes2(RoadId+1);
			
		}
		

		
	}

	private void getTrafficLightTimes(final int RoadId) {
		HttpAPI.getInstance(getActivity()).GetRgbLightConfig(RoadId, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				TrafficLightBean mbean=new TrafficLightBean(
						RoadId,
						Integer.parseInt(arg0.optString("RedTime")),
						Integer.parseInt(arg0.optString("GreenTime")),
						Integer.parseInt(arg0.optString("YellowTime")));
				mList.add(mbean);
				if(mList.size()==5){
					if(mAdapter==null){
						mAdapter=new TrafficLightLVAdapter(mList,getActivity());
						mLightLV.setAdapter(mAdapter);
						
					}else{
						mAdapter.notifyDataSetChanged();
						
					}
				}else{
					getTrafficLightTimes(RoadId+1);
					
				}

				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	private void InitView() {
		//关联控件【getView】		
		mReguSpinner=(Spinner) getView().findViewById(R.id.select_regular_spinner);
		mSortBtn=(Button) getView().findViewById(R.id.sort_btn);
		mLightLV=(ListView) getView().findViewById(R.id.list_view_light);
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate
				(R.layout.fragment_rglight_layout, container, false);
		
		
	}

	
}
