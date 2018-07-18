package com.powerliftsafesolution.appaid.ws.io.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "incident_report")
public class EmployeeIncidentReportStatisticEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type_incident")
    private String typeIncident;

    @Column(name = "date_incident")
    private Date date;

    @Column(name = "time_incident")
    private Time time;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "injury_abdomen_lowerback_lumbarspine_pelvis")
    private boolean injuryAbdomenLowerbackLumbarPelvis;

    @Column(name = "injury_head")
    private boolean injuryHead;

    @Column(name = "injury_ankle_foot")
    private boolean injuryAnkleFoot;

    @Column(name = "injury_chest")
    private boolean injuryChest;

    @Column(name = "injury_hip_thigh")
    private boolean injuryHipThigh;

    @Column(name = "injury_knee_lowerleg")
    private boolean injuryKneeLowerleg;

    @Column(name = "injury_neck")
    private boolean injuryNeck;

    @Column(name = "injury_shoulder_upperarm")
    private boolean injuryShoulderUpperarm;

    @Column(name = "injury_wrist_hand")
    private boolean injuryWristHand;

    @Column(name = "forklift_involved")
    private boolean forkliftInvolved;

    @Column(name = "forklift_operator_first_name")
    private String forkliftOperatorFirstName;

    @Column(name = "forklift_operator_last_name")
    private String forkliftOperatorLastName;

    @Column(name = "forklift_operator_employee_id")
    private int forkliftOperatorEmployeeId;

    @Column(name = "injury_location_general")
    private String locationGeneral;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeIncident() {
        return typeIncident;
    }

    public void setTypeIncident(String typeIncident) {
        this.typeIncident = typeIncident;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public boolean isInjuryAbdomenLowerbackLumbarPelvis() {
        return injuryAbdomenLowerbackLumbarPelvis;
    }

    public void setInjuryAbdomenLowerbackLumbarPelvis(boolean injuryAbdomenLowerbackLumbarPelvis) {
        this.injuryAbdomenLowerbackLumbarPelvis = injuryAbdomenLowerbackLumbarPelvis;
    }

    public boolean isInjuryHead() {
        return injuryHead;
    }

    public void setInjuryHead(boolean injuryHead) {
        this.injuryHead = injuryHead;
    }

    public boolean isInjuryAnkleFoot() {
        return injuryAnkleFoot;
    }

    public void setInjuryAnkleFoot(boolean injuryAnkleFoot) {
        this.injuryAnkleFoot = injuryAnkleFoot;
    }

    public boolean isInjuryChest() {
        return injuryChest;
    }

    public void setInjuryChest(boolean injuryChest) {
        this.injuryChest = injuryChest;
    }

    public boolean isInjuryHipThigh() {
        return injuryHipThigh;
    }

    public void setInjuryHipThigh(boolean injuryHipThigh) {
        this.injuryHipThigh = injuryHipThigh;
    }

    public boolean isInjuryKneeLowerleg() {
        return injuryKneeLowerleg;
    }

    public void setInjuryKneeLowerleg(boolean injuryKneeLowerleg) {
        this.injuryKneeLowerleg = injuryKneeLowerleg;
    }

    public boolean isInjuryNeck() {
        return injuryNeck;
    }

    public void setInjuryNeck(boolean injuryNeck) {
        this.injuryNeck = injuryNeck;
    }

    public boolean isInjuryShoulderUpperarm() {
        return injuryShoulderUpperarm;
    }

    public void setInjuryShoulderUpperarm(boolean injuryShoulderUpperarm) {
        this.injuryShoulderUpperarm = injuryShoulderUpperarm;
    }

    public boolean isInjuryWristHand() {
        return injuryWristHand;
    }

    public void setInjuryWristHand(boolean injuryWristHand) {
        this.injuryWristHand = injuryWristHand;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getForkliftOperatorEmployeeId() {
        return forkliftOperatorEmployeeId;
    }

    public void setForkliftOperatorEmployeeId(int forkliftOperatorEmployeeId) {
        this.forkliftOperatorEmployeeId = forkliftOperatorEmployeeId;
    }

    public String getLocationGeneral() {
        return locationGeneral;
    }

    public void setLocationGeneral(String locationGeneral) {
        this.locationGeneral = locationGeneral;
    }
}
