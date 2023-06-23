package com.testproject.testproject.service.technicalService;
import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.repository.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;


@SpringBootTest
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;
    @InjectMocks
    private DriverService driverService;

    @Test
    void testGetAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        Driver driver1 = new Driver();
        driver1.setId(1L);
        Driver driver2 = new Driver();
        driver2.setId(2L);
        drivers.add(driver1);
        drivers.add(driver2);
        when(driverRepository.findAll()).thenReturn(drivers);
        List<Driver> result = driverService.getAllDrivers();
        Assertions.assertEquals(drivers, result);
        verify(driverRepository, times(1)).findAll();
    }

    @Test
    public void testGetDriver() {
        Long driverId = 4L;
        Driver driver = new Driver();
        driver.setId(driverId);
        when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));
        Driver result = driverService.getDriver(driverId);
        Assertions.assertEquals(driver, result);
    }

    @Test
    public void testUpdateDriver() {
        long driverId = 1L;
        Driver updatedDriver = new Driver();
        driverService.updateDriver(driverId, updatedDriver);
        verify(driverRepository, times(1)).save(updatedDriver);
        Assertions.assertEquals(driverId, updatedDriver.getId());
    }

}