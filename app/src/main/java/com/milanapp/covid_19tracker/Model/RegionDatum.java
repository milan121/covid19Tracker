
package com.milanapp.covid_19tracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionDatum {



    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("totalInfected")
    @Expose
    private Integer totalInfected;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deceased")
    @Expose
    private Integer deceased;
    @SerializedName("totalCases")
    @Expose
    private Integer totalCases;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getTotalInfected() {
        return totalInfected;
    }

    public void setTotalInfected(Integer totalInfected) {
        this.totalInfected = totalInfected;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

}
