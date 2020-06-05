package com.example.wangpengfei2.Fragment;

import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.network.HttpAPI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ParketFragment extends Fragment {
	Spinner mRatetypeSpinner;
	EditText mMeneyEt;
	Button mSetRateBtn;
	String mRatetype = "Count";// 保存费率类型
	int mRateMoney;// 保存费率金额

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		InitView();
		SetLinstener();

	}

	private void SetLinstener() {
		mRatetypeSpinner
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						if (position == 0) {
							mRatetype = "Count";
						} else if (position == 1) {
							mRatetype = "Hour";
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});
		mSetRateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mMeneyEt.getText().toString().trim().isEmpty()) {
					Toast.makeText(getActivity(), "请输入金额", Toast.LENGTH_LONG)
							.show();
					return;

				}
				int mMoney = Integer.parseInt(mMeneyEt.getText().toString()
						.trim());
				if (mMoney == 0) {
					Toast.makeText(getActivity(), "请输入金额", Toast.LENGTH_LONG)
							.show();
					return;
				}
				HttpAPI.getInstance(getActivity()).setParkRate(mRatetype,
						mMoney, new Listener<JSONObject>() {

							@Override
							public void onResponse(JSONObject arg0) {
								try {
									if (arg0.getString("result")
											.equalsIgnoreCase("ok")) {
										Toast.makeText(getActivity(),
												"费率设置成功！", Toast.LENGTH_LONG)
												.show();

									} else {
										Toast.makeText(getActivity(),
												"费率设置失败！", Toast.LENGTH_LONG)
												.show();
									}
								} catch (Exception e) {
									e.printStackTrace();

								}

							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {

							}
						});

			}
		});

	}

	private void InitView() {
		mRatetypeSpinner = (Spinner) getView().findViewById(
				R.id.Select_RateType_spinner);
		mMeneyEt = (EditText) getView().findViewById(R.id.Rate_Je_Et);
		mSetRateBtn = (Button) getView().findViewById(R.id.Set_Rate_Btn);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_parket_layout, container,
				false);
	}

}
