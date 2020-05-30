package com.example.wangpengfei2.dialog;


import com.example.wangpengfei2.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class LifeIndicatorDialog extends Base {
	
//	LifeIndicatorDialog Context mcontext;
	int light =0;
	int temperature= 0;
	int co2 = 0;
	int pm = 0;
	int humidity=0;
	
	private TextView tvLightLife;//紫外线光照等级
	private TextView tvLightTip;//提示
	private TextView tvTempLifeNumber;//温度等级
	private TextView tvTempTip;//温度提示
	private TextView tvClothes;//穿衣等级
	private TextView tvClothesTip;//提示
	private TextView tvSportLifeNumber;//运动等级
	private TextView tvSportTip;//提示
	private TextView tvPmLifeNumber;//PM2.5空气等级
	private TextView tvPmTip;//提示

	public LifeIndicatorDialog(Context mcontext,int light,int temperatur,
			int co2,int pm,int humidity, int temperature) {
		super(mcontext);
		this.mcontext=mcontext;
		this.light=light;
		this.temperature=temperature;
		this.co2=co2;
		this.pm=pm;
		this.humidity=humidity;
		
	}

	@Override
	public void onActivityCreated(Bundle arg0) {
		super.onActivityCreated(arg0);
		initView();
		
		upDataLight(light);
		upDataTemerature(temperature);
		upDataCO2(co2);
		upDataPM2(pm);
		
	}

	private void upDataPM2(int pm) {
		String airLevle="";
		String airTip="";
		if(pm>0&&pm<30){
			airLevle=mcontext.getString(R.string.air_levell,pm);
			airTip=mcontext.getString(R.string.air_tip1);
			
		}else if(pm>=30&&pm<=100){
			airLevle=mcontext.getString(R.string.air_level2,pm);
			airTip=mcontext.getString(R.string.air_tip2);
			
		}else if(pm>=100){
			airLevle=mcontext.getString(R.string.air_level3,pm);
			airTip=mcontext.getString(R.string.air_tip3);
		}
		
	}

	private void upDataCO2(int co2) {
		String sportLevel="";
		String sportTip="";
		switch (co2/3000) {
		case 0:
			sportLevel=mcontext.getString(R.string.sport_levell,co2);
			sportTip=mcontext.getString(R.string.sport_tip1);
			break;
		case 1:
		case 2:
			sportLevel=mcontext.getString(R.string.sport_level2,co2);
			sportTip=mcontext.getString(R.string.sport_tip2);
			break;
		default:
			sportLevel=mcontext.getString(R.string.sport_leve13,co2);
			sportTip=mcontext.getString(R.string.sport_tip3);
			break;
			
		}
		tvSportLifeNumber.setText(sportLevel);
		tvSportTip.setText(sportTip);
		
		
		

		
	}

	private void upDataTemerature(int temperature) {
		String tempLevel="";
		String tempTip="";
		String clothesLevel="";
		String clothesTip="";
		
		if(temperature<8){
			tempLevel=mcontext.getString(R.string.temp_levelI,temperature);
			tempTip=mcontext.getString(R.string.temp_tip1);
			
		}else if(temperature>=8){
			tempLevel=mcontext.getString(R.string.temp_leve12,temperature);
			tempTip=mcontext.getString(R.string.temp_tip2);
		}
		if(temperature<12){
			clothesLevel=mcontext.getString(R.string.clothes_levell);
			clothesTip=mcontext.getString(R.string.clothes_tip1,temperature);
			
			
		}else if(temperature>=12&&temperature<=21){
			clothesLevel=mcontext.getString(R.string.clothes_level2);
			clothesTip=mcontext.getString(R.string.clothes_tip2);
		}else if(temperature>=21){
			clothesLevel=mcontext.getString(R.string.clothes_level3);
			clothesTip=mcontext.getString(R.string.clothes_tip3);
		
	}
		tvTempLifeNumber.setText(temperature);
		tvTempTip.setText(tempTip);
		
	}
	private void upDataLight(int light) {
		String lightResult="";
		String lightLevel="";
		switch (light/1000) {
		case 0:
		case 1:
			lightResult=mcontext.getString(R.string.sunlight_tipl);
			lightLevel=mcontext.getString(R.string.sunlight_level1,light);
			break;
		case 2:
		case 3:
			lightResult=mcontext.getString(R.string.sunlight_tip2);
			lightLevel=mcontext.getString(R.string.sunlight_leve12,light);
			break;
			
		
		default:
			lightResult=mcontext.getString(R.string.sunlight_tip3);
			lightLevel=mcontext.getString(R.string.sunlight_level3,light);
			break;
		}
		tvLightLife.setText(lightLevel);
		tvLightTip.setText(lightResult);
		

		
	}

	private void initView() {
		tvLightLife=(TextView) getView().findViewById(R.id.light_life_tv);
		tvLightTip=(TextView) getView().findViewById(R.id.light_tip_tv);
		
		tvTempLifeNumber=(TextView) getView().findViewById(R.id.temp_life_number_tv);
		tvTempTip=(TextView) getView().findViewById(R.id.temp_tip_number_tv);
		
		tvClothes=(TextView) getView().findViewById(R.id.clothes_life_number_tv);
		tvClothesTip=(TextView) getView().findViewById(R.id.clothes_tip_number_tv);
		

		tvSportLifeNumber=(TextView) getView().findViewById(R.id.sports_life_number_tv);
		tvSportTip=(TextView) getView().findViewById(R.id.sport_tip_nnumber_tv);
		
		tvPmLifeNumber=(TextView) getView().findViewById(R.id.pm_life_number_tv);
		tvPmTip=(TextView) getView().findViewById(R.id.pm_tip_number_tv);
		
	


		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.life_indicater__layout, container, false);
	}


}
