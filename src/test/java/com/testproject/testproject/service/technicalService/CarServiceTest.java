package com.testproject.testproject.service.technicalService;

import com.testproject.testproject.models.car.Car;
import com.testproject.testproject.models.car.CarBrand;
import com.testproject.testproject.models.car.CarManufacturer;
import com.testproject.testproject.repository.CarBrandRepository;
import com.testproject.testproject.repository.CarManufacturerRepository;
import com.testproject.testproject.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class CarServiceTest {
    @Mock
    private CarRepository carRepository;
    @Mock
    private CarBrandRepository carBrandRepository;
    @Mock
    private CarManufacturerRepository carManufacturerRepository;


    @InjectMocks
    private CarService carService;

    @Test
    @Tag("test cars")
    public void testGetCar() {
        Long carId = 4L;
        Car car = new Car();
        car.setId(carId);
        when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        Car result = carService.getCar(carId);
        Assertions.assertEquals(car, result);
    }

    @Test
    @Tag("test cars")
    void testGetAllCars() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1L);
        Car car2 = new Car();
        car2.setId(2L);
        cars.add(car1);
        cars.add(car2);
        when(carRepository.findAll()).thenReturn(cars);
        List<Car> result = carService.getAllCars();
        Assertions.assertEquals(cars, result);
        verify(carRepository, times(1)).findAll();
    }

    @Test
    @Tag("test cars")
    public void testSaveCar() {
        long carId = 1L;
        Car car = new Car();
        car.setId(carId);
        carService.saveCar(car);
        verify(carRepository, times(1)).save(car);
    }

    @Test
    @Tag("test cars")
    public void testDeleteCar() {
        Long carId = 1L;
        carService.deleteCar(carId);
        verify(carRepository, times(1)).deleteById(carId);
    }

    @Test
    @Tag("test brands")
    void testGetAllBrands() {
        List<CarBrand> carBrands = new ArrayList<>();
        CarBrand carBrand1 = new CarBrand();
        carBrand1.setId(1L);
        CarBrand carBrand2 = new CarBrand();
        carBrand2.setId(2L);
        carBrands.add(carBrand1);
        carBrands.add(carBrand2);
        when(carBrandRepository.findAll()).thenReturn(carBrands);
        List<CarBrand> result = carService.getAllCarBrand();
        Assertions.assertEquals(carBrands, result);
        verify(carBrandRepository, times(1)).findAll();
    }

    @Test
    @Tag("test brands")
    public void testGetBrand() {
        Long carBrandId = 1L;
        CarBrand carBrand = new CarBrand();
        carBrand.setId(carBrandId);
        when(carBrandRepository.findById(carBrandId)).thenReturn(Optional.of(carBrand));
        CarBrand result = carService.getCarBrand(carBrandId);
        Assertions.assertEquals(carBrand, result);
    }

    @Test
    @Tag("test brands")
    public void testSaveCarBrands() {
        long carBrandId = 1L;
        CarBrand carBrand = new CarBrand();
        carBrand.setId(carBrandId);
        carService.saveCarBrand(carBrand);
        verify(carBrandRepository, times(1)).save(carBrand);
    }

    @Test
    @Tag("test brands")
    public void testDeleteCarBrand() {
        Long carBrandId = 1L;
        carService.deleteCarBrand(carBrandId);
        verify(carBrandRepository, times(1)).deleteById(carBrandId);
    }

    @Test
    @Tag("test manufacturers")
    void testGetAllCarManufacturer() {
        List<CarManufacturer> carManufacturers = new ArrayList<>();
        CarManufacturer carManufacturer1 = new CarManufacturer();
        carManufacturer1.setId(1L);
        CarManufacturer carManufacturer2 = new CarManufacturer();
        carManufacturer2.setId(2L);
        carManufacturers.add(carManufacturer1);
        carManufacturers.add(carManufacturer2);
        when(carManufacturerRepository.findAll()).thenReturn(carManufacturers);
        List<CarManufacturer> result = carService.getAllCarManufacturers();
        Assertions.assertEquals(carManufacturers, result);
        verify(carManufacturerRepository, times(1)).findAll();
    }

    @Test
    @Tag("test manufacturers")
    public void testGetCarManufacturer() {
        Long carManufacturerId = 1L;
        CarManufacturer carManufacturer = new CarManufacturer();
        carManufacturer.setId(carManufacturerId);
        when(carManufacturerRepository.findById(carManufacturerId)).thenReturn(Optional.of(carManufacturer));
        CarManufacturer result = carService.getCarManufacturer(carManufacturerId);
        Assertions.assertEquals(carManufacturer, result);
    }

    @Test
    @Tag("test manufacturers")
    public void testSaveCarManufacturer() {
        long carManufacturerId = 1L;
        CarManufacturer carManufacturer = new CarManufacturer();
        carManufacturer.setId(carManufacturerId);
        carService.saveCarManufacturer(carManufacturer);
        verify(carManufacturerRepository, times(1)).save(carManufacturer);
    }

    @Test
    @Tag("test manufacturers")
    public void testDeleteCarManufacturer() {
        Long carManufacturerId = 1L;
        carService.deleteCarManufacturer(carManufacturerId);
        verify(carManufacturerRepository, times(1)).deleteById(carManufacturerId);
    }
}