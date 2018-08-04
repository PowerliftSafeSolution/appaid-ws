package com.powerliftsafesolution.appaid.ws.io.morphia.dao;

import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeIncidentReportEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDto;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface EmployeeIncidentReportDao extends DAO<EmployeeIncidentReportEntity, ObjectId> {

    EmployeeIncidentReportDto getByNameDateTime(String employeeFirstName, String employeeLastName, String date, String time);
}
