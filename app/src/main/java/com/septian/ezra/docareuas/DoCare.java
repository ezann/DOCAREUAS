package com.septian.ezra.docareuas;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class DoCare extends AppCompatActivity {

    ArrayList<DataList> alData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_care);

        alData.add(new DataList("Yayasan Panti Asuhan Thariqul Jannah","Jl.Horison I Kav. PLN, Taman Narogong Indah, Rawalumbu, Kota Bekasi","02198211485"));
        alData.add(new DataList("Yayasan Heesu","Desa Situsari, Kampung Tunggilis RT.02 / RW.07 Kecamatan Cileungsi, Kabupaten Bogor","02189941192"));
        alData.add(new DataList("Rumah Yatim","Jl.Veteran No.57 Bekasi Selaatan dekat alun-alun kota Bekasi","0218842601"));

        ListView lvAlamat = (ListView) findViewById(R.id.lvAlamat);
        DataAdapter adapter = new DataAdapter(this,R.layout.row,alData);
        lvAlamat.setAdapter(adapter);
    }

}