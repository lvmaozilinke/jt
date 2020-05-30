package com.example.wangpengfei2;

import java.util.ArrayList;

import com.example.wangpengfei2.Fragment.BusStationFragment;
import com.example.wangpengfei2.Fragment.CarFragment;
import com.example.wangpengfei2.Fragment.EnvFragment;
import com.example.wangpengfei2.Fragment.ParketFragment;
import com.example.wangpengfei2.Fragment.RGlightFragment;
import com.example.wangpengfei2.R;
import com.example.wangpengfei2.Fragment.RoadFragment;
import com.example.wangpengfei2.activity.AboutActivity;
import com.example.wangpengfei2.activity.HelpActivity;
import com.example.wangpengfei2.activity.PersonCentrActivity;
import com.example.wangpengfei2.activity.PersonCollectionActivity;
import com.example.wangpengfei2.activity.PersonFileActivity;
import com.example.wangpengfei2.activity.SetIpActivity;

import com.example.wangpengfei2.adapter.LeftMenuAdapter;
import com.example.wangpengfei2.bean.LeftMenuLvBean;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.slidingmenu.lib.SlidingMenu.OnOpenListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends BaseActivity implements OnItemClickListener {
//	�����ַ������飬�����Ӧ6��ѡ���ǩ���ı��ַ���
	private String mTitles[];
	//ͼƬ����
	private int mImages[];
	//fragment������
	private Class<?> mFragments[];
	//��������ı���ͼƬ�ؼ�
	private FragmentTabHost mTabHost;
	private TextView mTitleTv;
	private ImageView mTitleImg;
//	����SlidingMenu�����
	private SlidingMenu mLeftmenu;
	
	//����Arraylist
	private ArrayList<LeftMenuLvBean> mlist;
	private ListView mListView;
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {

		super.onCreate(arg0);
		this.setContentView(R.layout.main_layout);
	
		InitData();//��ʼ������
		InitView();//��������ؼ�
		
//		���SetupSlidingMenu( )��InitSlidingMenu( )��������
		SetupSlidingMenu();//���ò໬�˵�
		InitSlidingMenu();//��ʼ���໬�˵���ͼ
		
		
		SetTabView();//ѡ���ǩ��ͼ
		SetListener();//������
		
		
	}
	//��ʼ���໬�˵���ͼ
	private void InitSlidingMenu() {
		View mview=mLeftmenu.getMenu();
		ImageView mLogoImg=(ImageView)mview.findViewById(R.id.logo_img);//�����ؼ�
		TextView mLogoTv=(TextView)mview.findViewById(R.id.logo_tv);
		
		mLogoImg.setImageResource(R.drawable.ic_launcher);//����ͼƬ
		mLogoTv.setText(this.getString(R.string.app_name));//��������
		
		//���÷�����
		SetListView(mview);
		
	}
	private void SetListView(View mview) {
		mListView=(ListView)mview.findViewById(R.id.leftmenu_listview);
		
		String[] mLeftMenuNames=this.getResources().getStringArray(R.array.leftmenu_str);
		int[] mLeftMenuImgIds={R.drawable.leftmenu1,
								R.drawable.leftmenu2,
								R.drawable.leftmenu3,
								R.drawable.leftmenu4,
								R.drawable.leftmenu5,
								R.drawable.leftmenu6};
		mlist=new ArrayList<LeftMenuLvBean>();
		LeftMenuLvBean mBean;
		for(int i=0;i<mLeftMenuNames.length;i++){
			mBean=new LeftMenuLvBean();
			mBean.setmItemImg(mLeftMenuImgIds[i]);
			mBean.setmItemTv(mLeftMenuNames[i]);
			mlist.add(mBean);
			
			
		}
		LeftMenuAdapter mAdapter=
				new LeftMenuAdapter(this, mlist);
		mListView.setAdapter(mAdapter);
		
		mListView.setOnItemClickListener(this);
		
		
	}
	//���ò໬�˵�
	private void SetupSlidingMenu() {
		mLeftmenu=new SlidingMenu(this);
		mLeftmenu.setMode(SlidingMenu.LEFT_RIGHT);//���ò໬�˵������ʵ��[���]
		mLeftmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//���û����ķ�ΧΪȫ��
		mLeftmenu.setShadowWidthRes(R.dimen.shadow_width);//���ò˵����
		mLeftmenu.setShadowDrawable(R.drawable.slidingmenu_bg);//���ñ���ͼƬ
		mLeftmenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//��ҳ����
		mLeftmenu.setBehindWidth(500);//�˵����
		mLeftmenu.setFadeEnabled(true);//��������ʹ�ù���
		mLeftmenu.setFadeDegree(0.4f);//���ù���
		
		mLeftmenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//���ò໬�˵�����
		mLeftmenu.setMenu(R.layout.leftmenu_layout);//����Ϊ����
		mLeftmenu.setSecondaryMenu(R.layout.leftmenu_layout);
		
		
		
		
	}

	private void SetListener() {
		//������
		TabHost.OnTabChangeListener mListener=new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String arg0) {

				for(int i=0;i<mTitles.length;i++)
				{
					if(arg0.equals(mTitles[i]))
					{
						mTitleTv.setText(mTitles[i]);
					}
				
				}
			}
		};
		mTabHost.setOnTabChangedListener(mListener);
		
		//���ü�������
		mLeftmenu.setOnOpenListener(new OnOpenListener() {
			@Override
//			�ر�
			public void onOpen() {
				mTitleImg.setImageResource(R.drawable.close);
			}
		});
		
		mLeftmenu.setOnCloseListener(new OnCloseListener() {
		//��	
			@Override
			public void onClose() {
				mTitleImg.setImageResource(R.drawable.open);
			}
		});
		mTitleImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//��/�رղ໬�˵�
				mLeftmenu.toggle();
				
			}
		});
		
		
		
	}

	private void SetTabView() {
		//ѡ���ǩ
		for(int i=0;i<mTitles.length;i++){
			TabHost.TabSpec mTabSpec=mTabHost.newTabSpec(mTitles[i]).setIndicator(gettabview(i));
			mTabHost.addTab(mTabSpec,mFragments[i],null);
		}
		
	}
	private View gettabview(int i) {
		View mview=LayoutInflater.from(this).inflate(R.layout.tab_item_layout, mTabHost.getTabWidget(), false);
		ImageView mImg=(ImageView)mview.findViewById(R.id.tab_item_img);
		mImg.setImageResource(mImages[i]);
		TextView mTv=(TextView)mview.findViewById(R.id.tab_item_tv);
		mTv.setText(mTitles[i]);
		return mview;
	}





	private void InitData() {
		//��ʼ������
	mTitles=this.getResources().getStringArray(R.array.title_array);
	mImages=new int[]
			{
			R.drawable.emvirement,
			R.drawable.car,
			R.drawable.park,
			R.drawable.rglight,
			R.drawable.bussstatio,
			R.drawable.road
			};
	mFragments=new Class<?>[]
			{
			EnvFragment.class,
			CarFragment.class,
			ParketFragment.class,
			RGlightFragment.class,
			BusStationFragment.class,
			RoadFragment.class,
			};
	
	}

	private void InitView() {
		//��������ؼ�
		mTabHost=(FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);
		
		mTitleTv=(TextView)findViewById(R.id.title_tv);
		mTitleTv.setText(mTitles[0]);
		
		mTitleImg=(ImageView)findViewById(R.id.title_img);
		
	}



	//�����зֱ�ʵ�ֲ໬�˵��б���ѡ�к��л��Ľ���

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		Intent  mintent=new Intent();
		switch (position) {
		case 0://����IP
			mintent.setClass(MainActivity.this, SetIpActivity.class);
			MainActivity.this.startActivity(mintent);
			overridePendingTransition(R.anim.enter_animation, R.anim.exit_animation);
			break;
		case 1://��������
			mintent.setClass(MainActivity.this, PersonCentrActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 2://�ҵ��ղ�
			mintent.setClass(MainActivity.this, PersonCollectionActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 3://�ҵ��ļ�
			mintent.setClass(MainActivity.this, PersonFileActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 4://����
			mintent.setClass(MainActivity.this, HelpActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 5://����
			mintent.setClass(MainActivity.this, AboutActivity.class);
			MainActivity.this.startActivity(mintent);
				break;

		}
		
	}

}
