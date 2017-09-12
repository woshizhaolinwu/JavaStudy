package jrdcom.com.javademo;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by longcheng on 17/3/11.
 */
public class JrdListFragment extends ListFragment {
    //private String[] jrdListString = {"List one","List two"};
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, JrdCommon.FRAGMENT_LIST));

    }*/
    private JrdListFragmentClickListener mJrdListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, JrdCommon.FRAGMENT_LIST));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mJrdListener.onFragmentListClick(position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mJrdListener = (JrdListFragmentClickListener)activity;
    }

    public interface JrdListFragmentClickListener{
        void onFragmentListClick(int position);
    }
}
