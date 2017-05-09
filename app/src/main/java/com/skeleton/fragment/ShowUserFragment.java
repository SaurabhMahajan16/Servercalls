package com.skeleton.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skeleton.R;
import com.skeleton.adapter.RecyclerViewAdapter;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * contains all users
 */

public class ShowUserFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        init(view);
        RestClient.getApiInterface().getData().enqueue(new ResponseResolver<List<UserInfo>>(getContext(), true) {
            @Override
            public void success(final List<UserInfo> userInfos) {

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),
                        userInfos);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void failure(final APIError error) {

            }
        });
        return view;
    }

    /**
     * @param view view
     */
    private void init(final View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_users);
    }
}
