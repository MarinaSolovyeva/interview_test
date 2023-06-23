package com.testproject.testproject.service.technicalService;

import com.testproject.testproject.models.car.*;
import com.testproject.testproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarDetailRepository carDetailRepository;
    private final CarManufacturerRepository carManufacturerRepository;
    private final CarBrandRepository carBrandRepository;
    private final TypeDetailRepository typeDetailRepository;

    @Autowired
    public CarService(CarRepository carRepository,
                      CarDetailRepository carDetailRepository,
                      CarManufacturerRepository carManufacturerRepository,
                      CarBrandRepository carBrandRepository,
                      TypeDetailRepository typeDetailRepository) {
        this.carRepository = carRepository;
        this.carDetailRepository = carDetailRepository;
        this.carManufacturerRepository = carManufacturerRepository;
        this.carBrandRepository = carBrandRepository;
        this.typeDetailRepository = typeDetailRepository;
    }

    @Transactional
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Transactional
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Transactional
    public Car getCar(long id) {
        Optional<Car> foundCar = carRepository.findById(id);
        return foundCar.orElse(null);
    }

    @Transactional
    public CarDetail getDetail(long id) {
        Optional<CarDetail> foundDetail = carDetailRepository.findById(id);
        return foundDetail.orElse(null);
    }

    @Transactional
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    public void setCarDetail(Car car, CarDetail detail) {
        car.getCarDetailsList().add(detail);
        carRepository.save(car);
    }

    @Transactional
    public List<CarManufacturer> getAllCarManufacturers() {
        return carManufacturerRepository.findAll();
    }

    @Transactional
    public void saveCarManufacturer(CarManufacturer manufacturer) {
        carManufacturerRepository.save(manufacturer);
    }

    @Transactional
    public CarManufacturer getCarManufacturer(long id) {
        Optional<CarManufacturer> foundCarManufacturer = carManufacturerRepository.findById(id);
        return foundCarManufacturer.orElse(null);
    }

    @Transactional
    public void deleteCarManufacturer(long id) {
        carManufacturerRepository.deleteById(id);
    }

    @Transactional
    public List<CarBrand> getAllCarBrand() {
        return carBrandRepository.findAll();
    }

    @Transactional
    public void saveCarBrand(CarBrand carBrand) {
        carBrandRepository.save(carBrand);
    }

    @Transactional
    public CarBrand getCarBrand(long id) {
        Optional<CarBrand> foundCarBrand = carBrandRepository.findById(id);
        return foundCarBrand.orElse(null);
    }
    @Transactional
    public void deleteCarBrand(long id) {
        carBrandRepository.deleteById(id);
    }

    @Transactional
    public List<TypeDetail> getAllTypesDetail() {
        return typeDetailRepository.findAll();
    }

    @Transactional
    public void saveCarDetail(CarDetail carDetail) {
        carDetailRepository.save(carDetail);
    }

    @Transactional
    public void saveTypeCarDetail(TypeDetail typeDetail) {
        typeDetailRepository.save(typeDetail);
    }
}


