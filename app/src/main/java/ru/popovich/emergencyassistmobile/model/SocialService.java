package ru.popovich.emergencyassistmobile.model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//import javax.persistence.*;
//import java.time.Duration;
//import java.time.LocalDateTime;
import java.util.Date;

public class SocialService {

    private Long id;

    private String title;

    private String description;

    private float cost;

    private float cityprice;

    private float countryprice;

    private String duration; //SLA duration, plan

    private boolean oneTime;

    private int periods;

    private boolean enable = true;

//    @ManyToOne
//    @JoinColumn
//    private SocialServiceCatalog socialServiceCatalog;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonIgnore
    private Date dateCreation;

//    @JsonIgnore
    private Date dateEnable;

    public SocialService() {}

    public SocialService(String title, float cost) {
        this.title = title;
        this.cost = cost;
        this.dateCreation = new Date();
    }

    public SocialService(String title, float cityprice, float countryprice) {
        this.title = title;
        this.cityprice = cityprice;
        this.countryprice = countryprice;
        this.dateCreation = new Date();
    }

    public SocialService(String title, float cost, int periods){
        this(title, cost);
        this.periods = periods;
    }

    public SocialService(Long id, String title, float cost){
        this(title, cost);
        this.id = id;
    }

    @Override
    public String toString() {
        return this.title + " " + this.countryprice + " " + this.cityprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isOneTime() {
        return oneTime;
    }

    public void setOneTime(boolean oneTime) {
        this.oneTime = oneTime;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEnable() {
        return dateEnable;
    }

    public void setDateEnable(Date dateEnable) {
        this.dateEnable = dateEnable;
    }

    public float getCityprice() {
        return cityprice;
    }

    public void setCityprice(float cityprice) {
        this.cityprice = cityprice;
    }

    public float getCountryprice() {
        return countryprice;
    }

    public void setCountryprice(float countryprice) {
        this.countryprice = countryprice;
    }

//    public SocialServiceCatalog getSocialServiceCatalog() {
//        return socialServiceCatalog;
//    }
//
//    public void setSocialServiceCatalog(SocialServiceCatalog socialServiceCatalog) {
//        this.socialServiceCatalog = socialServiceCatalog;
//    }
}
