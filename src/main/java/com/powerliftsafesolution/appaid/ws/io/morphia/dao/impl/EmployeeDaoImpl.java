package com.powerliftsafesolution.appaid.ws.io.morphia.dao.impl;

import com.powerliftsafesolution.appaid.ws.io.IOUtils;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.EmployeeDao;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends BasicDAO<EmployeeEntity, ObjectId> implements EmployeeDao {

    @Autowired
    private IOUtils ioUtils;

    @Autowired
    public EmployeeDaoImpl(Datastore datastore){
        super(EmployeeEntity.class, datastore);
    }

    @Override
    public EmployeeDto getByEmail(String email) {
        EmployeeDto employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("email").equal(email);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDto();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public EmployeeDto getByEmployeeId(int employeeId) {
        EmployeeDto employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("employeeId").equal(employeeId);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDto();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public List<EmployeeDto> getByFirstName(String firstName) {
        List<EmployeeDto> employeeDtos = null;

        Query<EmployeeEntity> query = createQuery().field("firstName").equal(firstName);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDtos = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getByLastName(String lastName) {
        List<EmployeeDto> employeeDtos = null;

        Query<EmployeeEntity> query = createQuery().field("lastName").equal(lastName);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDtos = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getByRole(String role) {
        List<EmployeeDto> employeeDtos = null;

        Query<EmployeeEntity> query = createQuery().field("role").equal(role);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDtos = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getByJobTitle(String jobTitle) {
        List<EmployeeDto> employeeDtos = null;

        Query<EmployeeEntity> query = createQuery().field("jobTitle").equal(jobTitle);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDtos = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDtos;
    }
}
