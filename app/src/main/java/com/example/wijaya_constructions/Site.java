package com.example.wijaya_constructions;

import android.widget.TextView;

public class Site {

    private String sitename;
    private String siteid;
    private String handover;
    private String handOut;
    private String cost;

    public Site(String sitename, String siteid, String handover, String handOut, String cost) {
        this.sitename = sitename;
        this.siteid = siteid;
        this.handover = handover;
        this.handOut = handOut;
        this.cost = cost;
    }

    public Site() {

        this.sitename = "";
        this.siteid = "";
        this.handover = "";
        this.handOut = "";
        this.cost = "";
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getHandover() {
        return handover;
    }

    public void setHandover(String handover) {
        this.handover = handover;
    }

    public String getHandOut() {
        return handOut;
    }

    public void setHandOut(String handOut) {
        this.handOut = handOut;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
