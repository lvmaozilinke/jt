package com.example.wangpengfei2;



import org.json.JSONObject;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError; 
import com.example.wangpengfei2.network.HttpAPI;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CarSpeedActivity extends BaseActivity {
	TextView mTitleTv;
	ImageView mTitleImg;
	Spinner mCaridSpinner;
	int mCarId=1;
	Button mSearchBtn;
	TextView mShowTv;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.car_speed_layout);
		InitView();
		//GetCarSpeed();
		
	
	}
	
	private void InitView() {
		mShowTv=(TextView) findViewById(R.id.show_carspeed_tv);
		mTitleTv=(TextView) findViewById(R.id.title_tv);
		mTitleTv.setText(R.string.car_speed_str);
		mTitleImg=(ImageView) findViewById(R.id.title_img);
		mTitleImg.setImageResource(R.drawable.close);
		mTitleImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				CarSpeedActivity.this.finish();
			}
		});
		mCaridSpinner=(Spinner) findViewById(R.id.car_speed_spinner);
		mCaridSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mCarId=Integer.parseInt(mCaridSpinner.getItemAtPosition(arg2).toString());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		mSearchBtn=(Button) findViewById(R.id.carspeed_search_btn);
		mSearchBtn.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				GetCarSpeed();
			}

		
		});
	}	
	protected void GetCarSpeed() {
		//联网解析返回数据
		HttpAPI.getInstance(CarSpeedActivity.this).GetCarSpeed(mCarId, null, new Listener<JSONObject>(){

			@Override
			public void onResponse(JSONObject arg0) {

				if(arg0.has("CarSpeed")){
					String mresult=(String)arg0.opt("CarSpeed");
					mShowTv.setText(CarSpeedActivity.this.getResources().getString(R.string.carspeeds_mag_str,mCarId+"",mresult));
				    //Handler把我们获取的数据返回给主界面更新
				}else{
					Toast.makeText(CarSpeedActivity.this,"获取小车速度失败！",Toast.LENGTH_LONG).show();
				}
				
				
			}}, new ErrorListener(){

				@Override
				public void onErrorResponse(VolleyError arg0) {
					// TODO Auto-generated method stub
					
				}});
		
			}
	

}