package com.mobil.hafta9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText et_icerik;
    Button oku;
    TextView tw_icerik;
    Button yaz;

    FileOutputStream outputStream;
    FileInputStream inputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_icerik = (EditText) findViewById(R.id.main_edit);
        yaz=(Button) findViewById(R.id.main_yaz);
        tw_icerik=(TextView)findViewById(R.id.main_icerik);
        oku = (Button) findViewById(R.id.main_oku);

        yaz.setOnClickListener(new View.OnClickListener())
        {
            @Override
                    public  void OnClick(View v)
            try {
                outputStream = openFileOutput("dosya.txt", Context.MODE_PRIVATE);

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            try {
                outputStream.write(et_icerik.getText().toString().getBytes());
                outputStream.close();
                Toast.makeText(MainActivity.this, "Başarıyla Dosya Yazıldı",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        oku.setOnClickListener(new  View.OnClickListener())
        {
            @Override
                    public void OnClick(View v)
            {
                int a = 65;
                 tw_icerik.setText(Character.toString(char)a));
                try {
                    inputStream = openFileInput("dosya.txt");
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                int x;
                String  okunanmetin ="";
                try {
                    while ((x = inputStream.read()) =! -1)
                    {
                        okunanmetin += Character.toString((char)x);
                    }
                    inputStream.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                tw_icerik.setText(okunanmetin);
                Toast.makeText(MainActivity.this,okunanmetin,Toast.LENGTH_SHORT).show();
            }
        }
    }
}