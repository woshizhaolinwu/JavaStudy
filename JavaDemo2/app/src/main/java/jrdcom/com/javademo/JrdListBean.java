package jrdcom.com.javademo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longcheng on 17/3/1.
 */
public class JrdListBean {
    private int imageId;
    private String title;
    private String subTitle;

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static List<JrdListBean> setTestInfo(){
        List<JrdListBean> listBeans = new ArrayList<JrdListBean>();
        for(int i = 0; i <6 ; i++){
            JrdListBean oneBean = new JrdListBean();
            oneBean.setImageId(R.mipmap.lufy);
            oneBean.setTitle("Test Item 1");
            oneBean.setSubTitle("Test subtle item 1");

            JrdListBean oneBean1 = new JrdListBean();

            oneBean1.setImageId(R.mipmap.lufy);
            oneBean1.setTitle("Test Item 2");
            oneBean1.setSubTitle("Test subtle item 2");
            JrdListBean oneBean2 = new JrdListBean();

            oneBean2.setImageId(R.mipmap.lufy);
            oneBean2.setTitle("Test Item 3");
            oneBean2.setSubTitle("Test subtle item 3");

            listBeans.add(oneBean);
            listBeans.add(oneBean1);
            listBeans.add(oneBean2);
        }
        return listBeans;
    }
}
