package com.septian.ezra.docareuas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] menu ={"Do Care","PROFIL","REWARD","ABOUT US"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMenu = (ListView)findViewById(R.id.lvMenu);
        adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_expandable_list_item_1,menu);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent =  new Intent(view.getContext(),DoCare.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent =  new Intent(view.getContext(),Profil.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent =  new Intent(view.getContext(),Reward.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent =  new Intent(view.getContext(),AboutUs.class);
                    startActivity(intent);
                }
            }
        });
    }
}
