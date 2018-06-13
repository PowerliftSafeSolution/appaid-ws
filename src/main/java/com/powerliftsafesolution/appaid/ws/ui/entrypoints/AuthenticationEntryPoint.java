package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.ui.models.request.LoginDetails;
import com.powerliftsafesolution.appaid.ws.ui.models.response.AuthenticationDetails;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authentication")
public class AuthenticationEntryPoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticationDetails userLogin(LoginDetails loginDetails){

        AuthenticationDetails returnValue = new AuthenticationDetails();


        return returnValue;
    }
}
