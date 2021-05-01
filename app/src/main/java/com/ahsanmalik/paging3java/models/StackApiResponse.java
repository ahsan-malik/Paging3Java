package com.ahsanmalik.paging3java.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StackApiResponse {
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("backoff")
    @Expose
    private Integer backoff;
    @SerializedName("quota_max")
    @Expose
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Integer quotaRemaining;

    /**
     * No args constructor for use in serialization
     *
     */
    public StackApiResponse() {
    }

    /**
     *
     * @param quotaRemaining
     * @param backoff
     * @param hasMore
     * @param quotaMax
     * @param items
     */
    public StackApiResponse(List<Item> items, Boolean hasMore, Integer backoff, Integer quotaMax, Integer quotaRemaining) {
        super();
        this.items = items;
        this.hasMore = hasMore;
        this.backoff = backoff;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getBackoff() {
        return backoff;
    }

    public void setBackoff(Integer backoff) {
        this.backoff = backoff;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.hasMore == null)? 0 :this.hasMore.hashCode()));
        result = ((result* 31)+((this.quotaRemaining == null)? 0 :this.quotaRemaining.hashCode()));
        result = ((result* 31)+((this.quotaMax == null)? 0 :this.quotaMax.hashCode()));
        result = ((result* 31)+((this.items == null)? 0 :this.items.hashCode()));
        result = ((result* 31)+((this.backoff == null)? 0 :this.backoff.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StackApiResponse) == false) {
            return false;
        }
        StackApiResponse rhs = ((StackApiResponse) other);
        return ((((((this.hasMore == rhs.hasMore)||((this.hasMore!= null)&&this.hasMore.equals(rhs.hasMore)))&&((this.quotaRemaining == rhs.quotaRemaining)||((this.quotaRemaining!= null)&&this.quotaRemaining.equals(rhs.quotaRemaining))))&&((this.quotaMax == rhs.quotaMax)||((this.quotaMax!= null)&&this.quotaMax.equals(rhs.quotaMax))))&&((this.items == rhs.items)||((this.items!= null)&&this.items.equals(rhs.items))))&&((this.backoff == rhs.backoff)||((this.backoff!= null)&&this.backoff.equals(rhs.backoff))));
    }
}
