package com.training.micro.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationProp {

    private String              language;
    private int                 port;
    private List<String>        names;
    private Map<String, String> nameMap;
    private AppDetails          appDetails;

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(final List<String> namesParam) {
        this.names = namesParam;
    }


    public Map<String, String> getNameMap() {
        return this.nameMap;
    }


    public void setNameMap(final Map<String, String> nameMapParam) {
        this.nameMap = nameMapParam;
    }


    public AppDetails getAppDetails() {
        return this.appDetails;
    }


    public void setAppDetails(final AppDetails appDetailsParam) {
        this.appDetails = appDetailsParam;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String languageParam) {
        this.language = languageParam;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(final int portParam) {
        this.port = portParam;
    }
}
