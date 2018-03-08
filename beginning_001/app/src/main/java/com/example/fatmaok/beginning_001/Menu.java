package com.example.fatmaok.beginning_001;

import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

/**
 * Created by fatmaok on 3/7/18.
 */

public class Menu extends ListActivity {
    String siniflarim[]={"MAinActivity","Liste","denemeiki","denemeuc"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ArrayAdapter adaptorum=new ArrayAdapter(this, android.R.layout.simple_list_item_1,siniflarim);
        //liste oluşturulduğunda ona bailangıç değeri ataması yapar "list_item_1" diğer elemeanlar otomatik olarak gelir
        setListAdapter(adaptorum);
        //adaptörle siniflarim dizisini listeye bağlamış olduk
    }


    @Override
    protected void onListItemClick(ListView l,View v,int position,long id)
    {//listedeki her item a tıklandığında yapılacak olan işlemler yer alır
        super.onListItemClick(l,v,position,id);

        String secilen=siniflarim[position];

        try {
            Class secilenClass= null;
            secilenClass = Class.forName("com.example.fatmaok.beginning_001"+secilen);
            Intent intent=new Intent(this,secilenClass);

            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}
