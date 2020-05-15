package com.example.wangpengfei2.Fragment;

import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.network.HttpAPI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EnvFragment extends Fragment {
	TextView mPm25Tv;
	TextView  mCo2Tv; 
	TextView mTempTv;
	TextView mLightTv;
	TextView mHumiTv;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		InitView();
//		QueryData();
		QueryData2();//重新定义方法【本地方法】
	
	}
	private void QueryData2() {
		mPm25Tv.setText(":120");
		mCo2Tv.setText(":2500");
		mTempTv.setText(":18");
		mLightTv.setText(":1100");
		mHumiTv.setText(":120");		
	}
	private void QueryData() {
	HttpAPI.getInstance(getActivity()).GetAllSense(new Listener<JSONObject>() {
		@Override
		public void onResponse(JSONObject arg0) {
			if(arg0.has("result")){
				Toast.makeText(getActivity(), "联网获取数据失败", Toast.LENGTH_LONG).show();
				return;	
			}
			int light = arg0.optInt("LightIntensity:");
			int temperatur= arg0.optInt("temperature:");
			int co2 = arg0.optInt("co2:");
			int pm = arg0.optInt("pm2.5:");
			int humidity = arg0.optInt("humidity:");	
			
//			mCo2Tv.setText(arg0.optInt("co2"));	
			mPm25Tv.setText(pm+"");
			mCo2Tv.setText(co2+"");
			mTempTv.setText(temperatur+"");
			mLightTv.setText(light+"");
			mHumiTv.setText(humidity+"");		
		}
	},new ErrorListener() {
		@Override
		public void onErrorResponse(VolleyError arg0) {	
		}
	});
	}

	private void InitView() {
		mPm25Tv=(TextView)getView().findViewById(R.id.pm_25_tv);
		mCo2Tv=(TextView)getView().findViewById(R.id.CO2_tv);
		mTempTv=(TextView)getView().findViewById(R.id.temperature_tv);
		mLightTv=(TextView)getView().findViewById(R.id.LightIntensity_tv);
		mHumiTv=(TextView)getView().findViewById(R.id.humidity_tv);	
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate
				(R.layout.fragment_env_layout, container, false);
	}
}
