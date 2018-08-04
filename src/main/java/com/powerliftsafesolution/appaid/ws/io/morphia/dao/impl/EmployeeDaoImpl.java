package com.powerliftsafesolution.appaid.ws.io.morphia.dao.impl;

import com.powerliftsafesolution.appaid.ws.io.IOUtils;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.UserDAO;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDTO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends BasicDAO<EmployeeEntity, ObjectId> implements UserDAO {

    @Autowired
    private IOUtils ioUtils;

    @Autowired
    public UserDAOImpl(Datastore datastore){
        super(EmployeeEntity.class, datastore);
    }

    @Override
    public EmployeeDTO getByUserName(String userName) {
        EmployeeDTO employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("userName").equal(userName);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public EmployeeDTO getByEmail(String email) {
        EmployeeDTO employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("email").equal(email);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public EmployeeDTO getByUserId(String userID) {
        EmployeeDTO employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("userId").equal(userID);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public EmployeeDTO getByEmployeeId(int employeeId) {
        EmployeeDTO employeeDTO = null;

        Query<EmployeeEntity> query = createQuery().field("employeeId").equal(employeeId);
        EmployeeEntity employeeEntity = query.get();

        if(employeeEntity != null){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getByFirstName(String firstName) {
        List<EmployeeDTO> employeeDTOS = null;

        Query<EmployeeEntity> query = createQuery().field("firstName").equal(firstName);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDTOS = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> getByLastName(String lastName) {
        List<EmployeeDTO> employeeDTOS = null;

        Query<EmployeeEntity> query = createQuery().field("lastName").equal(lastName);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDTOS = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> getByRole(String role) {
        List<EmployeeDTO> employeeDTOS = null;

        Query<EmployeeEntity> query = createQuery().field("role").equal(role);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDTOS = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> getByJobTitle(String jobTitle) {
        List<EmployeeDTO> employeeDTOS = null;

        Query<EmployeeEntity> query = createQuery().field("jobTitle").equal(jobTitle);
        List<EmployeeEntity> userEntities = query.asList();

        if(userEntities != null){
            employeeDTOS = ioUtils.copyToUserDTOList(userEntities);
        }
        return employeeDTOS;
    }
}
