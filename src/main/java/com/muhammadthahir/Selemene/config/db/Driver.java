package com.muhammadthahir.Selemene.config.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.muhammadthahir.Selemene.config.GlobalVariable;



public class Driver {

	private DataSource dataSource;
	
	public Driver(String serverName, String username, String password, String DBType, int port){
		DriverManagerDataSource dsm = new DriverManagerDataSource();
		dsm.setUsername(username);
		dsm.setPassword(password);
		switch (DBType) {
		case GlobalVariable.DB_SQL_SERVER:
			dsm.setDriverClassName(GlobalVariable.DRIVERCLASS_SQL_SERVER);
			dsm.setUrl(String.format("jdbc:jtds:sqlserver://%s:%d;databaseName=master", serverName, port==0?1433:port));			
			break;
		case GlobalVariable.DB_POSTGRESQL:
			dsm.setDriverClassName(GlobalVariable.DRIVERCLASS_POSTGRE);
			dsm.setUrl(String.format("jdbc:postgresql://%s:%d/Cronos?tcpKeepAlive=true&autoReconnect=true", serverName, port==0?5432:port));			
			break;

		default:
			break;
		}
		this.dataSource = dsm;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public boolean checkConnectionIsOpen() throws SQLException{
		return !dataSource.getConnection().isClosed();
	}
	
}
