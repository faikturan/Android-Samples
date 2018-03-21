package com.example.fatmaok.beginning_001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends Activity implements OnClickListener {



    EditText aliciMailleri, mailKonusu,aliciAdlari,mail,kapanisSozu;
    String mailAdresleri,konu,alicilarinIsimleri,mailinKendisi,sonSoz;
    Button gonder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailgonder);
        ilkleme();

    }
    private void ilkleme()
    {
        aliciMailleri=(EditText)findViewById(R.id.etMailler);
        mailKonusu=(EditText)findViewById(R.id.etMailKonusu);
        aliciAdlari=(EditText)findViewById(R.id.etMailAliciAdi);
        mail=(EditText)findViewById(R.id.etMailMesaj);
        kapanisSozu=(EditText)findViewById(R.id.etMailKapanis);
        gonder=(Button)findViewById(R.id.bGonder);
        gonder.setOnClickListener(this);
    }
    private void editTextleriStringeCevirenMetod()
    {
        mailAdresleri=aliciMailleri.getText().toString();
        konu=mailKonusu.getText().toString();
        alicilarinIsimleri=aliciAdlari.getText().toString();
        mailinKendisi=mail.getText().toString();
        sonSoz=kapanisSozu.getText().toString();
    }
    @Override
    public void onClick(View v) {

        Toast.makeText(getApplicationContext(),"mail gonderiliyor...",Toast.LENGTH_SHORT).show();

        editTextleriStringeCevirenMetod();

        String mailAdresleriniTutanDizi[]={mailAdresleri};
        String mailIcerigi="Merhabalar"
                +alicilarinIsimleri
                +"\n Soylemek istedigim bazi seyler var.Şöyle ki:\n"
                +mail
                +"İyi calismalar ....."
                +kapanisSozu
                +"\n Mailin sonu ";

        Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,mailAdresleriniTutanDizi);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,konu);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,mailIcerigi);

        startActivity(emailIntent);
    }
}