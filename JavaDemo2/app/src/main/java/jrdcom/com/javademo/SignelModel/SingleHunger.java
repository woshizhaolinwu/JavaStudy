package jrdcom.com.javademo.SignelModel;

/**
 * Created by longcheng on 2017/9/7.
 */

//饿汉模式
public class SingleHunger {
    private static SingleHunger s = new SingleHunger();
    public static SingleHunger getInstance(){
        return s;
    }
}
