package com.skeleton.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skeleton.R;
import com.skeleton.adapter.UserPostsAdapter;
import com.skeleton.model.UserPosts;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.Log;

import java.util.List;

/**
 * contains post
 */

public class ShowUserPostFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userposts, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvShowPosts);
        int id = getArguments().getInt("id");

        RestClient.getApiInterface().getUserposts(id).enqueue(new ResponseResolver<List<UserPosts>>(getContext(), true) {
            @Override
            public void success(final List<UserPosts> userPostses) {
                UserPostsAdapter userPostsRecyclerViewAdapter = new UserPostsAdapter(userPostses, getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(userPostsRecyclerViewAdapter);
            }

            @Override
            public void failure(final APIError error) {
                Log.d("hello", "failure: ");

            }
        });
        return view;
    }
}
