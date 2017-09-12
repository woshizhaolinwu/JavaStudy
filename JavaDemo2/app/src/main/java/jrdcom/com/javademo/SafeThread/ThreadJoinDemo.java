package jrdcom.com.javademo.SafeThread;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/8.
 */

public class ThreadJoinDemo implements Runnable {
    private final static String TAG ="zlwu";
    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
        {
            Log.d(TAG,"Thread:"+ Thread.currentThread().getName()+ "add for ThreadJoinDemo: "+i);
            Thread.yield();//临时停止
        }
    }
}
