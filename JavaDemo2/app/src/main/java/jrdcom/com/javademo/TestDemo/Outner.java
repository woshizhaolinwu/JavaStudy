package jrdcom.com.javademo.TestDemo;

/**
 * Created by longcheng on 2017/9/7.
 */

public class Outner {
    public Outner(){
        Inner inner = new Inner();
        inner.demo1();

        new Inner().demo1();
        new Inner1().demo1();

    }

    public class Inner{
        private void demo1(){

        }

        public void demo2(){

        }
    }

    public static class Inner1{
        public void demo1(){

        }
    }
}
