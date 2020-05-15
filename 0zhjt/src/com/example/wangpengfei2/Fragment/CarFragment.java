package com.example.wangpengfei2.Fragment;

import com.example.wangpengfei2.CarAccountActivity;
import com.example.wangpengfei2.CarActionActivity;
import com.example.wangpengfei2.CarSpeedActivity;
import com.example.wangpengfei2.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class CarFragment extends Fragment implements OnClickListener {
	Button mCar_Speed_Btn,mCar_Account_Btn,mCar_Action_Btn;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		View mview=getView();
		mCar_Speed_Btn=(Button) mview.findViewById(R.id.car_speed_btn);
		mCar_Account_Btn=(Button) mview.findViewById(R.id.car_account_btn);
		mCar_Action_Btn=(Button) mview.findViewById(R.id.car_action_btn);
		
		mCar_Speed_Btn.setOnClickListener(this);

		mCar_Account_Btn.setOnClickListener(this);
		mCar_Action_Btn.setOnClickListener(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate
		(R.layout.fragment_car_layout, container, false);
		}

	@Override
	public void onClick(View a) {
			switch (a.getId()) {
			
			case R.id.car_speed_btn:
				Intent mIntent=new Intent();
				mIntent.setClass(getActivity(), CarSpeedActivity.class);
				this.getActivity().startActivity(mIntent);
				break;
			case R.id.car_account_btn:
				Intent mIntent2=new Intent();
				mIntent2.setClass(getActivity(), CarAccountActivity.class);
				this.getActivity().startActivity(mIntent2);
				break;
			case R.id.car_action_btn:
				Intent mIntent3=new Intent();
				mIntent3.setClass(getActivity(), CarActionActivity.class);
				this.getActivity().startActivity(mIntent3);
				break;
			default:
				break;
			}

}
	

		
	}
	


