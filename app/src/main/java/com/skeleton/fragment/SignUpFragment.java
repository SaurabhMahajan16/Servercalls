package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.model.UserData;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;
import com.skeleton.util.imagepicker.ImageChooser;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * contains of view of sign up page
 */

public class SignUpFragment extends BaseFragment implements View.OnClickListener {
    private MaterialEditText etName, etPhone, etEmail, etDOB, etPass, etConfirmPass;
    private Button btnSignUp;
    private ImageView ivProfilePic;
    private CheckBox cbToc;
    private RadioGroup rgGender;
    private int mGender;
    private String mName, mPhoneNo, mEmail, mPass, mDOB, mSelectedGender;
    private File mProfilePic;
    private ImageChooser chooser;
    private RadioButton rbMale, rbFemale;

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
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        init(view);
        return view;
    }

    /**
     * @param view to find ids
     */
    private void init(final View view) {
        etName = (MaterialEditText) view.findViewById(R.id.et_name);
        etPhone = (MaterialEditText) view.findViewById(R.id.et_phone);
        etEmail = (MaterialEditText) view.findViewById(R.id.et_email);
        etPass = (MaterialEditText) view.findViewById(R.id.et_pass);
        etConfirmPass = (MaterialEditText) view.findViewById(R.id.et_cnfrm_pass);
        etDOB = (MaterialEditText) view.findViewById(R.id.et_dob);
        rgGender = (RadioGroup) view.findViewById(R.id.rdgrp_gender);
        rbMale = (RadioButton) view.findViewById(R.id.rdbtn_male);
        rbFemale = (RadioButton) view.findViewById(R.id.rdbtn_female);
        cbToc = (CheckBox) view.findViewById(R.id.cb_toc);
        ivProfilePic = (ImageView) view.findViewById(R.id.profile_iv);
        btnSignUp = (Button) view.findViewById(R.id.btn_signup);
        ivProfilePic.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        enableFoatingEditText(etName, etConfirmPass, etPhone, etEmail, etDOB, etPass);
    }

    @Override
    public void onClick(final View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_signup:
                postUserData();
                break;
            case R.id.profile_iv:
                chooser = new ImageChooser.Builder(SignUpFragment.this).build();
                chooser.selectImage(new ImageChooser.OnImageSelectListener() {
                    @Override
                    public void loadImage(final List<ChosenImage> list) {
                        mProfilePic = new File(list.get(0).getOriginalPath());
                        Glide.with(getContext()).load(mProfilePic).into(ivProfilePic);
                    }

                    @Override
                    public void croppedImage(final File mCroppedImage) {

                    }
                });
                break;
            default:
                break;
        }
    }

    /**
     * post data to server
     */
    private void postUserData() {
        if (validateTextFields()) {
            extractUserData();
            MultipartParams params = new MultipartParams.Builder()
                    .add("firstName", mName)
                    .add("dob", mDOB)
                    .add("countryCode", "+91")
                    .add("phoneNo", mPhoneNo)
                    .add("email", mEmail)
                    .add("password", mPass)
                    .add("gender", mGender)
                    .add("deviceToken", "XYZ")
                    .add("appVersion", "100")
                    .add("language", "EN")
                    .add("deviceType", "ANDROID")
                    .addFile("profilePic", mProfilePic).build();
            RestClient.getApiInterface().register(params.getMap()).enqueue(
                    new ResponseResolver<UserData>(getContext(), true) {
                        @Override
                        public void success(final UserData userData) {
                            Toast.makeText(getContext(), userData.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(final APIError error) {
                            Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        chooser.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode,
                                           @NonNull final String[] permissions,
                                           @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        chooser.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * get data from text view
     */
    private void extractUserData() {
        mName = etName.getText().toString().trim();
        mEmail = etEmail.getText().toString().trim();
        mPass = etPass.getText().toString().trim();
        mDOB = etDOB.getText().toString().trim();
        mPhoneNo = etPhone.getText().toString();
        if (rbFemale.isChecked()) {
            mGender = 0;
            mSelectedGender = String.valueOf(mGender);
        } else {
            mGender = 1;
            mSelectedGender = String.valueOf(mGender);
        }
    }

    /**
     * Checks if date is in valid format
     *
     * @param editText : editTextDOB containing date
     * @return : true if valid, else returns false
     */
    private boolean checkDOB(final EditText editText) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = editText.getText().toString();
        try {
            mDOB = df.parse(s).toString();
            return true;

        } catch (ParseException e) {
            editText.setError(getString(R.string.error_invalid_data));
            return false;
        }
    }

    /**
     * validate text fields
     *
     * @return boolean
     */
    public boolean validateTextFields() {

        if (!(ValidateEditText.checkName(etName, true))) {
            return false;
        } else if (!ValidateEditText.checkPhoneNumber(etPhone)) {
            return false;
        } else if (!(ValidateEditText.checkEmail(etEmail))) {
            return false;
        } else if (!ValidateEditText.checkPassword(etPass, false)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etConfirmPass, true)) {
            return false;
        } else if (!ValidateEditText.comparePassword(etPass, etConfirmPass)) {
            return false;
        } else if (!cbToc.isChecked()) {
            Toast.makeText(getContext(), R.string.tv_toc, Toast.LENGTH_SHORT).show();
            return false;
        } else if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getContext(), R.string.error_gender, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!checkDOB(etDOB)) {
            return false;
        } else if (mProfilePic == null) {
            Toast.makeText(getContext(), R.string.error_profilepic, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}