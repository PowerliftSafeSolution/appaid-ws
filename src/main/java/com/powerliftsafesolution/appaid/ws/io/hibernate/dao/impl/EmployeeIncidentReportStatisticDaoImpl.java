package com.powerliftsafesolution.appaid.ws.io.hibernate.dao.impl;

import com.powerliftsafesolution.appaid.ws.io.hibernate.dao.EmployeeIncidentReportStatisticDao;
import com.powerliftsafesolution.appaid.ws.io.hibernate.entity.EmployeeIncidentReportStatisticEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeIncidentReportStatisticDaoImpl implements EmployeeIncidentReportStatisticDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String save(EmployeeIncidentReportStatisticEntity employeeIncidentReportStatisticEntity) {
        sessionFactory.getCurrentSession().save(employeeIncidentReportStatisticEntity);
        return employeeIncidentReportStatisticEntity.getId();
    }

    @Override
    public void update(String id, EmployeeIncidentReportStatisticEntity employeeIncidentReportStatisticEntity) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeIncidentReportStatisticEntity updateEntity =
                session.byId(EmployeeIncidentReportStatisticEntity.class).load(id);

        updateEntity.setTypeIncident(employeeIncidentReportStatisticEntity.getTypeIncident());
        updateEntity.setDate(employeeIncidentReportStatisticEntity.getDate());
        updateEntity.setTime(employeeIncidentReportStatisticEntity.getTime());
        updateEntity.setEmployeeFirstName(employeeIncidentReportStatisticEntity.getEmployeeFirstName());
        updateEntity.setEmployeeLastName(employeeIncidentReportStatisticEntity.getEmployeeLastName());
        updateEntity.setEmployeeId(employeeIncidentReportStatisticEntity.getEmployeeId());

        updateEntity.setInjuryAbdomenLowerbackLumbarPelvis(
                employeeIncidentReportStatisticEntity.isInjuryAbdomenLowerbackLumbarPelvis());

        updateEntity.setInjuryHead(employeeIncidentReportStatisticEntity.isInjuryHead());
        updateEntity.setInjuryAnkleFoot(employeeIncidentReportStatisticEntity.isInjuryAnkleFoot());
        updateEntity.setInjuryChest(employeeIncidentReportStatisticEntity.isInjuryChest());
        updateEntity.setInjuryHipThigh(employeeIncidentReportStatisticEntity.isInjuryHipThigh());
        updateEntity.setInjuryKneeLowerleg(employeeIncidentReportStatisticEntity.isInjuryKneeLowerleg());
        updateEntity.setInjuryNeck(employeeIncidentReportStatisticEntity.isInjuryNeck());
        updateEntity.setInjuryShoulderUpperarm(employeeIncidentReportStatisticEntity.isInjuryShoulderUpperarm());

        updateEntity.setInjuryWristHand(employeeIncidentReportStatisticEntity.isInjuryWristHand());

        updateEntity.setForkliftInvolved(employeeIncidentReportStatisticEntity.isForkliftInvolved());

        updateEntity.setForkliftOperatorFirstName(
                employeeIncidentReportStatisticEntity.getForkliftOperatorFirstName());

        updateEntity.setForkliftOperatorLastName(
                employeeIncidentReportStatisticEntity.getForkliftOperatorLastName());

        updateEntity.setForkliftOperatorEmployeeId(
                employeeIncidentReportStatisticEntity.getForkliftOperatorEmployeeId());

        updateEntity.setLocationGeneral(employeeIncidentReportStatisticEntity.getLocationGeneral());

        session.flush();
    }

    @Override
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        EmployeeIncidentReportStatisticEntity deleteEntity =
                session.byId(EmployeeIncidentReportStatisticEntity.class).load(id);

        session.delete(deleteEntity);

    }

    @Override
    public Map<String, Integer> getSumInjuryByCategoryAndDate() {
        return null;
    }
}
