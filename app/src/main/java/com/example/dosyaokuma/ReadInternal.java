package com.example.dosyaokuma;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadInternal {

    public ArrayList<String> liste;
    String Line="";


    public void ReadData(String fileName,Context context){

        liste=new ArrayList<>();

        try{
            File myfile=new File(context.getFilesDir(),fileName);
            if(myfile.exists()){
                FileInputStream fIN=new FileInputStream(myfile);
                InputStreamReader inputStreamReader=new InputStreamReader(fIN);//karakter bazlı okur.
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//Dosyaları daha verimli okur.

                while((Line=bufferedReader.readLine())!=null){
                    liste.add(Line);
                }

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }








}
