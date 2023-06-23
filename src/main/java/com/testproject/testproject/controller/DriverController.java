package com.testproject.testproject.controller;

import com.testproject.testproject.models.driver.Driver;
import com.testproject.testproject.service.technicalService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/driversManagement")
    public String showDriversManagement() {
        return "drivers/drivers-management";
    }

    @GetMapping("/allDrivers")
    public String showAllDrivers(Model model) {
        List<Driver> allDrivers = driverService.getAllDrivers();
        model.addAttribute("allDrivers", allDrivers);
        return "drivers/drivers-page";
    }

    @GetMapping("/addNewDriver")
    public String addNewDriver(Model model) {
        model.addAttribute("driver", new Driver());
        return "drivers/driver-info";
    }

    @PostMapping("/saveDriver")
    public String saveDriver(@ModelAttribute("driver") Driver driver) {
        driverService.saveDriver(driver);
        return "redirect:/drivers/allDrivers";
    }

    @GetMapping("/deleteDriver")
    public String deleteDriver(@RequestParam("driverId") long id) {
        driverService.deleteDriver(id);
        return "redirect:/drivers/allDrivers";
    }

    @GetMapping("/updateDriver")
    public String updateDriver(@RequestParam("driverId") long id, Model model) {
        Driver driver = driverService.getDriver(id);
        model.addAttribute("driver", driver);
        return "drivers/driver-info";
    }

}
