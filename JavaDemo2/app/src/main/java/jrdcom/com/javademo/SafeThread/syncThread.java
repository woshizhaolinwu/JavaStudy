package jrdcom.com.javademo.SafeThread;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/8.
 */

public class syncThread implements Runnable {
    private int count = 0;
    private final static String TAG = "zlwu";
    public syncThread(){

    }
    @Override
    public void run() {
        countMethod();
    }

    private synchronized static void countMethod(){
        for(int i = 0; i < 5; i++){
            try{
                Thread.sleep(100);
                Log.d(TAG, "线程:"+Thread.currentThread().getName()+"countMethod");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


}
