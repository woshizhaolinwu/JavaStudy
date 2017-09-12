package jrdcom.com.javademo.SignelModel;

/**
 * Created by longcheng on 2017/9/7.
 */
//懒汉模式
public class SingleIdler {
    private static SingleIdler s = null;

    public static SingleIdler getInstance(){
        if(s == null){
            s = new SingleIdler();
        }
        return s;
    }
}
