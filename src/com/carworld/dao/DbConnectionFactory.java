package com.carworld.dao;

import org.apache.commons.dbcp.BasicDataSource;

public class DbConnectionFactory {
	
	private static final BasicDataSource dataSource = new BasicDataSource();
	
	static {
		dataSource.setUrl("jdbc:mysql://localhost/cardb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	}
	public static BasicDataSource getDataSource() {
		return dataSource;
	}

	
}
