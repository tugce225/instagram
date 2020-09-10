package com.example.ins;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class girisActivity extends AppCompatActivity {
       EditText edt_email, edt_sifre ;
       Button btn_button;
    public static String MAIL = "MAIL";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        edt_email=findViewById(R.id.edt_email);
        edt_sifre=findViewById(R.id.edt_sifre);
        btn_button=findViewById(R.id.btn_button);

        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog  pd= new ProgressDialog(girisActivity.this);
                pd.setMessage("Giris yapiliyor...");
                pd.show();


               String  str_email = edt_email.getText().toString();
               String  str_sifre = edt_sifre.getText().toString();

               String upperCaseChars = "(.*[A-Z].*)";    //sifre icin buyuk harf
               String numbers = "(.*[0-9].*)";            //sifre icin sayi

                if(TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_sifre))
               {
                   Toast.makeText(girisActivity.this, "butun alanları doldurun...", Toast.LENGTH_SHORT).show();  //2 alan da boş ise hata mesaji
               }
              else if(str_sifre.length()<6 && !str_sifre.contains(upperCaseChars) && !str_sifre.contains(numbers))
               {
                   Toast.makeText(girisActivity.this,"şifreniz en az 6 karakterli,büyük harf ve sayı içermelidir...", Toast.LENGTH_LONG).show(); //uzunlugu 6 dan kucuk , buyuk harf ve sayi icermiyorsa hata mesajı ver
               }
              else if (!str_email.contains("@"))
               {
                  Toast.makeText(girisActivity.this,"dogru mail adresi giriniz...",Toast.LENGTH_LONG).show();

               }

               else
                {    Bundle extras = new Bundle();
                    extras.putString(MAIL, str_email);
                    Intent a = new Intent();
                    a.setClass(getApplicationContext(), onayActivity.class);
                    startActivity(a);
                    a.putExtras(extras);
                    pd.dismiss();
                    Intent intent =  new Intent(girisActivity.this,onayActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

}