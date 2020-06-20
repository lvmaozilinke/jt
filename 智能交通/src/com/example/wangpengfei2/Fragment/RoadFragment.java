package com.example.wangpengfei2.Fragment;

import org.json.JSONException;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RoadFragment extends Fragment {
	Spinner mRoadIdSpinner;
	Button mSearchBtn;
	TextView mShowTv;
	int mRoadId = 1;
	String[] mRoadStatusArrays;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		InitView();
		SetListener();

	}

	private void SetListener() {
		mRoadIdSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mRoadId = arg2 + 1;

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		mSearchBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				HttpAPI.getInstance(getActivity()).GetRoadStatus(mRoadId,
						new Listener<JSONObject>() {

							@Override
							public void onResponse(JSONObject obj) {
								int mTempstatus = 1;
								try {
									if (obj.has("result")&& obj.getString("result").equals("failed")) {
										Toast.makeText(getActivity(), "≤È—Ø ß∞‹£°",Toast.LENGTH_LONG).show();
										return;
									}
									mTempstatus = obj.getInt("Status");
									if (mTempstatus == 1) {
										mShowTv.setBackgroundResource(R.drawable.roadstatus1);
									}
									if (mTempstatus == 2) {
										mShowTv.setBackgroundResource(R.drawable.roadstatus2);
									}
									if (mTempstatus == 3) {
										mShowTv.setBackgroundResource(R.drawable.roadstatus3);
									}
									if (mTempstatus == 4) {
										mShowTv.setBackgroundResource(R.drawable.roadstatus4);
									}
									if (mTempstatus == 5) {
										mShowTv.setBackgroundResource(R.drawable.roadstatus5);
									}
									mShowTv.setText(mRoadStatusArrays[mTempstatus - 1]);
								} catch (JSONException e) {
									e.printStackTrace();

								}

							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError arg0) {
								// TODO Auto-generated method stub

							}
						});

			}
		});

	}

	private void InitView() {
		mRoadIdSpinner = (Spinner) getView()
				.findViewById(R.id.Road_Ids_Spinner);
		mSearchBtn = (Button) getView().findViewById(R.id.search_btn_Str);
		mShowTv = (TextView) getView().findViewById(R.id.Display_RoadInfo_Tv);
		mRoadStatusArrays = this.getActivity().getResources()
				.getStringArray(R.array.RoadStatus_array);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater
				.inflate(R.layout.fragment_road_layout, container, false);
	}

}
