package com.skeleton.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.skeleton.R;
import com.skeleton.adapter.PagerAdapter;
import com.skeleton.fragment.SignInFragment;
import com.skeleton.fragment.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * class contains view pager and tab layout
 */
public class SignUpLoginActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> list;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);
        init();
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    /**
     * method used to find ids
     */
    private void init() {
        viewPager = (ViewPager) findViewById(R.id.vp_swipe);
        tabLayout = (TabLayout) findViewById(R.id.tab_login);
        list = new ArrayList<>();
        list.add(new SignInFragment());
        list.add(new SignUpFragment());
    }
}
