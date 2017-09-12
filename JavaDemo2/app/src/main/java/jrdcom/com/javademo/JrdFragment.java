package jrdcom.com.javademo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dhcui on 2017/3/4.
 */
public class JrdFragment extends android.support.v4.app.Fragment {
    public static JrdFragment newInStance(){
        JrdFragment jrdFragment = new JrdFragment();
        return jrdFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //这里有个坑，传入container为parent
        View rootView = inflater.inflate(R.layout.fragment_layout_recyler,null);
        //设置recyle view
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        List<JrdListBean> listBeanList = JrdListBean.setTestInfo();

        JrdRecyleAdapter jrdRecyleAdapter = new JrdRecyleAdapter(listBeanList);
        recyclerView.setAdapter(jrdRecyleAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        jrdRecyleAdapter.setSmall(true);

        return rootView;
    }
}
