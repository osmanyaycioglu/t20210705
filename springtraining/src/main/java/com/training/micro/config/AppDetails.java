package com.training.micro.config;

import java.util.List;

public class AppDetails {

    private String       desc;
    private String       shortDesc;
    private List<String> subApps;

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public void setShortDesc(final String shortDescParam) {
        this.shortDesc = shortDescParam;
    }

    public List<String> getSubApps() {
        return this.subApps;
    }

    public void setSubApps(final List<String> subAppsParam) {
        this.subApps = subAppsParam;
    }


}
