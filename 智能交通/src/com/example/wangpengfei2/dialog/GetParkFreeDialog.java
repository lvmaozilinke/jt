package com.example.wangpengfei2.dialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.network.HttpAPI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

@SuppressLint("ValidFragment")
public class GetParkFreeDialog extends Base {
	ImageView mLocationImg1,mLocationImg2;
	Button mRturnBtn;
	
	
	Context mcontext;
	public GetParkFreeDialog(Context mcontext) {
		super(mcontext);
		this.mcontext=mcontext;
		InitView();
		GetData();
		SetListener();
	}
	private void SetListener() {
		mRturnBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dismiss();
				
				
			}
		});
		
	}
	private void GetData() {
		HttpAPI.getInstance(mcontext).GetParkFree(new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				
				JSONArray mjsonarray;
				try {
					mjsonarray=new JSONArray(arg0.toString());
					for(int i=0;i<mjsonarray.length();i++){
						JSONObject mjson=mjsonarray.getJSONObject(i);
						int parlid=mjson.getInt("ParkFreedId");
					
						if(parlid==1){
							mLocationImg1.setImageResource(R.drawable.free_location);
							
						}
						
						
						if(parlid==2){
							mLocationImg2.setImageResource(R.drawable.free_location);
							
						}
					}
					
					
				} catch (JSONException e) {
					e.printStackTrace();
					
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
	}
	private void InitView() {
		mLocationImg1=(ImageView)getView().findViewById(R.id.ParkFree_Img1);
		mLocationImg2=(ImageView)getView().findViewById(R.id.ParkFree_Img2);
		mRturnBtn=(Button) getView().findViewById(R.id.ParkFree_Ok_Btn);
		

		
	}
	@Override
	public void onActivityCreated(Bundle arg0) {
		super.onActivityCreated(arg0);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.getparkfree_dialog_layout, container, false);
		
	}
	

}
