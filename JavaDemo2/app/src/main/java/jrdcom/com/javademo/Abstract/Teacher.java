package jrdcom.com.javademo.Abstract;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public class Teacher extends Person {
    private final static String TAG = "zlwu";
    @Override
    public void work() {
        Log.d(TAG, "teacher is work");
    }

    @Override
    public void sleep() {
       // super.sleep();
        Log.d(TAG, "teacher is sleep");
    }
}
