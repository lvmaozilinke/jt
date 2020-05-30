package com.example.wangpengfei2.adapter;

import java.util.List;

import com.example.wangpengfei2.R;
import com.example.wangpengfei2.bean.BusItemBean;
import com.example.wangpengfei2.bean.StationItemBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BusStationAdapter extends BaseExpandableListAdapter {
	private List<StationItemBean>mList;
	private Context mContext;
	
	
	
	public BusStationAdapter(List<StationItemBean> mList, Context mContext) {
//		super();
		this.mList = mList;
		this.mContext = mContext;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {

		return mList.get(groupPosition).getChildList().get(childPosition);
		
	}

	@Override
	public long getChildId(int arg0, int arg1) {

		return arg1;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean arg2, View mchildview,
			ViewGroup parent) {
		mchildview=LayoutInflater.from(mContext).inflate(R.layout.bus_item_layout,parent, false);
		ImageView busImg=(ImageView) mchildview.findViewById(R.id.icon_bus);
		TextView busNo=(TextView) mchildview.findViewById(R.id.bus_no_tv);
		TextView tvDistance=(TextView) mchildview.findViewById(R.id.bus_dis_tv);
		BusItemBean bean=mList.get(groupPosition).getChildList().get(childPosition);
		busImg.setBackgroundResource(bean.getBusIcon());
		busNo.setText((childPosition+1)+"号公交车");
		tvDistance.setText("距离本站"+bean.getDistance()+"米");
		
		return null;
	}

	@Override
	public int getChildrenCount(int arg0) {

		return mList.get(arg0).getChildList().size();
		
	}

	@Override
	public Object getGroup(int arg0) {

		return mList.get(arg0);
		
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return mList.size();
		
	}

	@Override
	public long getGroupId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean arg1, View mgroupview, ViewGroup parent) {
		mgroupview=LayoutInflater.from(mContext).inflate(R.layout.station_item_layout, parent, false);
		
		
		TextView StationTitle=(TextView) mgroupview.findViewById(R.id.station_title_tv);
		StationTitle.setText(mList.get(groupPosition).getStationtitle());
		
		return mgroupview;
	}

	@Override
	public boolean hasStableIds() {

		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {

		return false;
	}

}
