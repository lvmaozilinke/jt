package com.example.wangpengfei2.dialog;

import com.example.wangpengfei2.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
