package com.carworld.service;

import com.carworld.dao.DbFactory;

public class AllService {

	private static final CarService carService = new CarServiceImpl();
	private static final EngineService engineService = new EngineServiceImpl();
	private static final ManufacturerService manufacturerService = new ManufacturerServiceImpl();
	
	
	public static CarService getCarService() {

		((CarServiceImpl)carService).setCarRepository(DbFactory.getCarRepository());
		((CarServiceImpl)carService).setCarEngineService(getEngineService());
		((CarServiceImpl)carService).setCarManufacturerService(getManufacturerService());
		return carService;
	}
	
	public static EngineService getEngineService() {
		((EngineServiceImpl) engineService).setEngineRepository(DbFactory.getEngineRepository());
		((EngineServiceImpl) engineService).setEngineManufacturerService(getManufacturerService());
		return engineService;
	}
	
	public static ManufacturerService getManufacturerService() {
		((ManufacturerServiceImpl)manufacturerService).setManufacturerRepository(DbFactory.getManufacturerRepository());
		return manufacturerService;
	}
}
