package com.skeleton.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.model.UserData;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.CommonParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;

/**
 * consists of sign in page
 */

public class SignInFragment extends BaseFragment implements View.OnClickListener {
    private MaterialEditText etEmail, etPass;
    private String mEmail, mPass;
    private Button btnSignIn;
    private CheckBox cbremember;
    private LinearLayout linearLayout;

    /**
     * Enable floating label for material edit text
     *
     * @param editTexts :list of editText
     */
    public static void enableFoatingEditText(final MaterialEditText... editTexts) {
        for (MaterialEditText editText : editTexts) {
            editText.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        return view;
    }

    /**
     * to find ids
     *
     * @param view view
     */
    private void init(final View view) {
        etEmail = (MaterialEditText) view.findViewById(R.id.et_email);
        etPass = (MaterialEditText) view.findViewById(R.id.et_pass);
        btnSignIn = (Button) view.findViewById(R.id.btn_signin);
        cbremember = (CheckBox) view.findViewById(R.id.cb_remember);
        btnSignIn.setOnClickListener(this);
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_login);
        enableFoatingEditText();
    }

    /**
     * extract data
     */
    public void extractData() {
        mEmail = etEmail.getText().toString();
        mPass = etPass.getText().toString();


    }

    /**
     * @return true if validates
     */
    public boolean validateFields() {
        if (!(ValidateEditText.checkEmail(etEmail))) {
            return false;
        } else if (!(ValidateEditText.checkPassword(etPass, false))) {
            return false;
        }
        return true;

    }

    @Override
    public void onClick(final View v) {
        super.onClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.btn_signin:
                extractData();
                if (validateFields()) {
                    CommonParams params = new CommonParams.Builder()
                            .add("email", etEmail.getText().toString())
                            .add("password", etPass.getText().toString())
                            .add("deviceType", "ANDROID")
                            .add("language", "EN")
                            .add("deviceToken", "XYZ")
                            .add("flushPreviousSessions", true)
                            .add("appVersion", "101")
                            .build();
                    RestClient.getApiInterface().login(null, params.getMap()).
                            enqueue(new ResponseResolver<UserData>(getContext(), true, true) {
                                @Override
                                public void success(final UserData userData) {
                                    Snackbar snackbar = Snackbar.make(linearLayout,
                                            userData.getMessage(), Snackbar.LENGTH_SHORT);
                                    snackbar.show();
                                }

                                @Override
                                public void failure(final APIError error) {
                                    Toast.makeText(getContext(), error.getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
            default:
                break;
        }
    }
}
