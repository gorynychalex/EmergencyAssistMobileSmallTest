package ru.popovich.emergencyassistmobile.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskSocialServiceIds {

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("sid")
    private Long sid;

    public TaskSocialServiceIds() {
    }

    public TaskSocialServiceIds(String uid, Long sid) {
        this.uid = uid;
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
