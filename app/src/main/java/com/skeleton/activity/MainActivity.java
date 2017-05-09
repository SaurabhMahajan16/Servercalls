package com.skeleton.activity;

import android.os.Bundle;

import com.skeleton.R;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * main activity
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestClient.getApiInterface().getData().enqueue(
                new ResponseResolver<List<UserInfo>>(this, true) {
                    @Override
                    public void success(final List<UserInfo> userInfos) {

                    }

                    @Override
                    public void failure(final APIError error) {

                    }
                });
    }
}
