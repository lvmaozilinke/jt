package com.example.wangpengfei2.Fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.adapter.BusStationAdapter;
import com.example.wangpengfei2.bean.BusItemBean;
import com.example.wangpengfei2.bean.StationItemBean;
import com.example.wangpengfei2.network.HttpAPI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class BusStationFragment extends Fragment {
	ExpandableListView mExpandableLV;
	BusStationAdapter mAdapter=null;
	List<StationItemBean> elvList=new ArrayList<StationItemBean>();
	List<BusItemBean>childList=new ArrayList<BusItemBean>();
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		initView();
		InitData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate
				(R.layout.fragment_busstation_layout, container, false);
	
		}

	private void initView() {
		mExpandableLV=(ExpandableListView)getView().findViewById(R.id.distance_elv);
	}

	private void InitData() {
		getData(1);
		
	}

	private void getData(final int stationId) {
		if(stationId==1){
			elvList.clear();
			
			
		}
		childList.clear();
		HttpAPI.getInstance(getActivity()).getStationInfo(stationId, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject jsonObject) {
				Toast.makeText(getActivity(), "获取数据成功。。。",Toast.LENGTH_LONG).show();
                JSONArray array;
                try {
                    array = new JSONArray(jsonObject.toString());
                    for (int j = 0; j <array.length();j++) {
                        JSONObject json =array.optJSONObject(j);
                        int distance =json.optInt("Distance");
                        int busid=json.optInt("BusId");
                    
                    BusItemBean bean = new BusItemBean(busid+"",distance+"",R.drawable.bus);
                    childList.add(bean);

                
            }
                elvList.add(new StationItemBean(stationId+"号公交站台",childList));
                if (elvList.size() < 2){
                	getData(stationId+1);
                }else{
                    if (mAdapter== null){
                        mAdapter= new BusStationAdapter(elvList,getActivity());
                        mExpandableLV.setAdapter(mAdapter);
                        }else{
                        	mAdapter.notifyDataSetChanged();
                        }}
                
                }catch(JSONException e){
                	e.printStackTrace();
                	
                }
		}}
		, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				
			}
		});
		}
		}

	


