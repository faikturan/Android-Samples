package com.example.fatmaok.beginning_001;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

/**
 * Created by fatmaok on 3/5/18.
 */

public class HosgeldinEkrani extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hosgeldin);

        Thread zamanlayici=new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent mainicagir=new Intent("android.intent.action.MAINACTIVITY");
                    startActivity(mainicagir);
                }
            }
        };
        zamanlayici.start();
    }
}
