package com.powerliftsafesolution.appaid.ws.services.impl;

import com.powerliftsafesolution.appaid.ws.exceptions.NoRecordFoundException;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.EmployeeDao;
import com.powerliftsafesolution.appaid.ws.services.EmployeeService;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;
import com.powerliftsafesolution.appaid.ws.ui.models.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDAO;

    public UsersServiceImpl(){
    }

    @Override
    public EmployeeDto getEmployeeByEmployeeId(String userId) {

        EmployeeDto returnValue = this.employeeDAO.getByUserId(userId);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;

    }

    @Override
    public EmployeeDto getUserByUserName(String userName) {

        EmployeeDto returnValue = this.employeeDAO.getByUserName(userName);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public EmployeeDto getUserByEmail(String email) {

        EmployeeDto returnValue = this.employeeDAO.getByEmail(email);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public EmployeeDto getUserByEmployeeID(int employeeId){

        EmployeeDto returnValue = this.employeeDAO.getByEmployeeId(employeeId);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public List<EmployeeDto> getUsersByRole(String role) {

        List<EmployeeDto> returnValue = this.employeeDAO.getByRole(role);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }
}
 