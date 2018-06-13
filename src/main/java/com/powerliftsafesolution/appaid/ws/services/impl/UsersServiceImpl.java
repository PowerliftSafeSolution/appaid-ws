package com.powerliftsafesolution.appaid.ws.services.impl;

import com.powerliftsafesolution.appaid.ws.exceptions.CouldNotCreateRecordException;
import com.powerliftsafesolution.appaid.ws.exceptions.NoRecordFoundException;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.UserDAO;
import com.powerliftsafesolution.appaid.ws.io.morphia.dao.impl.UserDAOImpl;
import com.powerliftsafesolution.appaid.ws.io.morphia.entity.UserEntity;
import com.powerliftsafesolution.appaid.ws.io.morphia.service.MorphiaService;
import com.powerliftsafesolution.appaid.ws.services.UsersService;
import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.response.ErrorMessages;
import com.powerliftsafesolution.appaid.ws.utils.PasswordUtil;
import com.powerliftsafesolution.appaid.ws.utils.UserProfileUtils;
import org.springframework.beans.BeanUtils;

public class UsersServiceImpl implements UsersService {

    private final int LENGTH_OF_USER_ID = 30;

    private UserProfileUtils userProfileUtils;
    private PasswordUtil passwordUtil;
    private MorphiaService morphiaService;

    public UsersServiceImpl(){
        this.userProfileUtils = new UserProfileUtils();
        this.morphiaService = MorphiaService.getInstance();
        this.passwordUtil = new PasswordUtil();
    }

    @Override
    public UserDTO createUser(UserDTO user) {

        UserDAO userDAO = new UserDAOImpl(UserEntity.class, morphiaService.getDataStore());
        UserDTO returnValue = new UserDTO();

        // Validate if all required fields are present
        userProfileUtils.validateRequiredFields(user);

        // Check if user already exists
        UserDTO existingUser = userDAO.getByUserName(user.getUserName());

        if(existingUser != null){
            throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }

        // Generate secure public user id
        String userId = userProfileUtils.generateUserId(this.LENGTH_OF_USER_ID);
        user.setUserId(userId);

        // Generate secure password
        String securePassword = passwordUtil.hashPassword(user.getPassword());
        user.setEncryptedPassword(securePassword);

        // Record data into database
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userDAO.save(userEntity);

        BeanUtils.copyProperties(userEntity, returnValue);

        //Return back the user profile
        return returnValue;
    }

    @Override
    public UserDTO getUserByUserID(String userId) {
        UserDAO userDAO = new UserDAOImpl(UserEntity.class, morphiaService.getDataStore());
        UserDTO returnValue = userDAO.getByUserId(userId);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;

    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        UserDAO userDAO = new UserDAOImpl(UserEntity.class, morphiaService.getDataStore());
        UserDTO returnValue = userDAO.getByUserName(userName);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDAO userDAO = new UserDAOImpl(UserEntity.class, morphiaService.getDataStore());
        UserDTO returnValue = userDAO.getByEmail(email);

        if(returnValue == null){
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.name());
        }

        return returnValue;
    }
}
 