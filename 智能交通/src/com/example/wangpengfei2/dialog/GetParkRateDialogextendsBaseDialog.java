package com.example.wangpengfei2.dialog;

import com.example.wangpengfei2.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("ValidFragment")
public class GetParkRateDialogextendsBaseDialog extends Base {
	
	Context mcontext;
	EditText mRateEt;
	EditText mMoneyEt;

	public GetParkRateDialogextendsBaseDialog(Context mcontext,
			Context mcontext2) {
		super(mcontext);
		mcontext = mcontext2;
	}

	@Override
	public void onActivityCreated(Bundle arg0) {

		super.onActivityCreated(arg0);
		InitView();
	}

	private void InitView() {
		mRateEt=(EditText)getView().findViewById(R.id.show_ratetype_tv);
		mMoneyEt=(EditText)getView().findViewById(R.id.show_rateJe_tv);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

//		return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.getparkrate_dialog_layout, container, false);
		
	}
	

}
