package com.skeleton.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.DisplayActivity;
import com.skeleton.model.UserInfo;
import com.skeleton.util.Log;

/**
 * Contains user deatils
 */

public class ShowUserDetailFragment extends BaseFragment {
    private LinearLayout linearLayout;
    private TextView tvName, tvUserName, tvStreet, tvPhoneNumber, tvCompany, tvEmail;
    private UserInfo.Address address;
    private UserInfo.Company company;
    private Button btnShowPost;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_showuserdetails, container, false);
        init(view);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            linearLayout.setVisibility(View.VISIBLE);
            final UserInfo userInfo = bundle.getParcelable("obj");
            tvName.setText(userInfo.getName());
            Log.d("xxx", userInfo.getName());
            tvUserName.setText(userInfo.getUsername());
            tvEmail.setText(userInfo.getEmail());
            address = userInfo.getAddress();
            String s = address.getStreet();
            tvStreet.setText(s);
            tvPhoneNumber.setText(userInfo.getPhone());
            company = userInfo.getCompany();
            String cmony;
            cmony = company.getName();
            tvCompany.setText(cmony);
            btnShowPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {


                    ShowUserPostFragment showUserPostFragment = new ShowUserPostFragment();
                    Bundle bundle1 = new Bundle();
                    int id;
                    id = userInfo.getId();
                    bundle1.putInt("id", id);
                    showUserPostFragment.setArguments(bundle1);
                    android.support.v4.app.FragmentManager fragmentManager = ((DisplayActivity) getContext()).getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.llFullDisplay, showUserPostFragment);
                    fragmentTransaction.commit();
                }


            });

        }
        return view;
    }

    /**
     * @param view parameter
     */

    private void init(final View view) {
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvStreet = (TextView) view.findViewById(R.id.tvStreet);
        tvPhoneNumber = (TextView) view.findViewById(R.id.tvPhoneNumber);
        tvCompany = (TextView) view.findViewById(R.id.tvCompanyName);
        btnShowPost = (Button) view.findViewById(R.id.btn_showUser);
        linearLayout = (LinearLayout) view.findViewById(R.id.xxxx);

    }
}
