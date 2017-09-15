package jrdcom.com.javademo;

/**
 * Created by longcheng on 17/3/11.
 */
public class JrdCommon {
    public static String[] FRAGMENT_LIST = {"数组", "单例，继承","对象的概念","异常处理","线程安全性","线程2","生产和消费","join的方法","集合的使用","IO操作"};

    public final static int LIST_ONE = 0;   //数组，堆栈内存，遍历， 最值，选择冒泡排序，二位数组，面向对象思想
    public final static int LIST_TWO = 1;   //单例， 继承
    public final static int LIST_THREE = 2; //对象的概念
    public final static int LIST_FOUR = 3;  //对象的概念
    public final static int LIST_FIVE = 4;  //线程安全
    public final static int LIST_SYNC_THREAD = 5;   //线程2
    public final static int LIST_SET_OUT = 6;       //生产者和消费者
    public final static int LIST_JOIN_DEMO = 7;     //Thread.join
    public final static int LIST_COLLECTION = 8;    //集合
    public final static int LIST_IO = 9;    //集合

    public static StringBuffer mStringBuffer = new StringBuffer();
    public static void appendStringBuffer(String stringValue){
        mStringBuffer.append(stringValue + "\n");
    }

    public static String getStringBuffer(){
        return mStringBuffer.toString();
    }

    public static void clearStringBuffer(){
        /*for (int i = 0; i < mStringBuffer.length(); i++){

        }*/
        mStringBuffer.delete(0, mStringBuffer.length());
    }
}
