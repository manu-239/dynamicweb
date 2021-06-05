package com.carworld.dao;

public class DbFactory {

	private static final CarRepository carRepository = new JdbcCarRepository(DbConnectionFactory.getDataSource());
	private static final EngineRepository engineRepository = new JdbcEngineRepository(DbConnectionFactory.getDataSource());
	private static final ManufacturerRepository manufacturerRepository = new JdbcManufacturerRepository(DbConnectionFactory.getDataSource());

	public static CarRepository getCarRepository() {
		((JdbcCarRepository)carRepository).setEngineRepository(getEngineRepository());
		((JdbcCarRepository)carRepository).setManufacturerRepository(getManufacturerRepository());
		return carRepository;
	}
	
	public static EngineRepository getEngineRepository() {
		((JdbcEngineRepository)engineRepository).setManufacturerRepository(getManufacturerRepository());
		return engineRepository;
	}
	
	public static ManufacturerRepository getManufacturerRepository() {
		return manufacturerRepository;
	}
}
