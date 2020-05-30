package com.example.wangpengfei2.adapter;

import java.util.ArrayList;

import com.example.wangpengfei2.R;
import com.example.wangpengfei2.bean.LeftMenuLvBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftMenuAdapter extends BaseAdapter {
	Context mcontext;
	ArrayList<LeftMenuLvBean> mlist;
	

	public LeftMenuAdapter(Context mcontext, ArrayList<LeftMenuLvBean> mlist) {
		//super();
		this.mcontext = mcontext;
		this.mlist = mlist;
	}

	@Override
	public int getCount() {

		return mlist.size();
	}

	@Override
	public Object getItem(int arg0) {

		return mlist.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {

		return arg0;
	}

	@Override
	public View getView(int postion, View mview, ViewGroup arg2) {
		LayoutInflater mInflater=
				(LayoutInflater)mcontext.
				getSystemService
				(Context.LAYOUT_INFLATER_SERVICE);
		
		ViewHolder mViewholder=null;
		
		if(mview==null)
		{
			mview=(View)
					mInflater.inflate(
					R.layout.leftmenu_lv_item_layout, 
					arg2, false);
			mViewholder=new ViewHolder();
			mViewholder.mItemimg=(ImageView)mview.findViewById(R.id.left_lv_item_img);
			mViewholder.mTtemTv=(TextView)mview.findViewById(R.id.left_lv_item_tv);
			//…Ë÷√±ÍÃ‚£∫
			mview.setTag(mViewholder);
			
		}else{
			mViewholder=(ViewHolder)mview.getTag();
		}
		
		LeftMenuLvBean mbean=mlist.get(postion);
		mViewholder.mItemimg.setImageResource(mbean.getmItemImg());
		mViewholder.mTtemTv.setText(mbean.getmItemTv());
		
		return mview;
	}
	class ViewHolder{
		ImageView mItemimg;
		TextView mTtemTv;
	}
}
