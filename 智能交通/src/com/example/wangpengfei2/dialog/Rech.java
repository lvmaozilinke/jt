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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class Rech extends Base {
Button mOKbtn,mCancelBtn;
int mCarId;
TextView mShowCaridTv;
EditText mRechargeMoneyEt;


	public Rech(Context mcontext, int mCarId) {
		super(mcontext);
		this.mCarId=mCarId;
		

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		InitView();
		setListener();
		
	}

	private void InitView() {
		
		mOKbtn=(Button) getView().findViewById(R.id.bt_dialog_account_change);
		mCancelBtn=(Button) getView().findViewById(R.id.bt_dialog_account_cancel);
		mShowCaridTv=(TextView) getView().findViewById(R.id.car_id_dialog_account_recharge);
		mShowCaridTv.setText(mCarId+"");
		
		mRechargeMoneyEt=(EditText) getView().findViewById(R.id.edt_dialog_account_charge_money);
		
		
	}

	private void setListener() {
		mCancelBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Rech.this.dismiss();
				
				
			}
		});
		
		mOKbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(onRechargelistener!=null){
					String mMoney=mRechargeMoneyEt.getText().toString();
					if(!TextUtils.isEmpty(mMoney)){//TextUtils�жϲ����ڿ�
						int money=Integer.parseInt(mMoney);
						
						//��ʱ��ӣ�
						onRechargelistener.OnRecharge(money, isRechargeSuccess);//����1
						Toast.makeText(mcontext,"С���˻���ֵ�ɹ���",Toast.LENGTH_LONG).show();
						Rech.this.dismiss();
						
						
//						SetCarAccountRequest(money);//������ֵ����
						
						
					}else{
						Toast.makeText(mcontext,"����Ϊ��",Toast.LENGTH_LONG).show();
						
					}
				}
			
				
			}
		});
		
		
	}
	

	protected void SetCarAccountRequest(final int money) {
		HttpAPI.getInstance(mcontext).SetCarAccountRequest(mCarId,money, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
					try {
						if(arg0.getString("result").equalsIgnoreCase("ok")){
							
							isRechargeSuccess=true;
							
							onRechargelistener.OnRecharge(money,isRechargeSuccess);//ʹ�ýӿڴ�������
							//�ڶ��֣�handler�����ǻ�ȡ�����ݴ������������
							
							Toast.makeText(mcontext, "С���˻���ֵ���ɹ���", Toast.LENGTH_LONG).show();
							Rech.this.dismiss();
							
						}else{
							isRechargeSuccess=false;
							Toast.makeText(mcontext, "С���˻���ֵ���ʧ��", Toast.LENGTH_LONG).show();
							
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

//		return super.onCreateView(inflater, container, savedInstanceState);
	return inflater.inflate(R.layout.car_recharge_account, container,false);
	
	}
	
	

}
