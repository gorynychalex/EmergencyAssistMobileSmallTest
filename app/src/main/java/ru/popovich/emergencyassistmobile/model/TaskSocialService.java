/*
 *
 *  Created by Dmitry Garmyshev on 8/3/19 12:20 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 7/29/19 10:44 AM
 *
 */

package ru.popovich.emergencyassistmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.Duration;
import java.util.Date;

public class TaskSocialService {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("socialService")
    @Expose
    private SocialService socialService;

    @SerializedName("needy")
    @Expose
    private User needy;

    @SerializedName("employee")
    @Expose
    private User employee;

    @Expose
    private Date dateCreate;

    @Expose
    private Date dateStart;

    @Expose
    private Date dateStop;

    private String duration;

    @SerializedName("enable")
    @Expose
    private boolean enable = true;

    private TaskStatus status;

    private Integer priority;

    public TaskSocialService() {}

    public TaskSocialService(SocialService socialService, User needy) {
        this.socialService = socialService;
        this.needy = needy;
//        this.dateCreate = new Date();
    }

    public TaskSocialService(Long id, SocialService socialService, User needy){
        this(socialService, needy);
        this.id = id;
    }

    public TaskSocialService(SocialService socialService, User needy, User employee) {
        this(socialService, needy);
        this.employee = employee;
    }

    public TaskSocialService(Long id, SocialService socialService, User needy, User employee){
        this(id, socialService, needy);
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SocialService getSocialService() {
        return socialService;
    }

    public void setSocialService(SocialService socialService) {
        this.socialService = socialService;
    }

    public User getNeedy() {
        return needy;
    }

    public void setNeedy(User needy) {
        this.needy = needy;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
