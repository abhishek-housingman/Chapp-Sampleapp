package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abhishek on 31/12/16.
 */

public class Data {

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("organization_name")
    private String organizationName;

    @SerializedName("designation")
    @Expose
    private Object designation;
    @SerializedName("work_type")
    @Expose
    private String workType;
    @SerializedName("address_one")
    @Expose
    private String addressOne;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("authentication_token")
    @Expose
    private String authenticationToken;
    @SerializedName("locality_info")
    @Expose
    private LocalityInfo localityInfo;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("builder_info")
    @Expose
    private BuilderInfo builderInfo;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("channel_partner_user_localities")
    @Expose
    private List<Object> channelPartnerUserLocalities = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Object getDesignation() {
        return designation;
    }

    public void setDesignation(Object designation) {
        this.designation = designation;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public LocalityInfo getLocalityInfo() {
        return localityInfo;
    }

    public void setLocalityInfo(LocalityInfo localityInfo) {
        this.localityInfo = localityInfo;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BuilderInfo getBuilderInfo() {
        return builderInfo;
    }

    public void setBuilderInfo(BuilderInfo builderInfo) {
        this.builderInfo = builderInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Object> getChannelPartnerUserLocalities() {
        return channelPartnerUserLocalities;
    }

    public void setChannelPartnerUserLocalities(List<Object> channelPartnerUserLocalities) {
        this.channelPartnerUserLocalities = channelPartnerUserLocalities;
    }

}
