package com.powerliftsafesolution.appaid.ws.io;

import com.powerliftsafesolution.appaid.ws.io.morphia.entity.EmployeeEntity;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IOUtils {

    public List<EmployeeDto> copyToUserDTOList(List<EmployeeEntity> userEntities){
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();

        for(EmployeeEntity employeeEntity : userEntities){
            EmployeeDto employeeDTO = new EmployeeDto();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
            employeeDtos.add(employeeDTO);
        }

        return employeeDtos;
    }
}
