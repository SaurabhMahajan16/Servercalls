package com.skeleton.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.skeleton.R;
import com.skeleton.fragment.ShowUserDetailFragment;
import com.skeleton.fragment.ShowUserFragment;

/**
 * display
 */
public class DisplayActivity extends BaseActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ShowUserFragment showUserFragment = new ShowUserFragment();
        ShowUserDetailFragment showUserDetailsFragment = new ShowUserDetailFragment();
        fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentcontainerusers, showUserFragment);
        fragmentTransaction.replace(R.id.fragmentcontainerdetails, showUserDetailsFragment);
        fragmentTransaction.commit();
    }
}
