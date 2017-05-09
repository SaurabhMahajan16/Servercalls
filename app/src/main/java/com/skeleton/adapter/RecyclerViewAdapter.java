package com.skeleton.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.DisplayActivity;
import com.skeleton.fragment.ShowUserDetailFragment;
import com.skeleton.model.UserInfo;

import java.util.List;

/**
 * contains users
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<UserInfo> userInfos;

    /**
     * @param mContext  context
     * @param userInfos arraylist
     */
    public RecyclerViewAdapter(final Context mContext, final List<UserInfo> userInfos) {
        this.mContext = mContext;
        this.userInfos = userInfos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        UserInfo userInfo = userInfos.get(position);
        RecyclerViewAdapter.ViewHolder viewHolder = (RecyclerViewAdapter.ViewHolder) holder;
        viewHolder.tvId.setText(String.valueOf(userInfo.getId()));
        viewHolder.linearLayout.setVisibility(View.GONE);
        viewHolder.tvName.setVisibility(View.GONE);
        viewHolder.tvUserName.setVisibility(View.GONE);
        viewHolder.tvCompany.setVisibility(View.GONE);
        viewHolder.tvPhoneNumber.setVisibility(View.GONE);
        viewHolder.tvEmail.setVisibility(View.GONE);
        viewHolder.tvStreet.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return userInfos.size();
    }

    /**
     * inner class to access to items of viewholder
     */
    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvId, tvName, tvUserName, tvEmail, tvStreet, tvPhoneNumber, tvCompany;
        private LinearLayout linearLayout;

        /**
         * @param itemView item
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            tvStreet = (TextView) itemView.findViewById(R.id.tvStreet);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            tvCompany = (TextView) itemView.findViewById(R.id.tvCompanyName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.xxxx1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            int pos;
            pos = getAdapterPosition();
            android.support.v4.app.FragmentManager fragmentManager = ((DisplayActivity)
                    mContext).getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            if (pos != RecyclerView.NO_POSITION) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("obj", userInfos.get(pos));
                ShowUserDetailFragment showUserDetailsFragment = new ShowUserDetailFragment();
                showUserDetailsFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentcontainerdetails, showUserDetailsFragment);
                fragmentTransaction.commit();

            }
        }
    }
}
