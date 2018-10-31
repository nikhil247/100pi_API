package com.firebase.nikhilmanali.a100pi_api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Manali on 10/31/2018.
 */

public class Result {

    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("CurrencyLong")
    @Expose
    private String currencyLong;
    @SerializedName("MinConfirmation")
    @Expose
    private Integer minConfirmation;
    @SerializedName("TxFee")
    @Expose
    private Double txFee;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsRestricted")
    @Expose
    private Boolean isRestricted;
    @SerializedName("CoinType")
    @Expose
    private String coinType;
    @SerializedName("BaseAddress")
    @Expose
    private String baseAddress;
    @SerializedName("Notice")
    @Expose
    private Object notice;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyLong() {
        return currencyLong;
    }

    public void setCurrencyLong(String currencyLong) {
        this.currencyLong = currencyLong;
    }

    public Integer getMinConfirmation() {
        return minConfirmation;
    }

    public void setMinConfirmation(Integer minConfirmation) {
        this.minConfirmation = minConfirmation;
    }

    public Double getTxFee() {
        return txFee;
    }

    public void setTxFee(Double txFee) {
        this.txFee = txFee;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsRestricted() {
        return isRestricted;
    }

    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }
}
