package com.testproject.testproject.controller;

import com.testproject.testproject.models.Currency;
import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.service.generalService.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers/finances")
public class FinanceController {

    @Autowired
    private FinancialService financialService;

    @GetMapping("/refillBalance")
    public void refillDriverBalance (Driver driver, Double sumForRefill, Currency fromCurrency, Currency toCurrency) {
        double sum = financialService.convertCurrency(sumForRefill, fromCurrency, toCurrency);
        financialService.refillDriverBalance(driver, sum);
    }

    @GetMapping("/withDrawBalance")
    public void withdrawDriverBalance (Driver driver, Double sumForWithDraw, Currency fromCurrency, Currency toCurrency) {
        double sum = financialService.convertCurrency(sumForWithDraw, fromCurrency, toCurrency);
        financialService.refillDriverBalance(driver, sum);
    }
}

