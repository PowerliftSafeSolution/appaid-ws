package com.powerliftsafesolution.appaid.ws.ui.models.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SafetyRequestModel {

    private String fileName;
    private String givenFileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getGivenFileName() {
        return givenFileName;
    }

    public void setGivenFileName(String givenFileName) {
        this.givenFileName = givenFileName;
    }
}
