package com.testproject.testproject.controller;
import com.testproject.testproject.models.car.*;
import com.testproject.testproject.service.technicalService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/carsManagement")
    public String showCarsManagement() {
        return "cars/cars-management";
    }


    @GetMapping("/allCars")
    public String showAllCars(Model model) {
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("allCars", allCars);
        return "cars/cars-page";
    }


    @GetMapping("/addNewCar")
    public String addNewGood(Model model) {
        model.addAttribute("car", new Car());

        List<CarManufacturer> carManufacturers = carService.getAllCarManufacturers();
        model.addAttribute("carManufacturers", carManufacturers);

        List<CarBrand> carBrands = carService.getAllCarBrand();
        model.addAttribute("carBrands", carBrands);

        return "cars/car-info";
    }


    @PostMapping("/saveCar")
    public String saveCar(
            @ModelAttribute("car") Car car,
            @ModelAttribute("carManufacturers") CarManufacturer carManufacturer,
            @ModelAttribute("carBrands") CarBrand carBrand) {
        car.setCarManufacturer(carManufacturer);
        car.setCarBrand(carBrand);
        carService.saveCar(car);
        return "redirect:/cars/allCars";
    }

    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") long id) {
        carService.deleteCar(id);
        return "redirect:/cars/allCars";
    }

    @GetMapping("/carDetails")
    public String showCarDetails(@RequestParam("carId") long id, Model model) {
        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("carId", car.getId());
        model.addAttribute("detailId", car.getId());

        return "cars/car-details";
    }


    @GetMapping("/addNewCarDetail")
    public String addCarDetail(@RequestParam("carId") long id, Model model) {
        model.addAttribute("carDetail", new CarDetail());

        List<TypeDetail> typesDetail = carService.getAllTypesDetail();
        model.addAttribute("typesDetail", typesDetail);
        model.addAttribute("carId", id);
        return "cars/car-detail-info";
    }


    @PostMapping("/saveCarDetail")
    public String saveCarDetails(
            @RequestParam("carId") long id,
            @ModelAttribute("carDetail") CarDetail carDetail,
            @ModelAttribute("typesDetail") TypeDetail typesDetail) {
        carDetail.setTypeDetail(typesDetail);
        Car car = carService.getCar(id);
        car.getCarDetailsList().add(carDetail);
        carService.saveCarDetail(carDetail);
        return "redirect:/cars/allCars";
    }


    @GetMapping("/allTypesDetails")
    public String showAllTypesDetails(Model model) {
        List <TypeDetail> typeDetails = carService.getAllTypesDetail();
        model.addAttribute("typeDetails", typeDetails);
        return "cars/all-types";
    }


    @GetMapping("/addTypeCarDetail")
    public String addTypeCarDetail(Model model) {
        model.addAttribute("typeDetail", new TypeDetail());
        return "cars/type-detail-info";
    }


    @PostMapping("/saveTypeCarDetail")
    public String saveTypeCarDetail(@ModelAttribute("typeDetail") TypeDetail typeDetail) {
        carService.saveTypeCarDetail(typeDetail);
        return "redirect:/cars/carsManagement";
    }


    @GetMapping("/allCarBrands")
    public String showAllCarBrands(Model model) {
        List<CarBrand> allCarBrands = carService.getAllCarBrand();
        model.addAttribute("allCarBrands", allCarBrands);
        return "cars/brands-page";
    }

    @GetMapping("/addNewCarBrand")
    public String addNewCarBrand(Model model) {
        model.addAttribute("carBrand", new CarBrand());
        return "cars/brand-info";
    }


    @PostMapping("/saveCarBrand")
    public String saveCarBrand(
            @ModelAttribute("carBrand") CarBrand carBrand) {
        carService.saveCarBrand(carBrand);
        return "redirect:/cars/allCarBrands";
    }

    @GetMapping("/deleteCarBrand")
    public String deleteCarBrand(@RequestParam("carBrandId") long id) {
        carService.deleteCarBrand(id);
        return "redirect:/cars/allCarBrands";
    }

    @GetMapping("/allCarManufactures")
    public String showAllCarManufacturers(Model model) {
        List<CarManufacturer> allCarManufacturers = carService.getAllCarManufacturers();
        model.addAttribute("allCarManufacturers", allCarManufacturers);
        return "cars/manufactures-page";
    }

    @GetMapping("/addNewCarManufacturer")
    public String addNewCarManufacturer(Model model) {
        model.addAttribute("carManufacturer", new CarManufacturer());
        return "cars/manufacturer-info";
    }

    @PostMapping("/saveCarManufacturer")
    public String saveCarManufacturer(
            @ModelAttribute("carManufacturer") CarManufacturer carManufacturer) {
        carService.saveCarManufacturer(carManufacturer);
        return "redirect:/cars/allCarManufactures";
    }

    @GetMapping("/deleteCarManufacturer")
    public String deleteCarManufacturer(@RequestParam("carManufacturerId") long id) {
        carService.deleteCarManufacturer(id);
        return "redirect:/cars/allCarManufactures";
    }
}
