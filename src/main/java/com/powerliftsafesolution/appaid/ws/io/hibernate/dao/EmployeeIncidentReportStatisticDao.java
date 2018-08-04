package com.powerliftsafesolution.appaid.ws.io.hibernate.dao;

import com.powerliftsafesolution.appaid.ws.io.hibernate.entity.EmployeeIncidentReportStatisticEntity;

import java.sql.Date;
import java.util.Map;

public interface EmployeeIncidentReportStatisticDao {

    String save(EmployeeIncidentReportStatisticEntity employeeIncidentReportStatisticEntity);
    void update(String id, EmployeeIncidentReportStatisticEntity employeeIncidentReportStatisticEntity);
    void delete(String id);
    Map<String, Integer> getSumInjuryByCategoryAndDate();
}
