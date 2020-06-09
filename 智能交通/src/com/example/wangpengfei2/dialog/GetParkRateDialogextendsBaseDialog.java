package com.example.wangpengfei2.dialog;

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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class GetParkRateDialogextendsBaseDialog extends Base {
	
	Context mcontext;
	TextView mRateTv;
	TextView mMoneyTv;

	public GetParkRateDialogextendsBaseDialog(Context mcontext,
			Context mcontext2) {
		super(mcontext);
		mcontext = mcontext2;
	}

	@Override
	public void onActivityCreated(Bundle arg0) {

		super.onActivityCreated(arg0);
		InitView();
		getData();
	}

	private void getData() {
		HttpAPI.getInstance(mcontext).GetParkRate(new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				try {
					if(arg0.has("result")){
						Toast.makeText(getActivity(),"≤È—Ø ß∞‹",Toast.LENGTH_LONG).show();
						return;
						}
					mRateTv.setText(arg0.getString("RateType"));
					mMoneyTv.setText(arg0.getString("Money"));
					
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
		mRateTv=(TextView)getView().findViewById(R.id.show_ratetype_tv);
		mMoneyTv=(TextView)getView().findViewById(R.id.show_rateJe_tv);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

//		return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.getparkrate_dialog_layout, container, false);
		
	}
	

}
