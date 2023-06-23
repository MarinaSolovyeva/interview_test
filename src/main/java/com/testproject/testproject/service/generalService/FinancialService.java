package com.testproject.testproject.service.generalService;

import com.testproject.testproject.models.Currency;
import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.service.technicalService.CarService;
import com.testproject.testproject.service.technicalService.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinancialService {

    private final CarService carService;
    private final DriverService driverService;

    public FinancialService(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    @Transactional
    public void refillDriverBalance(Driver driver, double sumForRefill) {
        Double newBalance = driver.getAccountBalance() + sumForRefill;
        driver.setAccountBalance(newBalance);
    }

    @Transactional
    public void withdrawDriverBalance(Driver driver, double sumForWithDraw) {
        Double newBalance = driver.getAccountBalance() - sumForWithDraw;
        driver.setAccountBalance(newBalance);
    }

    public double convertCurrency(double amount, Currency fromCurrency, Currency toCurrency) {
        if (fromCurrency == Currency.RED && toCurrency == Currency.GREEN) {
            return convertRedToGreen(amount);
        } else if (fromCurrency == Currency.RED && toCurrency == Currency.GREEN) {
            return convertGreenToRed(amount);
        } else if (fromCurrency == Currency.GREEN && toCurrency == Currency.BLUE) {
            return convertGreenToBlue(amount);
        } else if (fromCurrency == Currency.BLUE && toCurrency == Currency.GREEN) {
            return convertBlueToGreen(amount);
        } else if (fromCurrency == Currency.RED && toCurrency == Currency.BLUE) {
            return convertRedToBlue(amount);
        } else if (fromCurrency == Currency.BLUE && toCurrency == Currency.RED) {
            return convertBlueToRed(amount);
        }
        throw new UnsupportedOperationException("Unsupported currency conversion.");
    }

    public double convertRedToGreen(double redDollars) {
        return redDollars * 2.5;
    }

    public double convertGreenToRed(double greenDollars) {
        return greenDollars / 2.5;
    }

    public double convertGreenToBlue(double greenDollars) {
        return greenDollars * 0.6;
    }

    public double convertBlueToGreen(double blueDollars) {
        return blueDollars / 0.6;
    }

    public double convertRedToBlue(double redDollars) {
        return redDollars * 1.5;
    }

    public double convertBlueToRed(double blueDollars) {
        return blueDollars / 1.5;
    }
}