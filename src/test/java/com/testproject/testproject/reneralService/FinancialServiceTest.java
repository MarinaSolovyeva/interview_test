package com.testproject.testproject.reneralService;

import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.repository.DriverRepository;
import com.testproject.testproject.service.generalService.FinancialService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class FinancialServiceTest {
    @Mock
    private DriverRepository driverRepository;
    @InjectMocks
    private FinancialService financialService;

    @Test
    public void testWithdrawDriverBalance() {
        Driver driver = new Driver();
        driver.setAccountBalance(100.0);
        double sumForWithDraw = 50.0;

        when(driverRepository.save(driver)).thenReturn(driver);
        financialService.withdrawDriverBalance(driver, sumForWithDraw);

        double expectedBalance = 50.0;
        double actualBalance = driver.getAccountBalance();
        Assertions.assertEquals(expectedBalance, actualBalance, 0.01);
    }

    @Test
    public void testRefillDriverBalance() {
        Driver driver = new Driver();
        driver.setAccountBalance(100.0);
        double sumForRefill = 50.0;

        when(driverRepository.save(driver)).thenReturn(driver);
        financialService.refillDriverBalance(driver, sumForRefill);

        double expectedBalance = 150.0;
        double actualBalance = driver.getAccountBalance();
        Assertions.assertEquals(expectedBalance, actualBalance, 0.01);
    }
}
