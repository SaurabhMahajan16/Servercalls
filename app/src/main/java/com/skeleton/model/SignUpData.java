package com.skeleton.model;

import java.io.File;

/**
 * to get data of signUp page
 */

public class SignUpData {
    private String mFirstName, mDOB, mCountryCode, mPhoneNo, mEmail, mDeviceToken, mAppVersion, mLang, mDeviceType, mGender;
    private File mProfilePic;

    /**
     * @param mFirstName   name
     * @param mDOB         dob
     * @param mCountryCode code
     * @param mPhoneNo     phone
     * @param mEmail       email
     * @param mDeviceToken token
     * @param mAppVersion  version
     * @param mGender      gender
     */
    public SignUpData(final String mFirstName, final String mDOB, final String mCountryCode,
                      final String mPhoneNo, final String mEmail, final String mDeviceToken,
                      final String mAppVersion, final String mGender) {
        this.mFirstName = mFirstName;
        this.mDOB = mDOB;
        this.mCountryCode = mCountryCode;
        this.mPhoneNo = mPhoneNo;
        this.mEmail = mEmail;
        this.mDeviceToken = mDeviceToken;
        this.mAppVersion = mAppVersion;
        this.mLang = "En";
        this.mDeviceType = "Android";
        this.mGender = mGender;

    }

    /**
     * @return firstname
     */
    public String getmFirstName() {
        return mFirstName;
    }

    /**
     * @return dob
     */
    public String getmDOB() {
        return mDOB;
    }

    /**
     * @return country code
     */
    public String getmCountryCode() {
        return mCountryCode;
    }

    /**
     * @return phone no
     */
    public String getmPhoneNo() {
        return mPhoneNo;
    }

    /**
     * @return email
     */
    public String getmEmail() {
        return mEmail;
    }

    /**
     * @return device token
     */
    public String getmDeviceToken() {
        return mDeviceToken;
    }

    /**
     * @return version
     */
    public String getmAppVersion() {
        return mAppVersion;
    }

    /**
     * @return lang
     */
    public String getmLang() {
        return mLang;
    }

    /**
     * @return device type
     */
    public String getmDeviceType() {
        return mDeviceType;
    }

    /**
     * @return gender
     */
    public String getmGender() {
        return mGender;
    }

    /**
     * @return profile pic
     */
    public File getmProfilePic() {
        return mProfilePic;
    }
}
