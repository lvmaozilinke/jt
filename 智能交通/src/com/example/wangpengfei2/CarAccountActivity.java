  package com.example.wangpengfei2;

import org.json.JSONObject;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.db.RechargeHistoryDao;
import com.example.wangpengfei2.dialog.Base;
import com.example.wangpengfei2.dialog.Base.OnRechargeListener;
import com.example.wangpengfei2.dialog.Rech;
import com.example.wangpengfei2.dialog.RechargeRecorddialog;
import com.example.wangpengfei2.network.HttpAPI;

import android.annotation.SuppressLint;
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

@SuppressLint("ShowToast")
public class CarAccountActivity extends BaseActivity {
	TextView mTitleTv;
	ImageView mTitleImg;
	Spinner mCaridSpinner;
	int mCarId=1;
	Button mSearchBtn;
	
	Button mRechargeBtn;//充值按钮
	
	
	TextView mShowAccountYETv;
	TextView mShowAccountJETv;//充值金额显示的Textview
	
	
	Button mSearchRecordBtn;//查询充值记录按钮
	
	boolean mSearchSuccess=false;//标识查询余额成功
	
	
	@Override
	protected void onCreate(Bundle arg0) {

		super.onCreate(arg0);
		this.setContentView(R.layout.car_account_layout);
		
		mShowAccountYETv=(TextView) findViewById(R.id.car_accountYE_tv);
		mTitleTv=(TextView) findViewById(R.id.title_tv);
		mTitleTv.setText(R.string.car_account_str);
		mTitleImg=(ImageView) findViewById(R.id.title_img);
		mTitleImg.setImageResource(R.drawable.close);
		
		InitView();
		
	}
	private void InitView() {	
			mRechargeBtn=(Button) findViewById(R.id.car_account_recharge_btn);
			
			mRechargeBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//GetCarAcountYE();
					Base dialog=new Rech(CarAccountActivity.this,mCarId);
					
					dialog.SetOnRechargeListener(new OnRechargeListener() {
						
						@Override
						public void OnRecharge(int mMoney, boolean isSuccess) {

//							if(isSuccess&&CarAccountActivity.this.mSearchSuccess){
								mShowAccountJETv.setText(CarAccountActivity.this.getResources().getString(R.string.car_show_JE_str,mMoney));
								int mBalance=Integer.parseInt(mShowAccountYETv.getText().toString().trim());
								
								RechargeHistoryDao.getInstance(CarAccountActivity.this).add(mCarId+"", mMoney, mBalance+mMoney, System.currentTimeMillis());
								
								
								
//							}else{
//								Toast.makeText(CarAccountActivity.this, "小车账户充值失败！", Toast.LENGTH_LONG).show();
								
//							}
						}
					});
					
					dialog.setCancelable(false);
					dialog.show(getFragmentManager(),"dialog");
						
					
				}
			});
			mSearchRecordBtn=(Button) findViewById(R.id.car_account_record_btn);
			mSearchRecordBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
							Base dialog=new RechargeRecorddialog(CarAccountActivity.this);
							dialog.setCancelable(false);
							
							dialog.show(getFragmentManager(), "RechargeRecorddialog");
							
			
					
				}
			});
			
			
			mShowAccountJETv=(TextView) findViewById(R.id.car_accountJE_tv);
			mShowAccountYETv=(TextView)findViewById(R.id.car_accountYE_tv);
			mTitleTv=(TextView)findViewById(R.id.title_tv);
			mTitleTv.setText(R.string.car_account_str);
			mTitleImg=(ImageView)findViewById(R.id.title_img);
			mTitleImg.setImageResource(R.drawable.close);
			mTitleImg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					CarAccountActivity.this.finish();
					
				}
			});
			mCaridSpinner=(Spinner)findViewById(R.id.carid_account_spinner);
			mCaridSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					mCarId=Integer.parseInt(mCaridSpinner.getItemAtPosition(arg2).toString().trim());
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			mSearchBtn=(Button)findViewById(R.id.car_account_remain_btn);
			mSearchBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {

					GetCarAcountYE();
				}
			});
		}
		
				protected void GetCarAcountYE() {
					// TODO Auto-generated method stub
					//需要联网，需要解析返回数据
					HttpAPI.getInstance(CarAccountActivity.this).GetAccountYE(mCarId, new Listener<JSONObject>(){

						@Override
						public void onResponse(JSONObject arg0) {
							// TODO Auto-generated method stub
							if(arg0.has("Balance")){
								String mresult=(String)arg0.opt("Balance");
								mShowAccountYETv.setText(CarAccountActivity.this.getResources().getString(R.string.car_show_JE_str,mresult));
								//handler把我们获取的数据返回给界面更新
								
								mSearchSuccess=true;
								
								Toast.makeText(CarAccountActivity.this,"获取下车账户余额成功",Toast.LENGTH_LONG).show();
							}else{
								mSearchSuccess=false;
								
								Toast.makeText(CarAccountActivity.this,"获取下车账户余额失败",Toast.LENGTH_LONG).show();
							}
							
						}}, new ErrorListener(){

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub
								
							}
							});
		
	}
	
	
}
