package com.example.fatmaok.beginning_001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button ekle,cikar;
    TextView sonucEkrani;
    int gs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gs=0;
        ekle=(Button)findViewById(R.id.bekle);
        cikar=(Button)findViewById(R.id.bcikar);
        sonucEkrani=(TextView)findViewById(R.id.tvsnc);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            gs++;
            sonucEkrani.setText("Sonuç="+gs);
            }
        });

        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            gs--;
            sonucEkrani.setText("Sonuç="+gs);
            }
        });
    }
}
