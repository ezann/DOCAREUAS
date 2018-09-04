package com.septian.ezra.docareuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by EzraSept on 08/07/2017.
 */

public class DataAdapter extends ArrayAdapter {
    private ArrayList<DataList> alData;

    public DataAdapter(Context con, int textViewResourceId, ArrayList<DataList>alData){
        super(con, textViewResourceId, alData);
        this.alData = alData;
    }


    @Override
    public View getView (int pos, View convertView, ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.row, null);
        }
        DataList dl = alData.get(pos);
        if (dl != null){
            TextView tvNama = (TextView) v.findViewById(R.id.tvNama);
            TextView tvAlamat = (TextView) v.findViewById(R.id.tvAlamat);
            TextView tvNo = (TextView) v.findViewById(R.id.tvNo);
            tvNama.setText(dl.nama);
            tvAlamat.setText(dl.alamat);
            tvNo.setText(dl.no);
        }
        return v;
    }
}
