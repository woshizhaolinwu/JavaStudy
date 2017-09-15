package jrdcom.com.javademo.FileOperate;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jrdcom.com.javademo.JrdCommon;

/**
 * Created by longcheng on 2017/9/13.
 */

public class JrdFile {
    private Context mContext;
    public JrdFile(Context context){
        mContext = context;
        initStringBuffer();
    }

    private void initStringBuffer(){
        JrdCommon.clearStringBuffer();
    }
    //
    private String getFilePath(){
        return mContext.getExternalFilesDir("")+"/"+"test.txt";
    }

    public void writeFile(){
        String filePath = getFilePath();
        try{
            FileWriter fileWriter =new FileWriter(filePath); ;//new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("Hello one\n");

            //fileWriter.write("Hello one \n");
            //fileWriter.close();
            bw.close();
            JrdCommon.appendStringBuffer("Write File Success!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(){
        String filePaht = getFilePath();
        char[] buf = new char[1024];
        JrdCommon.appendStringBuffer("Read File begin!");
        try{
            FileReader fileReader = new FileReader(filePaht);
            BufferedReader bw = new BufferedReader(fileReader);

            int rd = fileReader.read();

            /*while ((rd = fileReader.read(buf, 0, rd)) != -1){
                JrdCommon.appendStringBuffer(String.valueOf(buf));
            }*/
            String line = null;
            while((line = bw.readLine())!= null){
                JrdCommon.appendStringBuffer(line);
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
