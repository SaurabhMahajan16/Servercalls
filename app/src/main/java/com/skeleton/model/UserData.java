package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * contains information of user
 */

public class UserData {


    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    /**
     * @return status
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode sets
     */
    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message sets
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data sets
     */
    public void setData(final Data data) {
        this.data = data;
    }

    /**
     * inner class
     */
    public static class UserImages {
        @SerializedName("_id")
        private String id;
        @SerializedName("thumbnail")
        private String thumbnail;
        @SerializedName("original")
        private String original;

        /**
         * @return id
         */
        public String get_id() {
            return id;
        }

        /**
         * @param mId sets
         */
        public void set_id(final String mId) {
            this.id = mId;
        }

        /**
         * @return thumbnail
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * @param thumbnail sets
         */
        public void setThumbnail(final String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * @return original
         */
        public String getOriginal() {
            return original;
        }

        /**
         * @param original sets
         */
        public void setOriginal(final String original) {
            this.original = original;
        }
    }

    /**
     * inner class user details
     */
    public static class UserDetails {
        @SerializedName("_id")
        private String id;
        @SerializedName("createdAt")
        private String createdAt;
        @SerializedName("updatedAt")
        private String updatedAt;
        @SerializedName("dob")
        private String dob;
        @SerializedName("countryCode")
        private String countryCode;
        @SerializedName("phoneNo")
        private String phoneNo;
        @SerializedName("email")
        private String email;
        @SerializedName("orientation")
        private String orientation;
        @SerializedName("newNumber")
        private String newNumber;
        @SerializedName("userImages")
        private List<UserImages> userImages;

        /**
         * @return id
         */
        public String get_id() {
            return id;
        }

        /**
         * @param nId sets
         */
        public void set_id(final String nId) {
            this.id = nId;
        }

        /**
         * @return createdat
         */
        public String getCreatedAt() {
            return createdAt;
        }

        /**
         * @param createdAt sets
         */
        public void setCreatedAt(final String createdAt) {
            this.createdAt = createdAt;
        }

        /**
         * @return updated at
         */
        public String getUpdatedAt() {
            return updatedAt;
        }

        /**
         * @param updatedAt sets
         */
        public void setUpdatedAt(final String updatedAt) {
            this.updatedAt = updatedAt;
        }

        /**
         * @return dob
         */
        public String getDob() {
            return dob;
        }

        /**
         * @param dob sets
         */
        public void setDob(final String dob) {
            this.dob = dob;
        }

        /**
         * @return countrycode
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * @param countryCode sets
         */
        public void setCountryCode(final String countryCode) {
            this.countryCode = countryCode;
        }

        /**
         * @return phone
         */
        public String getPhoneNo() {
            return phoneNo;
        }

        /**
         * @param phoneNo sets
         */
        public void setPhoneNo(final String phoneNo) {
            this.phoneNo = phoneNo;
        }

        /**
         * @return email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email sets
         */
        public void setEmail(final String email) {
            this.email = email;
        }

        /**
         * @return orientation sex type
         */
        public String getOrientation() {
            return orientation;
        }

        /**
         * @param orientation sets
         */
        public void setOrientation(final String orientation) {
            this.orientation = orientation;
        }

        /**
         * @return number
         */
        public String getNewNumber() {
            return newNumber;
        }

        /**
         * @param newNumber sets
         */
        public void setNewNumber(final String newNumber) {
            this.newNumber = newNumber;
        }

        /**
         * @return userimage
         */
        public List<UserImages> getUserImages() {
            return userImages;
        }

        /**
         * @param userImages sets
         */
        public void setUserImages(final List<UserImages> userImages) {
            this.userImages = userImages;
        }
    }

    /**
     * inner class data
     */
    public static class Data {
        @SerializedName("accessToken")
        private String accessToken;
        @SerializedName("userDetails")
        private UserDetails userDetails;

        /**
         * @return token
         */
        public String getAccessToken() {
            return accessToken;
        }

        /**
         * @param accessToken sets
         */
        public void setAccessToken(final String accessToken) {
            this.accessToken = accessToken;
        }

        /**
         * @return userdetails
         */
        public UserDetails getUserDetails() {
            return userDetails;
        }

        /**
         * @param userDetails sets
         */
        public void setUserDetails(final UserDetails userDetails) {
            this.userDetails = userDetails;
        }
    }
}
