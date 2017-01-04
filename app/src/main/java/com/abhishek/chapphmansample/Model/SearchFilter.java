package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abhishek on 03/01/17.
 */

public class SearchFilter {

    @SerializedName("price_range_any")
    @Expose
    private List<String> priceRangeAny = null;
    @SerializedName("bhk_range_any")
    @Expose
    private List<String> bhkRangeAny = null;

    public List<String> getPriceRangeAny() {
        return priceRangeAny;
    }

    public void setPriceRangeAny(List<String> priceRangeAny) {
        this.priceRangeAny = priceRangeAny;
    }

    public List<String> getBhkRangeAny() {
        return bhkRangeAny;
    }

    public void setBhkRangeAny(List<String> bhkRangeAny) {
        this.bhkRangeAny = bhkRangeAny;
    }

}
