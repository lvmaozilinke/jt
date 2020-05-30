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
//	定义字符串数组，保存对应6个选项标签的文本字符串
	private String mTitles[];
	//图片数组
	private int mImages[];
	//fragment的数组
	private Class<?> mFragments[];
	//定义标题文本和图片控件
	private FragmentTabHost mTabHost;
	private TextView mTitleTv;
	private ImageView mTitleImg;
//	定义SlidingMenu类对象。
	private SlidingMenu mLeftmenu;
	
	//定义Arraylist
	private ArrayList<LeftMenuLvBean> mlist;
	private ListView mListView;
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {

		super.onCreate(arg0);
		this.setContentView(R.layout.main_layout);
	
		InitData();//初始化数据
		InitView();//关联界面控件
		
//		添加SetupSlidingMenu( )和InitSlidingMenu( )两个方法
		SetupSlidingMenu();//设置侧滑菜单
		InitSlidingMenu();//初始化侧滑菜单试图
		
		
		SetTabView();//选项标签视图
		SetListener();//监听器
		
		
	}
	//初始化侧滑菜单试图
	private void InitSlidingMenu() {
		View mview=mLeftmenu.getMenu();
		ImageView mLogoImg=(ImageView)mview.findViewById(R.id.logo_img);//关联控件
		TextView mLogoTv=(TextView)mview.findViewById(R.id.logo_tv);
		
		mLogoImg.setImageResource(R.drawable.ic_launcher);//设置图片
		mLogoTv.setText(this.getString(R.string.app_name));//设置文字
		
		//调用方法：
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
	//设置侧滑菜单
	private void SetupSlidingMenu() {
		mLeftmenu=new SlidingMenu(this);
		mLeftmenu.setMode(SlidingMenu.LEFT_RIGHT);//设置侧滑菜单在左侧实现[左侧]
		mLeftmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置滑动的范围为全屏
		mLeftmenu.setShadowWidthRes(R.dimen.shadow_width);//设置菜单宽度
		mLeftmenu.setShadowDrawable(R.drawable.slidingmenu_bg);//设置背景图片
		mLeftmenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//主页面宽度
		mLeftmenu.setBehindWidth(500);//菜单宽度
		mLeftmenu.setFadeEnabled(true);//设置允许使用过度
		mLeftmenu.setFadeDegree(0.4f);//设置过度
		
		mLeftmenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//设置侧滑菜单内容
		mLeftmenu.setMenu(R.layout.leftmenu_layout);//内容为背景
		mLeftmenu.setSecondaryMenu(R.layout.leftmenu_layout);
		
		
		
		
	}

	private void SetListener() {
		//监听器
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
		
		//设置监听器：
		mLeftmenu.setOnOpenListener(new OnOpenListener() {
			@Override
//			关闭
			public void onOpen() {
				mTitleImg.setImageResource(R.drawable.close);
			}
		});
		
		mLeftmenu.setOnCloseListener(new OnCloseListener() {
		//打开	
			@Override
			public void onClose() {
				mTitleImg.setImageResource(R.drawable.open);
			}
		});
		mTitleImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//打开/关闭侧滑菜单
				mLeftmenu.toggle();
				
			}
		});
		
		
		
	}

	private void SetTabView() {
		//选项标签
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
		//初始化数据
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
		//关联界面控件
		mTabHost=(FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);
		
		mTitleTv=(TextView)findViewById(R.id.title_tv);
		mTitleTv.setText(mTitles[0]);
		
		mTitleImg=(ImageView)findViewById(R.id.title_img);
		
	}



	//方法中分别实现侧滑菜单列表项选中后，切换的界面

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		Intent  mintent=new Intent();
		switch (position) {
		case 0://设置IP
			mintent.setClass(MainActivity.this, SetIpActivity.class);
			MainActivity.this.startActivity(mintent);
			overridePendingTransition(R.anim.enter_animation, R.anim.exit_animation);
			break;
		case 1://个人中心
			mintent.setClass(MainActivity.this, PersonCentrActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 2://我的收藏
			mintent.setClass(MainActivity.this, PersonCollectionActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 3://我的文件
			mintent.setClass(MainActivity.this, PersonFileActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 4://帮助
			mintent.setClass(MainActivity.this, HelpActivity.class);
			MainActivity.this.startActivity(mintent);
				break;
		case 5://关于
			mintent.setClass(MainActivity.this, AboutActivity.class);
			MainActivity.this.startActivity(mintent);
				break;

		}
		
	}

}
