package com.powerliftsafesolution.appaid.ws.services;

import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDto;

public interface EmployeeIncidentReportService {

    EmployeeIncidentReportDto saveReport(EmployeeIncidentReportDto employeeIncidentReportDTO);
    EmployeeIncidentReportDto getReportByNameDateTime(String employeeFirstName, String employeeLastName,
                                                      String date, String time);

}
