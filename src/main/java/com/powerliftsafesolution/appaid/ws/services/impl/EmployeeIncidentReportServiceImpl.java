package com.powerliftsafesolution.appaid.ws.services.impl;

import com.powerliftsafesolution.appaid.ws.exceptions.NoRecordFoundException;
import com.powerliftsafesolution.appaid.ws.io.hibernate.dao.EmployeeIncidentReportStatisticDao;
import com.powerliftsafesolution.appaid.ws.io.hibernate.entity.EmployeeIncidentReportStatisticEntity;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.EmployeeIncidentReportDao;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeIncidentReportEntity;
import com.powerliftsafesolution.appaid.ws.services.EmployeeIncidentReportService;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDto;
import com.powerliftsafesolution.appaid.ws.ui.models.response.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.sql.Time;


@Service
@Transactional(readOnly = true)
public class EmployeeIncidentReportServiceImpl implements EmployeeIncidentReportService {

    @Autowired
    private EmployeeIncidentReportDao employeeIncidentReportDAO;

    @Autowired
    private EmployeeIncidentReportStatisticDao employeeIncidentReportStatisticDAO;

    public EmployeeIncidentReportServiceImpl(){
    }

    @Override
    @Transactional
    public EmployeeIncidentReportDto saveReport(EmployeeIncidentReportDto employeeIncidentReportDTO) {

        EmployeeIncidentReportEntity newReport = new EmployeeIncidentReportEntity();
        BeanUtils.copyProperties(employeeIncidentReportDTO, newReport);

        employeeIncidentReportDAO.save(newReport);
        EmployeeIncidentReportDto returnValue = new EmployeeIncidentReportDto();

        EmployeeIncidentReportStatisticEntity newStatistic = new EmployeeIncidentReportStatisticEntity();
        BeanUtils.copyProperties(newReport, newStatistic);
        newStatistic.setDate(Date.valueOf(newReport.getDate()));
        newStatistic.setTime(Time.valueOf(newReport.getTime()));

        employeeIncidentReportStatisticDAO.save(newStatistic);

        BeanUtils.copyProperties(newReport, returnValue);

        return returnValue;
    }

    @Override
    public EmployeeIncidentReportDto getReportByNameDateTime(String employeeFirstName, String employeeLastName,
                                                             String date, String time) {
        EmployeeIncidentReportDto returnValue =
                employeeIncidentReportDAO.getByNameDateTime(employeeFirstName, employeeLastName, date, time);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return  returnValue;

    }
}
