package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.io.s3.dao.impl.SafetyBucketDao;
import com.powerliftsafesolution.appaid.ws.ui.models.request.SafetyRequestModel;
import com.powerliftsafesolution.appaid.ws.ui.models.response.SafetyResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URL;

@Path("/safety")
public class SafetyDocumentsEntryPoint {

    @Autowired
    SafetyBucketDao safetyBucketDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public SafetyResponseModel getFile(@PathParam("name") String name){

        SafetyResponseModel returnValue = new SafetyResponseModel();

        return returnValue;

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SafetyResponseModel uploadFile(SafetyRequestModel safetyRequestModel){

        URL url = safetyBucketDao.uploadObject(safetyRequestModel.getFileName());

        SafetyResponseModel returnValue = new SafetyResponseModel();
        BeanUtils.copyProperties(safetyRequestModel, returnValue);

        returnValue.setUrl(url);

        return  returnValue;
    }
}
