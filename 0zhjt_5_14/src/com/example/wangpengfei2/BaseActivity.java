package com.example.wangpengfei2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȡ��������
		this.getWindow().setFlags
		(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);//����ȫ��
		
		
		
	}

}
