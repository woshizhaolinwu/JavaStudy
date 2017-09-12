package jrdcom.com.javademo.SafeThread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by longcheng on 2017/9/8.
 */

public class SyncThreadDemo implements Runnable {
    private static int count = 0;
    private final static String TAG = "zlwu";
    private Handler myHandler;
    //private Message myMessage;
    public SyncThreadDemo(Handler handler){
        myHandler = handler;

    }
    @Override
    public void run() {
        countMethod();
    }

    private synchronized void countMethod(){
        for(int i = 0; i < 5; i++){
            try{
                Thread.sleep(100);
                count++;
                Message myMessage = new Message();
                myMessage.what = 0x12;
                Bundle bundle = new Bundle();
                bundle.putInt("count",count);
                myMessage.setData(bundle);
                myHandler.sendMessage(myMessage);

                Log.d(TAG, "线程:"+Thread.currentThread().getName()+"count:"+ count);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


}
