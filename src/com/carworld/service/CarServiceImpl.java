package com.carworld.service;

import java.util.List;

import com.carworld.dao.CarRepository;
import com.carworld.model.Car;
import com.carworld.model.Engine;
import com.carworld.model.Manufacturer;

public class CarServiceImpl implements CarService{

	CarRepository carRepository;
	EngineService carEngineService;
	ManufacturerService carManufacturerService;
	
	@Override
	public void addCar(Car car) throws Exception{
		carRepository.addCar(car);
	}

	@Override
	public List<Car> getAllCar() throws Exception{
			return carRepository.getAllCar();
	}

	@Override
	public Car getCar(Long carId) throws Exception{
			return carRepository.getCar(carId);
	}

	@Override
	public void deleteCar(Long carId) throws Exception{
		carRepository.deleteCar(carId);
	}

	@Override
	public List<Engine> getAllEngine() throws Exception{
		return carEngineService.getAllEngine();
	}

	@Override
	public List<Manufacturer> getAllManufacturer() throws Exception{
		return carManufacturerService.getAllManufacturer();
	}

	public CarRepository getCarRepository() {
		return carRepository;
	}

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public EngineService getCarEngineService() {
		return carEngineService;
	}

	public void setCarEngineService(EngineService carEngineService) {
		this.carEngineService = carEngineService;
	}

	public ManufacturerService getCarManufacturerService() {
		return carManufacturerService;
	}

	public void setCarManufacturerService(ManufacturerService carManufacturerService) {
		this.carManufacturerService = carManufacturerService;
	}
	
	
}
