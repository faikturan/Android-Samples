package com.example.fatmaok.beginning_001;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Button;
import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fatmaok on 3/21/18.
 */

public class ResimCek extends Activity implements OnClickListener{
    ImageView cekilenResim;
    ImageButton resimCekenButton;
    Button duvarkagidiYapButonu;
    Intent i;
    final static int kamera=0;
    Bitmap bmp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kamera);
        baslangic();
        @SuppressLint("ResourceType") InputStream is=getResources().openRawResource(R.drawable.ic_launcher_background);
        bmp= BitmapFactory.decodeStream(is);//telefonun yatay/dikey konumundaki degisiklik
    }
    private void baslangic(){
        cekilenResim=(ImageView)findViewById(R.id.ivCekilenResim);
        resimCekenButton=(ImageButton)findViewById(R.id.ibResimCek);
        duvarkagidiYapButonu=(Button)findViewById(R.id.bDuvarKagidiYap);
        resimCekenButton.setOnClickListener(this);//this ResimCek class ı nı temsil eder
        duvarkagidiYapButonu.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bDuvarKagidiYap://duvarkağıdı yap butonuna basılınca

                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibResimCek://resim cek butonuna basılınca

                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//resim cekme aktivitesi başlar
                startActivityForResult(i,kamera);//çekilen resim sonuç olarak geri döner
                //startactforres sonrasında onactivityresult ı gerektirir
                break;

        }
    }

    @Override//resim cekme aktivitesinin sonucu
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)//foto düzgün bi sekilde cekildiyse
        {
            Bundle B=data.getExtras();//extra ile gelen veriyi bundle a atar
            bmp=(Bitmap) B.get("data");//sonrasında bitmap e atar
            cekilenResim.setImageBitmap(bmp);//imageview in içine dahil eder
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
