package jrdcom.com.javademo.FileOperate;

import android.content.Context;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jrdcom.com.javademo.JrdCommon;

/**
 * Created by longcheng on 2017/9/13.
 */

public class JrdFileCopy {

    //private String
    private String filePath;
    private String filePath2;
    private Context mContext;

    public JrdFileCopy(Context context){
        mContext = context;
        filePath = mContext.getExternalFilesDir("")+"/"+"test2.txt";
        filePath2 = mContext.getExternalFilesDir("")+"/"+"test3.txt";
        JrdCommon.clearStringBuffer();

    }

    public void copyFile(){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            FileReader fileReader = new FileReader(filePath);

            FileWriter fileWriter2 = new FileWriter(filePath2);
            FileReader fileReader2 = new FileReader(filePath2);

            //写数据到test2.txt
            fileWriter.write("Hello world \n");

            //从test2拷贝到test3.txt
            int ch = fileReader.read();
            while((ch = fileReader.read())!=-1){
                fileWriter2.write(ch);
            }

            //从test3读数据
            int ch2= 0;
            while((ch2 = fileReader2.read())!= -1){
                JrdCommon.appendStringBuffer(String.valueOf(ch2));
            }
            fileReader.close();
            fileReader2.close();
            fileWriter.close();
            fileWriter2.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }

    }
}
