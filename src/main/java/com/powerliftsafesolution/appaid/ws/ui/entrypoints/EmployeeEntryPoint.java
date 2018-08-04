package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.services.EmployeeService;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeDto;
import com.powerliftsafesolution.appaid.ws.ui.models.response.EmployeeProfileResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class EmployeeEntryPoint {

    @Autowired
    private EmployeeService employeesService;

    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeProfileResponseModel getEmployeeProfileByEmployeeId(@QueryParam("id") int employeeId){
        EmployeeProfileResponseModel returnValue = new EmployeeProfileResponseModel();

        EmployeeDto userProfile = this.employeesService.getEmployeeByEmployeeId(employeeId);


        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeProfileResponseModel getEmployeeProfileByEmail(@QueryParam("email") String email){
        EmployeeProfileResponseModel returnValue = new EmployeeProfileResponseModel();

        EmployeeDto userProfile = this.employeesService.getUserByEmail(email);

        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }


}
