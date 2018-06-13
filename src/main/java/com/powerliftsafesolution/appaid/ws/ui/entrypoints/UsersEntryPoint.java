package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.services.UsersService;
import com.powerliftsafesolution.appaid.ws.services.impl.UsersServiceImpl;
import com.powerliftsafesolution.appaid.ws.shared.dto.UserDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.request.CreateUserRequestModel;
import com.powerliftsafesolution.appaid.ws.ui.models.response.UserProfileResponseModel;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersEntryPoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel createUser(CreateUserRequestModel requestModel) {
        UserProfileResponseModel returnValue = new UserProfileResponseModel();

        // Prepare UserDTO
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(requestModel, userDTO);

        // Create new user
        UsersService userService = new UsersServiceImpl();
        UserDTO createdUserProfile = userService.createUser(userDTO);

        //Prepare response
        BeanUtils.copyProperties(createdUserProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/userid/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByUserId(@PathParam("userId") String userId){
        UserProfileResponseModel  returnValue = new UserProfileResponseModel();

        UsersService userService = new UsersServiceImpl();
        UserDTO userProfile = userService.getUserByUserID(userId);


        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/username/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByUserName(@PathParam("userName") String userName){
        UserProfileResponseModel returnValue = new UserProfileResponseModel();;

        UsersService userService = new UsersServiceImpl();
        UserDTO userProfile = userService.getUserByUserName(userName);

        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfileResponseModel getUserProfileByEmail(@PathParam("email") String email){
        UserProfileResponseModel returnValue = new UserProfileResponseModel();

        UsersService usersService = new UsersServiceImpl();
        UserDTO userProfile = usersService.getUserByEmail(email);

        BeanUtils.copyProperties(userProfile, returnValue);

        return returnValue;
    }
}
