package jrdcom.com.javademo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

import jrdcom.com.javademo.Abstract.Student;
import jrdcom.com.javademo.Abstract.Teacher;
import jrdcom.com.javademo.SafeThread.MyRunnable;
import jrdcom.com.javademo.SafeThread.SyncThreadDemo;
import jrdcom.com.javademo.SafeThread.ThreadJoinDemo;
import jrdcom.com.javademo.TestDemo.Demo1;
import jrdcom.com.javademo.TestDemo.Demo2;
import jrdcom.com.javademo.TestDemo.Outner;

/**
 * Created by longcheng on 17/3/11.
 */
public class JrdContentFragment extends Fragment {
    private final static String TAG =  "zlwu";
    private TextView content;
    private StringBuilder showStringBuilder;
    private StringBuffer  showStringBuffer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //一定要加上false.
        return inflater.inflate(R.layout.layout_fragment_content,container,false);
}

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle  = getArguments();
        int position = bundle.getInt("position");
        updateText(position);

        showStringBuilder = new StringBuilder();
        content.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private void updateText(int index){
        Activity jrdActivity = getActivity();
        String text = null;
        content = (TextView)getActivity().findViewById(R.id.article);
        switch (index){
            case JrdCommon.LIST_ONE:
                text = ArrayDemo();
                break;
            case JrdCommon.LIST_TWO:
                abstractDemo();
                break;
            case JrdCommon.LIST_THREE:
                text= objectDemo();
                break;
            case JrdCommon.LIST_FOUR:
                try {
                    ExceptionDemo();
                }catch (Exception e){

                }
                break;
            case JrdCommon.LIST_FIVE:
                //线程安全性
                ThreadSafe();
                break;
            case JrdCommon.LIST_SYNC_THREAD:
                ThreadSafe2();
                break;
            case JrdCommon.LIST_SET_OUT:
                break;
            case JrdCommon.LIST_JOIN_DEMO:
                ThreadJoin();
                break;
            case JrdCommon.LIST_COLLECTION:
                text = SetDemo();
                break;

        }
        content.setText(text);
    }


    //数组相关的操作
    private String ArrayDemo(){
        StringBuilder stringBuilder = new StringBuilder();
        //数组定义
        int[] array = {3,9, 5, 8, 4, 1, 7, 2};
        //数组遍历和打印
        stringBuilder.append("数组打印:");
        stringBuilder.append("\n");
        for(int i = 0; i < array.length; i++){
            //Log.d(TAG, "the array item is :"+array[i]);
            stringBuilder.append(array[i]);
            if(i != array.length - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("\n");
        //数组获取最大，最小值
        //int max = Collections.max(array);
        int max = array[0];
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        stringBuilder.append("最大值:");
        stringBuilder.append(max);
        stringBuilder.append("最小值");
        stringBuilder.append(min);
        stringBuilder.append("\n");

        //数组排序
        //选择排序
        int temp = array[0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length;j++){
                if(array[i]>array[j]){ //交换
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        stringBuilder.append("选择排序后数组打印");
        for(int i = 0; i < array.length; i++){
            stringBuilder.append(array[i]);
            if(i != array.length - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("\n");

        //冒泡排序
        int[] array1 = {3,9, 5, 8, 4, 1, 7, 2};

        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1.length - i - 1; j++){
                if(array1[j]<array1[j+1]){
                    temp = array1[j];
                    array1[j] = array1[j+1];
                    array1[j+1] = temp;
                }
            }
        }
        stringBuilder.append("冒泡排序后数组打印");
        for(int i = 0; i < array1.length; i++){
            stringBuilder.append(array1[i]);
            if(i != array1.length - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("\n");

        //二维数组
        stringBuilder.append("二维数组");
        stringBuilder.append("\n");
        int doubleArray[][] = {{1,2,3},{3,2,1},{4,5,6}};
        for(int i =0;i < doubleArray.length;i++){
            for (int j = 0; j < doubleArray[i].length;j++){
                stringBuilder.append(doubleArray[i][j]);
                if(j== doubleArray[i].length - 1){

                }else{
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        String string = stringBuilder.toString();
        return string;
    }

    //抽象类
    private void abstractDemo(){
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.work();
        student.sleep();
        teacher.work();
        teacher.sleep();
    }

    //Object
    private String objectDemo(){
        StringBuilder stringBuilder = new StringBuilder();

        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();
        stringBuilder.append("demo1 和demo2进行比较");
        boolean ret = demo1.equals(demo2);

        stringBuilder.append(ret);
        stringBuilder.append("demo1.toString:");
        stringBuilder.append("\n");
        stringBuilder.append(demo1.toString());

        //new Outner.Inner().demo2();
        new Outner.Inner1().demo1();
        return  stringBuilder.toString();
    }

    private void ExceptionDemo() throws  Exception{
    }

    private void ThreadSafe(){
        MyRunnable runnable = new MyRunnable(myHandler);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    //定义一个handle接收子线程的消息
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            switch (msg.what){
                case 0x11:
                    int tick = msg.getData().getInt("tick");
                    String showString = "线程"+Thread.currentThread()+"卖票："+tick;
                    showStringBuilder.append(showString);
                    showStringBuilder.append("\n");

                    content.setText(showStringBuilder.toString());
                    break;


            }
        }
    };

    //线程安全2
    private void ThreadSafe2(){
        SyncThreadDemo syncThreadDemo1 = new SyncThreadDemo(myHandler);

        Thread thread1 = new Thread(new SyncThreadDemo(myHandler), "thread1");
        Thread thread2 = new Thread(new SyncThreadDemo(myHandler), "thread2");

        thread1.start();
        thread2.start();
    }

    //join的方法
    private void ThreadJoin(){
        ThreadJoinDemo threadJoinDemo = new ThreadJoinDemo();

        Thread thread1 =  new Thread(threadJoinDemo,"long_thread");
        Thread thread2 =  new Thread(threadJoinDemo, "short_thread");

        thread1.start();
        try{
            thread1.join(); //将thread1加入到主线程，等待thread1结束
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread2.start();
        thread2.setPriority(Thread.MAX_PRIORITY);
    }

    //集合
    private String collectionDemo(){
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(13);
        arrayList.add(19);

        //打印arraylist
        stringBuffer.append(arrayList);

        //删除元素
        arrayList.remove(new Integer(13));

        stringBuffer.append("\n");
        stringBuffer.append(arrayList);

        stringBuffer.append("\n");

        //判断 list中是否包含某元素
        if(arrayList.contains(10)){
            stringBuffer.append("true");
        }else{
            stringBuffer.append("false");
        }

        //迭代
        ListIterator iterator= arrayList.listIterator();
        while (iterator.hasNext()){
            stringBuffer.append(iterator.next());
        }
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }


    //Compare ArrayList和LinkedList
    private String ListDemo(){
        StringBuffer stringBuffer = new StringBuffer();
        //ArrayList， 数组， 根据index查找比较快
        //LinkedList, 链表实现， 进行插入删除比较快
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        //ArrayList
        for(int i = 0; i < 100; i++){
            arrayList.add(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        stringBuffer.append("ArrayList添加100个元素花的时间："+(endTime - startTime));
        for (int i = 0; i < 100; i++){
            linkedList.add(String.valueOf(i));
        }
        long endNextTime = System.currentTimeMillis();
        stringBuffer.append("LinkedList添加100个元素花的时间: "+(endNextTime - endTime));

        return stringBuffer.toString();
    }

    private String SetDemo(){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("HashSet:");
        stringBuffer.append("\n");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello 1");
        hashSet.add("Hello 2");
        hashSet.add("Hello 3");
        hashSet.add("Hello 4");

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next());
            stringBuffer.append("\n");
        }

        //hashSet不能添加重复的
        stringBuffer.append(hashSet.add("Hello 3"));
        stringBuffer.append("\n");

        //添加不重复的
        stringBuffer.append("不重复数据添加");
        stringBuffer.append(hashSet.add("Hello 5"));
        stringBuffer.append("\n");


        //TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("hello1");
        treeSet.add("hello2");
        treeSet.add("hello3");
        treeSet.add("hello4");
        treeSet.add("hello5");

        stringBuffer.append("TreeSet  :");
        Iterator iterator1 = treeSet.iterator();
        while(iterator.hasNext()){
            stringBuffer.append(iterator1.next());
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }


    private void sop(String text){
        content.setText(text);
    }
}
