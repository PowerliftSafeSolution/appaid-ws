package com.powerliftsafesolution.appaid.ws.services.impl;

import com.powerliftsafesolution.appaid.ws.exceptions.NoRecordFoundException;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.EmployeeIncidentReportDAO;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeIncidentReportEntity;
import com.powerliftsafesolution.appaid.ws.services.EmployeeIncidentReportService;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.response.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeIncidentReportServiceImpl implements EmployeeIncidentReportService {

    @Autowired
    private EmployeeIncidentReportDAO employeeIncidentReportDAO;

    public EmployeeIncidentReportServiceImpl(){
    }

    @Override
    public EmployeeIncidentReportDTO saveReport(EmployeeIncidentReportDTO employeeIncidentReportDTO) {

        EmployeeIncidentReportEntity newReport = new EmployeeIncidentReportEntity();
        BeanUtils.copyProperties(employeeIncidentReportDTO, newReport);

        employeeIncidentReportDAO.save(newReport);
        EmployeeIncidentReportDTO returnValue = new EmployeeIncidentReportDTO();

        BeanUtils.copyProperties(newReport, returnValue);

        return returnValue;
    }

    @Override
    public EmployeeIncidentReportDTO getReportByNameDateTime(String employeeFirstName, String employeeLastName,
                                                             String date, String time) {
        EmployeeIncidentReportDTO returnValue =
                employeeIncidentReportDAO.getByNameDateTime(employeeFirstName, employeeLastName, date, time);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return  returnValue;

    }
}
