package com.septian.ezra.docareuas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by EzraSept on 09/07/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "docare.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sqlProfil = "create table profil(nama varchar primary key, alamat text null, hp char null, tgl date null);";
        Log.d("Data", "onCreate: " + sqlProfil);
        db.execSQL(sqlProfil);
        sqlProfil = "INSERT INTO profil (nama, alamat, hp, tgl) VALUES ('Ezra Septian', 'Jl. Raya Hankam', '08979828866','28-09-1997');";
        db.execSQL(sqlProfil);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}