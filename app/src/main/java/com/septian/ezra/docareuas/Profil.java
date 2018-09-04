package com.septian.ezra.docareuas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    public static Profil pf;
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView tvprofNama, tvprofAlamat, tvprofHp, tvprofTTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        pf = this;
        dbHelper = new DataHelper(this);
        RefreshList();

    }

    public void RefreshList() {
        dbHelper = new DataHelper(this);
        tvprofNama = (TextView) findViewById(R.id.tvprofNama);
        tvprofAlamat = (TextView) findViewById(R.id.tvprofAlamat);
        tvprofHp = (TextView) findViewById(R.id.tvprofHp);
        tvprofTTL = (TextView) findViewById(R.id.tvprofTTL);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM profil", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            tvprofNama.setText(cursor.getString(0).toString());
            tvprofAlamat.setText(cursor.getString(1).toString());
            tvprofHp.setText(cursor.getString(2).toString());
            tvprofTTL.setText(cursor.getString(3).toString());
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit:
                Intent i = new Intent(getApplicationContext(), profil_edt.class);
                startActivity(i);
                break;
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
}