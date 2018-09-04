package com.septian.ezra.docareuas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profil_edt extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btSimpan;
    EditText etprofNama, etprofAlamat, etprofHp, etprofTTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_edt);

        dbHelper = new DataHelper(this);
        etprofNama = (EditText) findViewById(R.id.etprofNama);
        etprofAlamat = (EditText) findViewById(R.id.etprofAlamat);
        etprofHp = (EditText) findViewById(R.id.etprofHp);
        etprofTTL = (EditText) findViewById(R.id.etprofTTL);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM profil",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etprofNama.setText(cursor.getString(0));
            etprofAlamat.setText(cursor.getString(1));
            etprofHp.setText(cursor.getString(2));
            etprofTTL.setText(cursor.getString(3));
        }
        btSimpan = (Button) findViewById(R.id.btSimpan);
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                try {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE profil set nama='" +
                            etprofNama.getText().toString() + "', alamat='" +
                            etprofAlamat.getText().toString() + "', hp='" +
                            etprofHp.getText().toString() + "', tgl='" +
                            etprofTTL.getText().toString() + "' ");
                    Toast.makeText(getApplicationContext(), "Berhasil Menyimpan", Toast.LENGTH_SHORT).show();
                    Profil.pf.RefreshList();
                    finish();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
