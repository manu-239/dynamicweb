package com.carworld.service;

import java.util.List;

import com.carworld.dao.EngineRepository;
import com.carworld.model.Engine;
import com.carworld.model.Manufacturer;

public class EngineServiceImpl implements EngineService{
	
	EngineRepository engineRepository;
	ManufacturerService engineManufacturerService;

	@Override
	public void addEngine(Engine engine) throws Exception {
		engineRepository.addEngine(engine);
	}

	@Override
	public List<Engine> getAllEngine() throws Exception {
		return engineRepository.getAllEngine();
	}

	@Override
	public Engine getEngine(Long engineId) throws Exception {
		return engineRepository.getEngine(engineId);
	}

	@Override
	public void deleteEngine(Long engineId) throws Exception {
		engineRepository.deleteEngine(engineId);
	}

	@Override
	public List<Manufacturer> getAllManufactures() throws Exception {
		return engineManufacturerService.getAllManufacturer();
	}

	public EngineRepository getEngineRepository() {
		return engineRepository;
	}

	public void setEngineRepository(EngineRepository engineRepository) {
		this.engineRepository = engineRepository;
	}

	public ManufacturerService getEngineManufacturerService() {
		return engineManufacturerService;
	}

	public void setEngineManufacturerService(ManufacturerService engineManufacturerService) {
		this.engineManufacturerService = engineManufacturerService;
	}

	
}
