package jrdcom.com.javademo.Abstract;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public abstract class Person {
    private final static String TAG = "zlwu";
    public abstract void work();
    public void sleep(){
        Log.d(TAG, "Person sleep");
    };
}
