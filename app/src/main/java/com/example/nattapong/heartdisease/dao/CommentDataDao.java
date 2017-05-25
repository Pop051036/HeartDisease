package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nattapong on 12/1/2560.
 */

public class CommentDataDao {

    @SerializedName("comment_id")
    @Expose
    private Integer commentId;
    @SerializedName("comment_user_name")
    @Expose
    private String commentUserName;
    @SerializedName("comment_user_text")
    @Expose
    private String commentUserText;
    @SerializedName("comment_user_date")
    @Expose
    private String commentUserDate;
    @SerializedName("comment_admin_id")
    @Expose
    private String commentAdminId;
    @SerializedName("comment_admin_text")
    @Expose
    private String commentAdminText;
    @SerializedName("comment_admin_date")
    @Expose
    private String commentAdminDate;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentUserText() {
        return commentUserText;
    }

    public void setCommentUserText(String commentUserText) {
        this.commentUserText = commentUserText;
    }

    public String getCommentUserDate() {
        return commentUserDate;
    }

    public void setCommentUserDate(String commentUserDate) {
        this.commentUserDate = commentUserDate;
    }

    public String getCommentAdminId() {
        return commentAdminId;
    }

    public void setCommentAdminId(String commentAdminId) {
        this.commentAdminId = commentAdminId;
    }

    public String getCommentAdminText() {
        return commentAdminText;
    }

    public void setCommentAdminText(String commentAdminText) {
        this.commentAdminText = commentAdminText;
    }

    public String getCommentAdminDate() {
        return commentAdminDate;
    }

    public void setCommentAdminDate(String commentAdminDate) {
        this.commentAdminDate = commentAdminDate;
    }
}
