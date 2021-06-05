package com.carworld.service;

import java.util.List;

import com.carworld.dao.ManufacturerRepository;
import com.carworld.model.Manufacturer;

public class ManufacturerServiceImpl implements ManufacturerService{

	ManufacturerRepository manufacturerRepository;
	
	@Override
	public void addManufacturer(Manufacturer manufacturer) throws Exception {
		manufacturerRepository.addManufacturer(manufacturer);
	}

	@Override
	public List<Manufacturer> getAllManufacturer() throws Exception {
		return manufacturerRepository.getAllManufacturer();
	}

	@Override
	public Manufacturer getManufacturer(Long manufacturerId) throws Exception {
		return manufacturerRepository.getManufacturer(manufacturerId);
	}

	@Override
	public void deleteManufacturer(Long manufacturerId) throws Exception {
		manufacturerRepository.deleteManufacturer(manufacturerId);
	}

	public ManufacturerRepository getManufacturerRepository() {
		return manufacturerRepository;
	}

	public void setManufacturerRepository(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	
}
