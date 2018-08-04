package com.powerliftsafesolution.appaid.ws.io.morphia.dao.impl;

import com.powerliftsafesolution.appaid.ws.io.IOUtils;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.EmployeeIncidentReportDao;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeIncidentReportEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDto;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeIncidentReportDaoImpl extends
        BasicDAO<EmployeeIncidentReportEntity, ObjectId> implements EmployeeIncidentReportDao {

    @Autowired
    private IOUtils ioUtils;

    @Autowired
    public EmployeeIncidentReportDaoImpl(Datastore datastore){
        super(EmployeeIncidentReportEntity.class, datastore);
    }

    @Override
    public EmployeeIncidentReportDto getByNameDateTime(String employeeFirstName, String employeeLastName,
                                                       String date, String time) {
        EmployeeIncidentReportDto returnValue = null;

        Query<EmployeeIncidentReportEntity> query = createQuery().
                field("employeeFirstName").equal(employeeFirstName).
                field("employeeLastName").equal(employeeLastName).
                field("date").equal(date).field("time").equal(time);

        EmployeeIncidentReportEntity employeeIncidentReportEntity = query.get();

        if(employeeIncidentReportEntity != null){
            returnValue = new EmployeeIncidentReportDto();
            BeanUtils.copyProperties(employeeIncidentReportEntity, returnValue);
        }

        return returnValue;
    }
}
