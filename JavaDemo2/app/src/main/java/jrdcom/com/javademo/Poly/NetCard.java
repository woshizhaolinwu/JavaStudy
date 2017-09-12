package jrdcom.com.javademo.Poly;

import android.util.Log;

/**
 * Created by longcheng on 2017/9/7.
 */

public class NetCard implements deviceInterface {
    private final static String TAG = "zlwu";
    @Override
    public void open() {
        Log.d(TAG, "网卡打开");
    }
    public void close(){
        Log.d(TAG, "网卡关闭");
    }
}
