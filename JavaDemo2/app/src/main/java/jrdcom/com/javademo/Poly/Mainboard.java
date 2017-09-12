package jrdcom.com.javademo.Poly;

/**
 * Created by longcheng on 2017/9/7.
 */

public class Mainboard
{
    public Mainboard(){
        init();
    }

    private void init(){
        useCard(new NetCard());
    }

    private void useCard(deviceInterface card){
        if(card != null){
            card.open();
            card.close();
        }
    }
}
