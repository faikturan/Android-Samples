package com.example.fatmaok.beginning_001;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.VisibleForTesting;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by fatmaok on 3/9/18.
 */

public class TextPlay extends Activity {

    EditText girilenMetin;
    Button gonder;
    ToggleButton degistir;
    TextView degistirilecekYazi;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textplay);

        girilenMetin=(EditText) findViewById(R.id.etGirilenMetin);
        gonder=(Button) findViewById(R.id.bGonder);
        degistir=(ToggleButton) findViewById(R.id.tbDegistir);
        degistirilecekYazi=(TextView) findViewById(R.id.tvDegistirilecekYazi);


        degistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(degistir.isChecked())
                    girilenMetin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                else
                    girilenMetin.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });//gravity ile yeri belirleniyor
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alinanYazi=girilenMetin.getText().toString();
                degistirilecekYazi.setText(alinanYazi);
                if(alinanYazi.contentEquals("sol"))
                    degistirilecekYazi.setGravity(Gravity.LEFT);
                else if(alinanYazi.contentEquals("sag"))
                    degistirilecekYazi.setGravity(Gravity.RIGHT);
                else if(alinanYazi.contentEquals("orta"))
                    degistirilecekYazi.setGravity(Gravity.CENTER);
                else if(alinanYazi.contentEquals("mf")){
                    Random catlak=new Random();
                    degistirilecekYazi.setText("mf");
                    degistirilecekYazi.setTextSize(catlak.nextInt(60));
                    degistirilecekYazi.setTextColor(Color.CYAN);


                    switch (catlak.nextInt(3))
                    {
                        case 0:
                            degistirilecekYazi.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            degistirilecekYazi.setGravity(Gravity.RIGHT);
                            break;
                        case 2:
                            degistirilecekYazi.setGravity(Gravity.CENTER);
                            break;
                    }
                }else{
                    degistirilecekYazi.setText("Geçersiz Değer");
                    degistirilecekYazi.setGravity(Gravity.CENTER);
                }

            }
        });


    }
}
