package com.powerliftsafesolution.appaid.ws.ui.models.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;

@XmlRootElement
public class SafetyResponseModel {

    private URL url;
    private String givenFileName;
    private String fileName;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getGivenFileName() {
        return givenFileName;
    }

    public void setGivenFileName(String givenFileName) {
        this.givenFileName = givenFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
