package com.ahsanmalik.paging3java.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean isAccepted;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("content_license")
    @Expose
    private String contentLicense;

    /**
     * No args constructor for use in serialization
     *
     */
    public Item() {
    }

    /**
     *
     * @param owner
     * @param answerId
     * @param score
     * @param questionId
     * @param lastActivityDate
     * @param contentLicense
     * @param isAccepted
     * @param creationDate
     */
    public Item(Owner owner, Boolean isAccepted, Integer score, Integer lastActivityDate, Integer creationDate, Integer answerId, Integer questionId, String contentLicense) {
        super();
        this.owner = owner;
        this.isAccepted = isAccepted;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.answerId = answerId;
        this.questionId = questionId;
        this.contentLicense = contentLicense;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContentLicense() {
        return contentLicense;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.owner == null)? 0 :this.owner.hashCode()));
        result = ((result* 31)+((this.answerId == null)? 0 :this.answerId.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.questionId == null)? 0 :this.questionId.hashCode()));
        result = ((result* 31)+((this.lastActivityDate == null)? 0 :this.lastActivityDate.hashCode()));
        result = ((result* 31)+((this.contentLicense == null)? 0 :this.contentLicense.hashCode()));
        result = ((result* 31)+((this.isAccepted == null)? 0 :this.isAccepted.hashCode()));
        result = ((result* 31)+((this.creationDate == null)? 0 :this.creationDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return (((((((((this.owner == rhs.owner)||((this.owner!= null)&&this.owner.equals(rhs.owner)))&&((this.answerId == rhs.answerId)||((this.answerId!= null)&&this.answerId.equals(rhs.answerId))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.questionId == rhs.questionId)||((this.questionId!= null)&&this.questionId.equals(rhs.questionId))))&&((this.lastActivityDate == rhs.lastActivityDate)||((this.lastActivityDate!= null)&&this.lastActivityDate.equals(rhs.lastActivityDate))))&&((this.contentLicense == rhs.contentLicense)||((this.contentLicense!= null)&&this.contentLicense.equals(rhs.contentLicense))))&&((this.isAccepted == rhs.isAccepted)||((this.isAccepted!= null)&&this.isAccepted.equals(rhs.isAccepted))))&&((this.creationDate == rhs.creationDate)||((this.creationDate!= null)&&this.creationDate.equals(rhs.creationDate))));
    }

}
