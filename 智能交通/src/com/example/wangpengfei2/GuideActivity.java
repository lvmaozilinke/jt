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
//ʵ�ֽӿڣ�������ʽ
	ViewPager mViewPage;
	Button mWelcomeBtn;
	
	//������̬���飺
	ArrayList<ViewPagerBean> mList;
	
	//�������
	ViewPagerBean mPagerBean;
	
	
	//
	ViewPagerAdapter mPagerAdapter;
	
	
	//�������Բ��ֶ���
	LinearLayout mLinearLayout;
	
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.guide_activity_layout);
		InitView();//�󶨿ؼ�����
		InitData();//��ʼ�����ݷ���
		SetAdapter();//����������
		
		SetIndicator(0);//СԲ���ǵ�һ��ҳ�棺
		
		SetListener();
		
	}

	private void SetIndicator(int i) {
		mLinearLayout.removeAllViews();//�Ƴ����еĿؼ���
		if(mList.size()==0)
		{
			return;
		}
		for(int j=0;j<mList.size();j++)
		{
			ImageView mImg=new ImageView(this);

			if (i==j) {
				//���ó�ɫͼƬ
				mImg.setImageResource(R.drawable.page_indicator_focused);
				
			}
			else
			{
//				���û�ɫͼƬ
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
//		Viewpager�ؼ����ü�����
		mViewPage.setOnPageChangeListener(this);
		mWelcomeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				ʵ��ҳ���л�
			try {
				Intent mIntent=new Intent(GuideActivity.this,MainActivity.class);
				GuideActivity.this.startActivity(mIntent);
				GuideActivity.this.finish();//�رջ�ӭ����	
			} catch (Exception e) {
				Log.w("___________a", "asd"+e);
			}
					
			
				
			}
		});
		
		
	}

	private void SetAdapter() {//����������������ʾҳ��Ϊ��һ��ҳ��
		
		mPagerAdapter=new ViewPagerAdapter(this,mList);
		mViewPage.setAdapter(mPagerAdapter);
		mViewPage.setCurrentItem(0);
		
		
	}

	private void InitData() {//��ʼ������
		mList=new ArrayList<ViewPagerBean>();//��ʼ������
		//������̬���鲢���������汣��������ViewPager����
		//ͼƬ1
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic1);
		mList.add(mPagerBean);
		
		//ͼƬ2
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic2);
		mList.add(mPagerBean);
		
		//ͼƬ3
		mPagerBean=new ViewPagerBean();
		mPagerBean.setPicId(R.drawable.traffic3);
		mList.add(mPagerBean);
		
		
		
	}

	private void InitView() {//�󶨿ؼ�
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
//		����ʲôʱ��ɼ���ʲôʱ�򲻿ɼ�
		
		SetIndicator(Position);
		
		
		
		if(Position<mList.size()-1)
		{
			mWelcomeBtn.setVisibility(View.GONE);//���ɼ�
			
		}
		else
		{
			mWelcomeBtn.setVisibility(View.VISIBLE);//�ɼ�
		}

	}

}
