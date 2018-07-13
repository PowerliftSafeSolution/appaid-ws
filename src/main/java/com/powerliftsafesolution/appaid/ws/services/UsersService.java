package com.powerliftsafesolution.appaid.ws.services;

import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;

import java.util.List;

public interface UsersService {
    UserDTO getUserByUserId(String userId);
    UserDTO getUserByUserName(String userName);
    UserDTO getUserByEmail(String email);
    UserDTO getUserByEmployeeID(int employeeId);
    List<UserDTO> getUsersByRole(String role);

}
