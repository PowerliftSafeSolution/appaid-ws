package com.powerliftsafesolution.appaid.ws.services.impl;

import com.powerliftsafesolution.appaid.ws.exceptions.NoRecordFoundException;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.UserDAO;
import com.powerliftsafesolution.appaid.ws.services.UsersService;
import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDAO userDAO;

    public UsersServiceImpl(){
    }

    @Override
    public UserDTO getUserByUserId(String userId) {

        UserDTO returnValue = this.userDAO.getByUserId(userId);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;

    }

    @Override
    public UserDTO getUserByUserName(String userName) {

        UserDTO returnValue = this.userDAO.getByUserName(userName);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public UserDTO getUserByEmail(String email) {

        UserDTO returnValue = this.userDAO.getByEmail(email);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public UserDTO getUserByEmployeeID(int employeeId){

        UserDTO returnValue = this.userDAO.getByEmployeeId(employeeId);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public List<UserDTO> getUsersByRole(String role) {

        List<UserDTO> returnValue = this.userDAO.getByRole(role);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }
}
 