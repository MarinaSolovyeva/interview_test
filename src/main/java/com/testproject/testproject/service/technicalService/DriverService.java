package com.testproject.testproject.service.technicalService;

import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.repository.DriverRepository;
import com.testproject.testproject.service.generalService.BirthdayReminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private BirthdayReminder birthdayReminder;
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository, BirthdayReminder birthdayReminder) {
        this.birthdayReminder = birthdayReminder;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Transactional
    public void saveDriver(Driver driver) {
        birthdayReminder.addDrivers(driver);
        driverRepository.save(driver);
    }

    @Transactional
    public Driver getDriver(long id) {
        Optional<Driver> foundDriver = driverRepository.findById(id);
        return foundDriver.orElse(null);
    }

    @Transactional
    public void updateDriver(long id, Driver updatedDriver) {
        updatedDriver.setId(id);
        driverRepository.save(updatedDriver);
    }

    @Transactional
    public void deleteDriver(long id) {
        driverRepository.deleteById(id);
    }
}
