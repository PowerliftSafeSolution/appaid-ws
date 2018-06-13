package com.powerliftsafesolution.appaid.ws.services;

import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;

public interface UsersService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserByUserID(String userId);
    UserDTO getUserByUserName(String userName);
    UserDTO getUserByEmail(String email);

}
