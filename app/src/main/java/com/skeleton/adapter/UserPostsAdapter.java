package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.UserPosts;
import com.skeleton.util.Log;

import java.util.List;

/**
 * contains user posts
 */

public class UserPostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserPosts> userPosts;
    private Context mContext;

    /**
     * @param userPosts cons
     * @param mContext  param
     */
    public UserPostsAdapter(final List<UserPosts> userPosts, final Context mContext) {
        this.userPosts = userPosts;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.userposts_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        UserPosts userPost = userPosts.get(position);
        UserPostsAdapter.ViewHolder viewHolder = (UserPostsAdapter.ViewHolder) holder;
        int x = userPost.getPostId();
        String ok = String.valueOf(x);
        Log.d("hi", ok);
        viewHolder.tvId.setText(String.valueOf(userPost.getPostId()));
        viewHolder.tvTitle.setText(userPost.getTitle());
        viewHolder.tvPost.setText(userPost.getBody());

    }

    @Override
    public int getItemCount() {
        return userPosts.size();
    }

    /**
     * class inner
     */
    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvTitle, tvPost;

        /**
         * @param itemView constructor of viewholder to get ids of views
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvPostId);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPost = (TextView) itemView.findViewById(R.id.tvPost);
        }
    }
}
