package com.powerliftsafesolution.appaid.ws.ui.entrypoints;

import com.powerliftsafesolution.appaid.ws.services.EmployeeIncidentReportService;
import com.powerliftsafesolution.appaid.ws.services.impl.EmployeeIncidentReportServiceImpl;
import com.powerliftsafesolution.appaid.ws.shared.dto.EmployeeIncidentReportDTO;
import com.powerliftsafesolution.appaid.ws.ui.models.request.EmployeeIncidentSubmitRequestModel;
import com.powerliftsafesolution.appaid.ws.ui.models.response.EmployeeIncidentReportResponseModel;
import com.powerliftsafesolution.appaid.ws.ui.models.response.EmployeeIncidentSubmissionSuccessResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/incidentreport")
public class EmployeeIncidentReportEntryPoint {

    @Autowired
    EmployeeIncidentReportService employeeIncidentReportService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeIncidentSubmissionSuccessResponseModel submitReport(EmployeeIncidentSubmitRequestModel form) {
        EmployeeIncidentSubmissionSuccessResponseModel returnValue = new
                EmployeeIncidentSubmissionSuccessResponseModel();

        EmployeeIncidentReportDTO reportDTO = new EmployeeIncidentReportDTO();
        BeanUtils.copyProperties(form, reportDTO);

        EmployeeIncidentReportDTO responseDto = this.employeeIncidentReportService.saveReport(reportDTO);

        BeanUtils.copyProperties(responseDto, returnValue);
        returnValue.setStatus("Successful");

        return returnValue;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeIncidentReportResponseModel getReportByNameDateTime(@QueryParam("firstname") String firstName,
                                                                       @QueryParam("lastname") String lastName,
                                                                       @QueryParam("date") String date,
                                                                       @QueryParam("time") String time) {

        EmployeeIncidentReportResponseModel returnValue = new EmployeeIncidentReportResponseModel();

        EmployeeIncidentReportDTO requestedReport = this.employeeIncidentReportService.getReportByNameDateTime(firstName,
                lastName, date, time);

        BeanUtils.copyProperties(requestedReport, returnValue);

        return returnValue;

    }

}
