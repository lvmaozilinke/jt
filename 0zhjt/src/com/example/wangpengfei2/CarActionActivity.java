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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CarActionActivity extends BaseActivity {
	ImageView mTitleImg;//定义到父类中去
	TextView mTitleTv;//定义到父类中去
	String[] mCarActions={"Start","Stop"};
	Spinner mCaridSpinner,mCaractionSpinner;
	int mCarId=1;
	String mCarAction="Start";
	Button mSettingBtn;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.car_action_layout);
		InitView();
		SetCarAction();
		SetSpinnerData();
		
	}
	
	
	//初始化小车动作
	private void SetSpinnerData() {
		mCaridSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
					mCarId=Integer.
							parseInt( mCaridSpinner.getItemAtPosition(arg2).toString().trim());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

				
			}
		});

		ArrayAdapter<String> caractionAdapter=
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mCarActions);
		mCaractionSpinner.setAdapter(caractionAdapter);
		mCaractionSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mCarAction=mCaractionSpinner.getItemAtPosition(arg2).toString().trim();
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

				
			}
		});
	}

	//设置小车动作
	private void SetCarAction() {
		mSettingBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
					//需要联网，解析返回数据
				HttpAPI.getInstance(CarActionActivity.this).
					SetCarAction(mCarId, mCarAction, new Listener<JSONObject>(){

						@Override
						public void onResponse(JSONObject arg0) {
							// TODO Auto-generated method stub
							String mresult=(String) arg0.opt("result");
							if(mresult.equalsIgnoreCase("OK")){
								Toast.makeText(CarActionActivity.this, "设置小车"+mCarAction+"动作成功!", Toast.LENGTH_LONG);
								
							}else{
								Toast.makeText(CarActionActivity.this, "设置小车"+mCarAction+"动作失败!", Toast.LENGTH_LONG);

							}
						}}, new  ErrorListener(){

							@Override
							public void onErrorResponse(VolleyError arg0) {

								
							}});

			}
		});
		
	}
	//绑定控件
	private void InitView() {
		mTitleTv=(TextView) findViewById(R.id.title_tv);
		mTitleTv.setText(R.string.car_action_str);
		
		mTitleImg=(ImageView) findViewById(R.id.title_img);
		mTitleImg.setImageResource(R.drawable.close);
		
		mTitleImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				CarActionActivity.this.finish();
			}
		});
		mCaridSpinner=(Spinner) findViewById(R.id.carid_action_spinner);
		mCaractionSpinner=(Spinner) findViewById(R.id.car_action_spinner);
		mSettingBtn=(Button) findViewById(R.id.car_action_set_btn);
	}
	

}






























































































//private Spinner spinner2;
//private List<String>getData(){
//	// 数据源
//	List<String> dataList=new ArrayList<String>();
//	dataList.add("北京");
//	dataList.add("上海");
//	dataList.add("南京");
//	dataList.add("宜昌");
//	return dataList;
//}
//Initview();
//}

//public void Initview() {
//spinner2=(Spinner) findViewById
//		(R.id.car_action_spinner);
//ArrayAdapter<String>adapter=
//		new ArrayAdapter<String>
//(this, android.R.layout.simple_spinner_item,getData());
//spinner2.setAdapter(adapter);
//}