package com.powerliftsafesolution.appaid.ws.io.morphia.dao;

import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

import java.util.List;

public interface EmployeeDao extends DAO<EmployeeEntity, ObjectId> {


    EmployeeDto getByEmail(String email);

    EmployeeDto getByEmployeeId(int employeeId);

    List<EmployeeDto> getByFirstName(String firstName);

    List<EmployeeDto> getByLastName(String lastName);

    List<EmployeeDto> getByRole(String role);

    List<EmployeeDto> getByJobTitle(String jobTitle);
}
