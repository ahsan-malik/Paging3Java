package com.ahsanmalik.paging3java.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("reputation")
    @Expose
    private Integer reputation;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param displayName
     * @param link
     * @param reputation
     * @param userType
     * @param profileImage
     * @param userId
     */
    public Owner(Integer reputation, Integer userId, String userType, String profileImage, String displayName, String link) {
        super();
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
        this.profileImage = profileImage;
        this.displayName = displayName;
        this.link = link;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.link == null)? 0 :this.link.hashCode()));
        result = ((result* 31)+((this.reputation == null)? 0 :this.reputation.hashCode()));
        result = ((result* 31)+((this.userType == null)? 0 :this.userType.hashCode()));
        result = ((result* 31)+((this.profileImage == null)? 0 :this.profileImage.hashCode()));
        result = ((result* 31)+((this.userId == null)? 0 :this.userId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Owner) == false) {
            return false;
        }
        Owner rhs = ((Owner) other);
        return (((((((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName)))&&((this.link == rhs.link)||((this.link!= null)&&this.link.equals(rhs.link))))&&((this.reputation == rhs.reputation)||((this.reputation!= null)&&this.reputation.equals(rhs.reputation))))&&((this.userType == rhs.userType)||((this.userType!= null)&&this.userType.equals(rhs.userType))))&&((this.profileImage == rhs.profileImage)||((this.profileImage!= null)&&this.profileImage.equals(rhs.profileImage))))&&((this.userId == rhs.userId)||((this.userId!= null)&&this.userId.equals(rhs.userId))));
    }
}
