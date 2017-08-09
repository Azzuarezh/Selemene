package com.muhammadthahir.Selemene.config.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @author muhammad.thahir
 * Class yang menghasilkan Data dari hasil query
 * 
 */
public class Connection {
	
	public String DB_Type;
	private Driver driver;
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> Query_Result;
	public boolean connectionOpen;
	
	public boolean isConnectionOpen() throws SQLException {
		return checkConnectionOpen();
	}
	
	public Connection(String serverName,String userName, String pass, int port,String dB_Type) {		
		DB_Type = dB_Type;
		this.driver = new Driver(serverName, userName, pass, dB_Type, port);
		this.jdbcTemplate = new JdbcTemplate(driver.getDataSource());
		
	}
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public List<Map<String, Object>> getQuery_Result(String sql) throws SQLException{		
		Query_Result = jdbcTemplate.queryForList(sql);
		return Query_Result;
		
	}
	public boolean checkConnectionOpen() throws SQLException{
		return driver.checkConnectionIsOpen();
	}
			

}
