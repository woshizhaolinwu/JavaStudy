package jrdcom.com.javademo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by longcheng on 17/3/11.
 */
public class JrdBaseFragment extends AppCompatActivity implements JrdListFragment.JrdListFragmentClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jrdbasefragment);

        //添加list fragment
        JrdListFragment jrdListFragment =new JrdListFragment();
        jrdListFragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(R.id.fragment_container,jrdListFragment).commit();
    }

    @Override
    public void onFragmentListClick(int position) {
        //替换成ContentFragment
        JrdContentFragment jrdContentFragment =  new JrdContentFragment();
        Bundle arg = new Bundle();
        arg.putInt("position", position);
        jrdContentFragment.setArguments(arg);
        FragmentTransaction fragmentTransaction =  getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, jrdContentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
