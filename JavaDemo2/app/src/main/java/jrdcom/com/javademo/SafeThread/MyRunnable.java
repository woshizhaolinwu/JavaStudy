package jrdcom.com.javademo.SafeThread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public class MyRunnable implements Runnable {
    private final static String TAG = "zlwu";
    private int  tick = 100;
    private Handler myHandler;
    Object obj = new Object();
    public MyRunnable(Handler handler){
        myHandler = handler;
    }

    @Override
    public void run() {
        while(true){
            calc();
            /*synchronized (obj){  //同步Demo一
                if(tick > 0){
                    try{
                        Thread.sleep(10);
                        tick--;
                        Log.d(TAG, "线程"+Thread.currentThread()+"卖票， tick = "+tick);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }*/
        }
    }

    //同步Demo2
    private synchronized void calc(){
        if(tick > 1){
            try{
                Thread.sleep(10);
                tick--;
                //发送到主线程显示
                Message message = new Message();
                message.what = 0x11;
                Bundle bundle = new Bundle();
                bundle.putInt("tick", tick);
                message.setData(bundle);
                myHandler.sendMessage(message);

                Log.d(TAG, "线程"+Thread.currentThread()+"卖票， tick = "+tick);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
