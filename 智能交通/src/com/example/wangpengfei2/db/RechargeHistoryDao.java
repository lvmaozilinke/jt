package com.example.wangpengfei2.db;

import java.util.ArrayList;
import java.util.List;

import com.example.wangpengfei2.bean.RechargeInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RechargeHistoryDao {
	private static final String TABLE_NAME = "recharge_record";
	private static RechargeHistoryDao sInstance;
	private DatabaseHelper mHelper;
	
	
	private RechargeHistoryDao(Context context){
		mHelper = new DatabaseHelper(context);
	}
	
	public static RechargeHistoryDao getInstance(Context context){
		if(sInstance == null){
			synchronized (RechargeHistoryDao.class) {//处理同步问题
				if (sInstance == null){
					sInstance = new RechargeHistoryDao(context);
				}
				
			}
		}
		return sInstance;
		
	}
	public void add(String carNumber, int money,int balance,long rechargeTime){
		ContentValues values = new ContentValues();//键对值
		values.put("carNumber", carNumber);
		values.put("money", money);
		values.put("balance", balance);
		values.put("rechargeTime", rechargeTime);
		
		SQLiteDatabase db = mHelper.getWritableDatabase();
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	public List<RechargeInfo> queryAll(){
		SQLiteDatabase db = mHelper.getWritableDatabase();
		Cursor cursor = db.query(TABLE_NAME, new String[]{"carNumber","money","balance","rechargeTime"}, null, null, null, null, "rechargeTime ASC");
		List<RechargeInfo>list = new ArrayList<RechargeInfo>();
		
		while (cursor.moveToNext()){
			RechargeInfo info = new RechargeInfo();
			info.setCarNumber(cursor.getString(cursor.getColumnIndex("carNumber")));
			info.setMoney(cursor.getInt(cursor.getColumnIndex("money")));
			//info.setBalance(cursor.getInt(cursor.getColumnIndex("balance")));
			//info.setRechargeUser(cursor.getString(cursor.getColumnIndex("rechargeUser")));
			info.setRechargeTime(cursor.getLong(cursor.getColumnIndex("rechargeTime")));
			
			list.add(info);
		}
		db.close();
		cursor.close();
		
		return list;
	}

}
