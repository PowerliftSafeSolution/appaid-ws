package com.powerliftsafesolution.appaid.ws.ui.models.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeIncidentSubmitRequestModel {

    private String typeOfIncident;
    private String employeeFirstName;
    private String employeeLastName;
    private int employeeId;
    private String jobTitle;
    private String supervisorName;
    private boolean isIncidentReported;
    private String date;
    private String time;
    private String[] witnesses;
    private String locationGeneral;
    private String locationDetailedDescription;
    private String leadUpToInjury;
    private String possiblePreventions;
    private String detailDescriptionOfInjury;
    private boolean injuryAbdomen;
    private boolean injuryLowerback;
    private boolean injuryLumbar;
    private boolean injuryPelvis;
    private boolean injuryHead;
    private boolean injuryAnkle;
    private boolean injuryFoot;
    private boolean injuryChest;
    private boolean injuryHip;
    private boolean injuryThigh;
    private boolean injuryKnee;
    private boolean injuryLowerleg;
    private boolean injuryNeck;
    private boolean injuryShoulder;
    private boolean injuryUpperarm;
    private boolean injuryWrist;
    private boolean injuryHand;
    private boolean forkliftInvolved;
    private String forkliftOperatorFirstName;
    private String forkliftOperatorLastName;
    private int forkliftOperatorEmployeeId;
    private String possibleInjury;
    private boolean doctorVisit;
    private String doctorName;
    private String doctorPhoneNumber;
    private String dateOfVisit;
    private String timeOfVisit;
    private boolean injuryLocationOnBodyMoreThanOnce;
    private String dateOfPreviousInjury;
    private String nameOfPreviousSupervisorForPreviousInjury;

    public String getTypeOfIncident() {
        return typeOfIncident;
    }

    public void setTypeOfIncident(String typeOfIncident) {
        this.typeOfIncident = typeOfIncident;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public boolean isIncidentReported() {
        return isIncidentReported;
    }

    public void setIncidentReported(boolean incidentReported) {
        isIncidentReported = incidentReported;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String[] witnesses) {
        this.witnesses = witnesses;
    }

    public String getLocationGeneral() {
        return locationGeneral;
    }

    public void setLocationGeneral(String locationGeneral) {
        this.locationGeneral = locationGeneral;
    }

    public String getLocationDetailedDescription() {
        return locationDetailedDescription;
    }

    public void setLocationDetailedDescription(String locationDetailedDescription) {
        this.locationDetailedDescription = locationDetailedDescription;
    }

    public String getLeadUpToInjury() {
        return leadUpToInjury;
    }

    public void setLeadUpToInjury(String leadUpToInjury) {
        this.leadUpToInjury = leadUpToInjury;
    }

    public String getPossiblePreventions() {
        return possiblePreventions;
    }

    public void setPossiblePreventions(String possiblePreventions) {
        this.possiblePreventions = possiblePreventions;
    }

    public String getDetailDescriptionOfInjury() {
        return detailDescriptionOfInjury;
    }

    public void setDetailDescriptionOfInjury(String detailDescriptionOfInjury) {
        this.detailDescriptionOfInjury = detailDescriptionOfInjury;
    }

    public String getPossibleInjury() {
        return possibleInjury;
    }

    public void setPossibleInjury(String possibleInjury) {
        this.possibleInjury = possibleInjury;
    }

    public boolean isDoctorVisit() {
        return doctorVisit;
    }

    public void setDoctorVisit(boolean doctorVisit) {
        this.doctorVisit = doctorVisit;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getTimeOfVisit() {
        return timeOfVisit;
    }

    public void setTimeOfVisit(String timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }

    public boolean isInjuryLocationOnBodyMoreThanOnce() {
        return injuryLocationOnBodyMoreThanOnce;
    }

    public void setInjuryLocationOnBodyMoreThanOnce(boolean injuryLocationOnBodyMoreThanOnce) {
        this.injuryLocationOnBodyMoreThanOnce = injuryLocationOnBodyMoreThanOnce;
    }

    public String getDateOfPreviousInjury() {
        return dateOfPreviousInjury;
    }

    public void setDateOfPreviousInjury(String dateOfPreviousInjury) {
        this.dateOfPreviousInjury = dateOfPreviousInjury;
    }

    public String getNameOfPreviousSupervisorForPreviousInjury() {
        return nameOfPreviousSupervisorForPreviousInjury;
    }

    public void setNameOfPreviousSupervisorForPreviousInjury(String nameOfPreviousSupervisorForPreviousInjury) {
        this.nameOfPreviousSupervisorForPreviousInjury = nameOfPreviousSupervisorForPreviousInjury;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public boolean isForkliftInvolved() {
        return forkliftInvolved;
    }

    public void setForkliftInvolved(boolean forkliftInvolved) {
        this.forkliftInvolved = forkliftInvolved;
    }

    public String getForkliftOperatorFirstName() {
        return forkliftOperatorFirstName;
    }

    public void setForkliftOperatorFirstName(String forkliftOperatorFirstName) {
        this.forkliftOperatorFirstName = forkliftOperatorFirstName;
    }

    public String getForkliftOperatorLastName() {
        return forkliftOperatorLastName;
    }

    public void setForkliftOperatorLastName(String forkliftOperatorLastName) {
        this.forkliftOperatorLastName = forkliftOperatorLastName;
    }

    public int getForkliftOperatorEmployeeId() {
        return forkliftOperatorEmployeeId;
    }

    public void setForkliftOperatorEmployeeId(int forkliftOperatorEmployeeId) {
        this.forkliftOperatorEmployeeId = forkliftOperatorEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
