package com.muhammadthahir.Selemene.config.db;

import java.util.List;
import java.util.Map;
import com.muhammadthahir.Selemene.config.GlobalVariable;

/**
 * @author muhammad.thahir
 * Class yang menghasilkan Query-Query umum pada sql syntax (select db, select table, column etc.)
 */
public class CommonQuery implements CommonQueryInterface {

	private String query;
	
	@Override
	public String getDatabases(String DBType) {
		// TODO Auto-generated method stub		
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(DBType)){
			query ="select name as DATABASE_NAME from master..sysdatabases where dbid > 6";
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(DBType)){
			query = "select datname as \"DATABASE_NAME\" from pg_database where datistemplate = false";
		}			
		return query;
	}

	
	@Override
	public String getColumnsFromTable(String DBType, String DbName, String TblName) {
		// TODO Auto-generated method stub
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(DBType)){
			query  = String.format("select TABLE_NAME as , COLUMN_NAME, DATA_TYPE from %s.INFORMATION_SCHEMA.COLUMNS "+
					"where TABLE_NAME = '%s order by COLUMN_NAME asc", DbName,TblName);
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(DBType)){
			query = String.format("	select table_name as 'TABLE_NAME', column_name as 'COLUMN_NAME', data_type as 'DATA_TYPE' from information_schema.columns "+
					"where table_schema ='%s' and  table_name = '%s' order by column_name asc", DbName,TblName);
		}		
		return query;
	}


	@Override
	public String getObjectFromDb(String DBType, String DbName, String ObjectType) {
		// TODO Auto-generated method stub		
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(DBType)){
			query = String.format("select TABLE_CATALOG as 'DATABASE_NAME',TABLE_NAME as OBJECT_NAME from %s.INFORMATION_SCHEMA."+ ObjectType + " " +					
					"order by TABLE_NAME asc", DbName , DbName);
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(DBType)){
			query =String.format("select table_schema as \"DATABASE_NAME\", TABLE_NAME as \"OBJECT_NAME\" from information_schema."+  ObjectType + " " +
					"where table_schema not in('pg_catalog','information_schema') and table_schema = '%s' order by TABLE_NAME asc", DbName);
		}		
		return query;
	}

}
