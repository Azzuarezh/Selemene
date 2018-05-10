package com.muhammadthahir.Selemene.config.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.muhammadthahir.Selemene.config.GlobalVariable;



public class Driver {

	@Override
	public String toString() {
		try {
			return "Driver [dataSource=" + dataSource + ", getDataSource()=" + getDataSource()
					+ ", checkConnectionIsOpen()=" + checkConnectionIsOpen() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	private DataSource dataSource;
	
	public Driver(String serverName, String username, String password, String DBType, int port){
		DriverManagerDataSource dsm = new DriverManagerDataSource();
		System.out.println("serverName : " +serverName);
		System.out.println("port : " +port);
		System.out.println("dbtype : " +DBType);
		System.out.println("username : " +username);		
		System.out.println("password : " +password);
		dsm.setUsername(username);
		dsm.setPassword(password);
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(DBType)){
			dsm.setDriverClassName(GlobalVariable.DRIVERCLASS_SQL_SERVER);
			dsm.setUrl(String.format("jdbc:jtds:sqlserver://%s:%d;databaseName=master", serverName, port==0?1433:port));
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(DBType)){
			dsm.setDriverClassName(GlobalVariable.DRIVERCLASS_POSTGRE);
			dsm.setUrl(String.format("jdbc:postgresql://%s:%d/Cronos?tcpKeepAlive=true&autoReconnect=true", serverName, port==0?5432:port));
		}
		else if(GlobalVariable.DB_MYSQL.equalsIgnoreCase(DBType)){
			dsm.setDriverClassName(GlobalVariable.DRIVERCLASS_MYSQL);
			dsm.setUrl(String.format("jdbc:mysql://%s:%d", serverName, port==0?3306:port));
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
