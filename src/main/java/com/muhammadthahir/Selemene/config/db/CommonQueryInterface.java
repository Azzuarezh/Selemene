package com.muhammadthahir.Selemene.config.db;

/**
 * @author muhammad.thahir
 * interface for common Query like get databases from catalog etc.
 */
public interface CommonQueryInterface {

	public String getDatabases(String DBType);	
	public String getColumnsFromTable(String DBType, String DbName, String TblName);
	public String getObjectFromDb(String DBType, String DbName, String ObjectType);	
		
}
