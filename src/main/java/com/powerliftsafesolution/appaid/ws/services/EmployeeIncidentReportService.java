package com.powerliftsafesolution.appaid.ws.services;

import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDTO;

public interface EmployeeIncidentReportService {

    EmployeeIncidentReportDTO saveReport(EmployeeIncidentReportDTO employeeIncidentReportDTO);
    EmployeeIncidentReportDTO getReportByNameDateTime(String employeeFirstName, String employeeLastName,
                                                      String date, String time);

}
