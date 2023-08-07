package com.example.dosyaokuma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView yazılannot;
EditText notyaz;
Button write,delete;
TextView okunulandata;
TextView okunulannot;
Button read;
String[] data;
WriteInternal writeInternalNesne;
String Filename="myData.txt";
ArrayList<String> listem;
ReadInternal readData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //yazılannot=findViewById(R.id.yazılannot);
        notyaz=findViewById(R.id.notyaz);
        write=findViewById(R.id.write);
        //okunulandata=findViewById(R.id.okunulandata);
        okunulannot=findViewById(R.id.okunulannot);
        read=findViewById(R.id.read);
        data=new String[1];
        listem=new ArrayList<>();
        delete=findViewById(R.id.delete);


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;

                text=notyaz.getText().toString();
                if(text.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Text boş", Toast.LENGTH_SHORT).show();
                }

                else{
                    data[0] = notyaz.getText().toString();
                    writeInternalNesne = new WriteInternal();
                    writeInternalNesne.WriteInternal(Filename, data, MainActivity.this);
                    notyaz.setText(" ");
                    Toast.makeText(MainActivity.this, "BAŞARILI", Toast.LENGTH_SHORT).show();
                }
            }

        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData = new ReadInternal();
                readData.ReadData(Filename,MainActivity.this);
                listem=readData.liste;
                String etDatası="";

                for(int i=0;i<listem.size();i++){
                    etDatası+=listem.get(i)+"\n";
                }
                okunulannot.setText(etDatası);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = new File(getFilesDir(), "myData.txt");
                    FileWriter writer = new FileWriter(file);
                    writer.write("");
                    writer.close();
                    Toast.makeText(MainActivity.this, "Dosya içeriği temizlendi.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}