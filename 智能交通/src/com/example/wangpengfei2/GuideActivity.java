package com.example.wangpengfei2;

import java.util.ArrayList;

import com.example.wangpengfei2.adapter.ViewPagerAdapter;
import com.example.wangpengfei2.bean.ViewPagerBean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class GuideActivity extends BaseActivity implements OnPageChangeListener {
//实现接口，三个方式
	ViewPager mViewPage;
	Button mWelcomeBtn;
	
	//创建动态数组：
	ArrayList<ViewPagerBean> mList;
	
	//定义对象：
	ViewPagerBean mPagerBean;
	
	
	//
	ViewPagerAdapter mPagerAdapter;
	
	
	//定义线性布局对象：
	LinearLayout mLinearLayout;
	
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.guide_activity_layout);
		InitView();//绑定控件方法
		InitData();//初始化数据方法
		SetAdapter();//设置适配器
		
		SetIndicator(0);//小圆点是第一个页面：
		
		SetListener();
		
	}

	private void SetIndicator(int i) {
		mLinearLayout.removeAllViews();//移除所有的控件；
		if(mList.size()==0)
		{
			return;
		}
		for(int j=0;j<mList.size();j++)
		{
			ImageView mImg=new ImageView(this);

			if (i==j) {
				//设置橙色图片
				mImg.setImageResource(R.drawable.page_indicator_focused);
				
			}
			else
			{
//				设置灰色图片
				mImg.setImageResource(R.drawable.page_indicator_unfocused);
				
			}
			
			LayoutParams mParams=new LayoutParams(24,24);
			mParams.leftMargin=5;
			mParams.rightMargin=5;
			mLinearLayout.addView(mImg, mParams);
//			
		
				
		}
		
	}

	private void SetListener() {
//		Viewpager控件设置监听器
		mViewPage.setOnPageChangeListener(this);
		mWelcomeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				实现页面切换
			try {
				Intent mIntent=new Intent(GuideActivity.this,MainActivity.class);
				GuideActivity.this.startActivity(mIntent);
				GuideActivity.this.finish();//关闭欢迎界面	
			} catch (Exception e) {
				Log.w("___________a", "asd"+e);
			}
					
			
				
			}
		});
		
		
	}

	private void SetAdapter() {//创建设置适配器显示页面为第一个页面
		
		mPagerAdapter=new ViewPagerAdapter(this,mList);
		mViewPage.setAdapter(mPagerAdapter);
		mViewPage.setCurrentItem(0);
		
		
	}

	private void InitData() {//初始化数据
		mList=new ArrayList<ViewPagerBean>();//初始化数组
		//创建动态数组并在数组里面保存了三个ViewPager对象
		//图片1
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic1);
		mList.add(mPagerBean);
		
		//图片2
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic2);
		mList.add(mPagerBean);
		
		//图片3
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic3);
		mList.add(mPagerBean);
		
		
		
	}

	private void InitView() {//绑定控件
		mLinearLayout=(LinearLayout)findViewById(R.id.indicator_view);
		
		mViewPage=(ViewPager)findViewById(R.id.view_pager);
		mWelcomeBtn=(Button)findViewById(R.id.enter_btn);
		mWelcomeBtn.setVisibility(View.GONE);
	
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int Position) {
//		设置什么时候可见，什么时候不可见
		
		SetIndicator(Position);
		
		
		
		if(Position<mList.size()-1)
		{
			mWelcomeBtn.setVisibility(View.GONE);//不可见
			
		}
		else
		{
			mWelcomeBtn.setVisibility(View.VISIBLE);//可见
		}

	}

}
