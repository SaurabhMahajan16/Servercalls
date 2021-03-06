package com.skeleton.retrofit;


import com.skeleton.model.UserData;
import com.skeleton.model.UserInfo;
import com.skeleton.model.UserPosts;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

import static com.skeleton.constant.ApiKeyConstant.AUTHORIZATION;

/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */
public interface ApiInterface {
    String UPDATE_LOCATION = "api/v1/user/updateLocation";
    String USERS = "users";
    String POST = "posts";
    String USER_SIGNUP = "api/user/register";
    String USER_LOGIN = "/api/user/login";

//    /**
//     * @param map
//     * @return
//     */
//    @Multipart
//    @POST("api/v1/user/createUser")
//    Call<LoginResponse> register(@PartMap HashMap<String, RequestBody> map);
//
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/socialLogin")
//    Call<LoginResponse> socialLogin(@FieldMap HashMap<String, String> map);
//
//    /**
//     * @param authorization
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginToken")
//    Call<LoginResponse> accessTokenLogin(@Header(AUTHORIZATION) String authorization,
//                                         @FieldMap HashMap<String, String> map);
//
//
//    /**
//     * @param email
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("api/v1/user/forgotpassword")
//    Call<CommonResponse> forgotPassword(@Field("email") String email);
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginCredential")
//    Call<LoginResponse> login(@FieldMap HashMap<String, String> map);


    /**
     * Update location call.
     *
     * @param authorization the authorization
     * @param map           the map
     * @return the call
     */
    @FormUrlEncoded
    @POST(UPDATE_LOCATION)
    Call<CommonParams> updateLocation(@Header(AUTHORIZATION) String authorization,
                                      @FieldMap HashMap<String, String> map);

    /**
     *
     * @return users list
     */
    @GET(USERS)
    Call<List<UserInfo>> getData();


    /**
     * @param id ram
     * @return post
     */
    @GET(POST)
    Call<List<UserPosts>> getUserposts(@Query("userId") int id);

    /**
     * @param map key value pair of parameters sending to respone
     * @return SignUpResponse
     */
    @Multipart
    @POST(USER_SIGNUP)
    Call<UserData> register(@PartMap HashMap<String, RequestBody> map);

    /**
     * @param authorization auth
     * @param map           email and password of the user
     * @return login details
     */
    @FormUrlEncoded
    @POST(USER_LOGIN)
    Call<UserData> login(@Header(AUTHORIZATION) String authorization,
                               @FieldMap HashMap<String, String> map);

}

