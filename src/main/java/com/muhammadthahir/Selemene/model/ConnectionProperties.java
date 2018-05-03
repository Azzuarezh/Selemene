/**
 * 
 */
package com.muhammadthahir.Selemene.model;

/**
 * @author muhammad.thahir
 * Class pojo untuk mendefinisikan object connection property di request body
 * pada rest api Database Object
 */
public class ConnectionProperties {
		
	private String serverName;
	private String driver;
	private int port;
	private String userName;
	private String password;
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	
}
