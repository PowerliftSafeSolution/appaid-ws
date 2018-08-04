package com.powerliftsafesolution.appaid.ws.services;

import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getEmployeeByEmployeeId(int userId);
    EmployeeDto getUserByEmail(String email);
    List<EmployeeDto> getUsersByRole(String role);

}
