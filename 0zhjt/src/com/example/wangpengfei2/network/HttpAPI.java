package com.example.wangpengfei2.network;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;

public class HttpAPI {
	private static HttpAPI mHttpApi;
	private Context mcontext;
	private RequestQueue mQueue;
	private String mServerIp=
			"Http://192.168.1.100:8080/transportservice/type/jason/action/";
	//联网使用的IP


	
	
	
	public HttpAPI(Context mcontext) {
		
//		super();
		this.mcontext = mcontext;
		//创建队列
		mQueue=Volley.newRequestQueue(mcontext);	
	}
	public static void init(Context mcontext){
		//创建对象
		mHttpApi=new HttpAPI(mcontext);
	}
	
	public static HttpAPI getInstance(Context mcontext){
		if(mHttpApi==null){
			init(mcontext);
		}
			return mHttpApi;
	}
	public void SetCarAction(int Carid,String mCarAction,Listener<JSONObject> listener,ErrorListener errorlistener){
		JSONObject mobject=new JSONObject();
		try {
			mobject.put("CarId", Carid);
			mobject.put("CarAction", mCarAction);
		} catch (JSONException e) {

			e.printStackTrace();
		}
		//联网设置
		mQueue.add(new JsonObjectRequest
				(Request.Method.POST, mServerIp+"SetCarAction.do",mobject, listener,errorlistener));
		
		
	}
public void GetCarSpeed(int Carid,String mCarAction,Listener<JSONObject> listener,ErrorListener errorlistener) {
	JSONObject mobject=new JSONObject();
	try {
		mobject.put("CarId", Carid);
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	mQueue.add(new JsonObjectRequest(Request.Method.POST, mServerIp+"GetCarSpeed.do", mobject,listener,errorlistener));
}
public void GetAccountYE(int Carid,Listener<JSONObject> listener,ErrorListener errorlistener){
	JSONObject mObject=new JSONObject();
	try {
		mObject.put("CatId",Carid);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mQueue.add(new JsonObjectRequest(Request.Method.POST,mServerIp+"GetCarAccountBalance.do",mObject,listener,errorlistener));
}
public void SetCarAccountRequest(int Carid,int mMoney,Listener<JSONObject> listener,ErrorListener errorlistener){
	JSONObject mObject=new JSONObject();
	try {
		mObject.put("CatId",Carid);//编号
		mObject.put("Money",mMoney);//金额
		
		
	} catch (JSONException e) {

		e.printStackTrace();
	}
	mQueue.add(new JsonObjectRequest(Request.Method.POST,mServerIp+"SetCarAccountRecharge.do",mObject,listener,errorlistener));
}

public void GetRgbLightConfig(int Lightid,Listener<JSONObject>listener,ErrorListener errorlistener){
	JSONObject mObject=new JSONObject();
	try{
			mObject.put("TrafficLightId",Lightid);
	}catch(JSONException e) {

		e.printStackTrace();}
mQueue.add(new JsonObjectRequest(Request.Method.POST,mServerIp+"GetTrafficLightConfigAciton.do",mObject,listener,errorlistener));
}


public void GetAllSense(Listener<JSONObject>listener,ErrorListener errorlistener){
	mQueue.add(new JsonObjectRequest(Request.Method.POST,mServerIp+"GetAllSense.do",listener,errorlistener));
	

}



	
}



