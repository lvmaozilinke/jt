package com.example.wangpengfei2.adapter;

import java.util.ArrayList;

import com.example.wangpengfei2.bean.ViewPagerBean;

import com.example.wangpengfei2.R;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {
	Context mContext;
	ArrayList<ViewPagerBean> mlist; 
	ImageView mImgv;
	//������Ա����
	@Override
	public int getCount() {
		//Ԫ�ؼ��������ɼ���ҳ�桢
		//�����м���
		return mlist.size();
	}

	public ViewPagerAdapter(Context mContext, ArrayList<ViewPagerBean> mlist) {
		
		this.mContext = mContext;
		this.mlist = mlist;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0.equals((View)arg1);
		//����򷵻�
		//��ǰ��ͼ�Ƿ�
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
	//	super.destroyItem(container, position, object);
		((ViewPager)container).removeView((View)object);
		//�Ƴ���ͼ
		//����
		
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LayoutInflater layInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//����ת����
		//����ÿһ��������ҳ
		
		View mview=(View)layInflater.inflate(R.layout.item_guide_layout, container, false);
		mImgv=(ImageView)mview.findViewById(R.id.pic_img);
		mImgv.setImageResource(mlist.get(position).getPicId());
		container.addView(mview);
		return mview;
	}

}
