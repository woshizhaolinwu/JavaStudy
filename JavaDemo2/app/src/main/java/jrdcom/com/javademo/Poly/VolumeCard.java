package jrdcom.com.javademo.Poly;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public class VolumeCard implements deviceInterface {
    private final static String TAG = "zlwu";

    @Override
    public void open() {
        Log.d(TAG, "声卡打开");
    }

    @Override
    public void close() {
        Log.d(TAG, "声卡打开");
    }
}
