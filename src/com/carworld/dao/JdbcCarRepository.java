package com.carworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.carworld.model.Car;


public class JdbcCarRepository implements CarRepository{

	private DataSource dataSource;
	
	private EngineRepository engineRepository;
	private ManufacturerRepository manufacturerRepository;
	
	
	public JdbcCarRepository(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public void addCar(Car car) throws SQLException {
		String query="insert into car (model,color,price,engineId,manufacturerId) values(?,?,?,?,?) ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, car.getModel());
		preparedStatement.setString(2, car.getColor());
		preparedStatement.setDouble(3, car.getPrice());
		preparedStatement.setLong(4, car.getEngine().getEngineId());
		preparedStatement.setLong(5, car.getManufacturer().getManufacturerId());
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.getGeneratedKeys();
		if(rs.next()){
			System.out.println("carId ="+rs.getLong(1));
		}
		connection.close();
		System.out.println("Car saved");
	}

	@Override
	public List<Car> getAllCar() throws SQLException {
		String query="select * from car ";
		Connection connection=dataSource.getConnection();
		ResultSet rs=connection.prepareStatement(query).executeQuery();
		List<Car> cars = new ArrayList<>();
		while(rs.next()){ 
			Car car= new Car();
			car.setCarId(rs.getLong("carId"));
			car.setModel(rs.getString("model"));
			car.setColor(rs.getString("color"));
			car.setPrice(rs.getDouble("price"));
			car.setEngine(engineRepository.getEngine(rs.getLong("engineId")));
			car.setManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
			cars.add(car);
		}
		connection.close();
		return cars;
	}

	@Override
	public Car getCar(Long carId) throws SQLException {
		String query="select * from car where carId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, carId);
		ResultSet rs=preparedStatement.executeQuery();
		Car car=null;
		if(rs.next()){ 
			car= new Car();
			car.setCarId(rs.getLong("carId"));
			car.setModel(rs.getString("model"));
			car.setColor(rs.getString("color"));
			car.setPrice(rs.getDouble("price"));
			car.setEngine(engineRepository.getEngine(rs.getLong("engineId")));
			car.setManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
		}
		connection.close();
		return car;
	}

	@Override
	public void deleteCar(Long carId) throws SQLException {
		String query="delete from car where carId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, carId);
		preparedStatement.executeUpdate();
		System.out.println("Car Deleted");
		connection.close();
	}

	public EngineRepository getEngineRepository() {
		return engineRepository;
	}

	public void setEngineRepository(EngineRepository engineRepository) {
		this.engineRepository = engineRepository;
	}

	public ManufacturerRepository getManufacturerRepository() {
		return manufacturerRepository;
	}

	public void setManufacturerRepository(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	
}
