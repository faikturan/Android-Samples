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
        //simple.... olan hazır kullanılmış list yapısıdır,ülkeler ayrı ayrı bir textviewdir,ulkeleri göstermek için onu en sona yazdık
        ulkelist.setAdapter(adapt);

        OnItemClickListener listener =new OnItemClickListener() {
            //herbir item a tıklandığında neler olacağını burda işliyoruz
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //herbirine tıklandığında bi alertdialog oluşcak
                AlertDialog.Builder diyalogPencerem= new AlertDialog.Builder(List.this);
                diyalogPencerem.setMessage(ulkeler[position]);//yazacağı mesaj
                diyalogPencerem.setCancelable(false);
                diyalogPencerem.setPositiveButton("Tamam", new android.content.DialogInterface.OnClickListener() {

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
