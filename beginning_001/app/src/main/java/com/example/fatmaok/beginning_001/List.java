package com.example.fatmaok.beginning_001;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}
