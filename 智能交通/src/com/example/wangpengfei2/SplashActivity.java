package com.example.wangpengfei2;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends BaseActivity {
	Handler mhanHandler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {//发消息赋值
			case 1:
				Intent mintent=new Intent(SplashActivity.this,GuideActivity.class);
				SplashActivity.this.startActivity(mintent);
				SplashActivity.this.finish();
				
				break;
			default:
				break;
			}
		}};
		Timer mtimer=new Timer();//定时器
		TimerTask mtask=new TimerTask() {
			
			@Override
			public void run() {
				//定时器对象
				Message msg=new Message();
				msg.what=1;
				mhanHandler.sendMessage(msg);
			}
		};
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.splash_activity_layout);
		mtimer.schedule(mtask, 1000);//设置定时器
		
	}

	@Override
	protected void onStop() {
		super.onStop();
		mtimer.cancel();//销毁
		
	}
	
	

}