package com.example.wangpengfei2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	DatabaseHelper(Context context){
		super(context,"database.db",null,1);//�������ݿ�
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//ͨ��SQL��䴴����
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE recharge_record (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"carNumber TEXT,money INTEGET,balance INTEGER,rechargeTime INTEGER)");	
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
}
