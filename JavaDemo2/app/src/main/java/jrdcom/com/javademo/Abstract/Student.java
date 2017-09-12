package jrdcom.com.javademo.Abstract;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public class Student extends Person {
    private final static String TAG = "zlwu";
    @Override
    public void work() {
        Log.d(TAG, "student work");
    }

    @Override
    public void sleep() {
        //super.sleep();
        Log.d(TAG, "student sleep");
    }
}
