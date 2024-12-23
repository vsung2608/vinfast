package com.example.vinfast.service.impl;

import com.example.vinfast.dao.IProvinceDAO;
import com.example.vinfast.dao.IShowRoomDAO;
import com.example.vinfast.dao.ITestDriveRegistrationDAO;
import com.example.vinfast.model.Province;
import com.example.vinfast.model.ShowRoom;
import com.example.vinfast.model.TestDriveRegistration;
import com.example.vinfast.service.ITestDriveService;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

public class TestDriveService implements ITestDriveService {
    @Inject
    private IProvinceDAO provinceDAO;

    @Inject
    private IShowRoomDAO showRoomDAO;

    @Inject
    ITestDriveRegistrationDAO testDriveRegistrationDAO;

    @Override
    public List<Province> getAllProvinces() {
        return provinceDAO.findAll();
    }

    @Override
    public List<ShowRoom> getShowRoomByProvinceId(String id) {
        return showRoomDAO.getShowRoomsByProvinceId(id);
    }

    @Override
    public void createTestDriveRegistration(TestDriveRegistration tdr) {
        testDriveRegistrationDAO.save(tdr);
    }

    @Override
    public List<TestDriveRegistration> getAllTestDriveRegistrations() {
        return testDriveRegistrationDAO.findAll();
    }

    @Override
    public void setUpTestDate(int testId, LocalDateTime time) {
        testDriveRegistrationDAO.confirmRegistration(testId, time);
    }

    @Override
    public TestDriveRegistration findById(int testId) {
        return testDriveRegistrationDAO.findById(testId);
    }

    @Override
    public void cancelTestDrive(int testId) {
        testDriveRegistrationDAO.cancelTestDriveRegistration(testId);
    }
}
