package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.services.UsersService;
import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.response.UserProfileResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersEntryPoint {

    @Autowired
    private UsersService usersService;

    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByUserId(@QueryParam("id") String userId){
        UserProfileResponseModel  returnValue = new UserProfileResponseModel();

        UserDTO userProfile = this.usersService.getUserByUserId(userId);


        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/username")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByUserName(@QueryParam("username") String userName){
        UserProfileResponseModel returnValue = new UserProfileResponseModel();

        UserDTO userProfile = this.usersService.getUserByUserName(userName);

        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByEmail(@QueryParam("email") String email){
        UserProfileResponseModel returnValue = new UserProfileResponseModel();

        UserDTO userProfile = this.usersService.getUserByEmail(email);

        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }


}
