package com.example.dosyaokuma;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class WriteInternal {

    public void WriteInternal(String fileName, String[] data, Context context){
            try{
                File myInternalFile=new File(context.getFilesDir(),fileName);
                if (myInternalFile.exists()){
                    // dosya varsa
                }else{
                    // dosya yoksa
                    myInternalFile.createNewFile();

                }
                FileOutputStream myOutputStream= new FileOutputStream(myInternalFile,true);
                OutputStreamWriter myOutputStreamWriter=new OutputStreamWriter(myOutputStream);

                for(int i=0 ;i<data.length;i++){
                    myOutputStreamWriter.write(data[i]+"\n");
                }
                myOutputStreamWriter.flush();
                myOutputStreamWriter.close();
                myOutputStream.close();

            }catch (Exception e){
                e.printStackTrace();
            }
    }


}
