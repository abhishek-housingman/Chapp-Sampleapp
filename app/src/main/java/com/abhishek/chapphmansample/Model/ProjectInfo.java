package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abhishek on 03/01/17.
 */

public class ProjectInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("project_name")
    @Expose
    private String projectName;
    @SerializedName("builder_name")
    @Expose
    private String builderName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("starting_price")
    @Expose
    private Double startingPrice;
    @SerializedName("bhks")
    @Expose
    private List<String> bhks = null;
    @SerializedName("project_image")
    @Expose
    private String projectImage;
    @SerializedName("builder_logo")
    @Expose
    private String builderLogo;
    @SerializedName("deals_count")
    @Expose
    private Integer dealsCount;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public List<String> getBhks() {
        return bhks;
    }

    public void setBhks(List<String> bhks) {
        this.bhks = bhks;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public String getBuilderLogo() {
        return builderLogo;
    }

    public void setBuilderLogo(String builderLogo) {
        this.builderLogo = builderLogo;
    }

    public Integer getDealsCount() {
        return dealsCount;
    }

    public void setDealsCount(Integer dealsCount) {
        this.dealsCount = dealsCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
