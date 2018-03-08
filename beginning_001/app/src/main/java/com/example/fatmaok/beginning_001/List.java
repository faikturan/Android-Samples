package com.example.fatmaok.beginning_001;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.widget.AdapterView.*;

/**
 * Created by fatmaok on 3/8/18.
 */

public class List extends Activity {

    String ulkeler[]={"Türkiye","Almanya","Çin","Japonya","Rusya"};
    ListView ulkelist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);

        ulkelist=(ListView) findViewById(R.id.lv);

        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,android.R.id.text1,ulkeler);
        ulkelist.setAdapter(adapt);

        OnItemClickListener listener =new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder diyalogPencerem= new AlertDialog.Builder(List.this);
                diyalogPencerem.setMessage(ulkeler[position]);
                diyalogPencerem.setCancelable(false);
                diyalogPencerem.setPositiveButton("Tamam", new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                diyalogPencerem.create().show();
            }
        };
        ulkelist.setOnItemClickListener(listener);
    }
}
