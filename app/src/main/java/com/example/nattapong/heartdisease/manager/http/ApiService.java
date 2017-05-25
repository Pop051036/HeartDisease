package com.example.nattapong.heartdisease.manager.http;

import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.dao.CommentInsertDao;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;
import com.example.nattapong.heartdisease.dao.UserDataLoginCollectionDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nattapong on 8/1/2560.
 */

public interface ApiService {

    /**
     * FOR USERS
     */

    ////////////////////// POST/////////////////////////////////
    @FormUrlEncoded
    @POST("user/create")
    Call<UserDataLoginCollectionDao> registerUser(@Field("name") String name,
                                                  @Field("email") String email,
                                                  @Field("password") String password);

    @FormUrlEncoded
    @POST("user/login")
    Call<UserDataLoginCollectionDao> loginUser(@Field("email") String email,
                                               @Field("password") String password);

    @FormUrlEncoded
    @POST("user/comment")
    Call<CommentCollDataDao> commentuser(@Field("comment_user_name") String commentUserName,
                                       @Field("comment_user_text") String commentUserText);

    @GET("user/get/comment")
    Call<CommentCollDataDao> loadComment();

    @GET("user/get/map")
    Call<MapHospitalDataCollection> loadMapHospital();

    @FormUrlEncoded
    @POST("user/comment")
    Call<CommentCollDataDao> commentadmin (@Field("comment_id") int commentId,
                                        @Field("comment_admin_id") int commentAdminId,
                                        @Field("comment_admin_text") String commentAdminText);
}
