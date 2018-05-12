package com.muhammadthahir.Selemene.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class GlobalVariable {

	
	public static final String DB_SQL_SERVER ="SQLServer";
	public static final String DB_POSTGRESQL ="PostgreSQL";
	public static final String DB_MYSQL = "MySQL";

	//pake yang gratisan jtds punya
	public static final String DRIVERCLASS_SQL_SERVER = "net.sourceforge.jtds.jdbc.Driver";
	public static final String DRIVERCLASS_POSTGRE="org.postgresql.Driver";
	public static final String DRIVERCLASS_MYSQL="com.mysql.jdbc.Driver";
	public static final String DEFAULT_DB = DB_MYSQL;
	
	/*global variable*/
	public static final String PARAM_DB_TYPE = "DBTYPE";
	public static final String PARAM_DB_NAME = "DBNAME";
	public static final String PARAM_TBL_NAME = "TBL_NAME";
	public static final String PARAM_OBJECT_TYPE = "OBJECT_TYPE";
	public static final String PARAM_OBJECT_TABLE ="TABLE";
	public static final String PARAM_OBJECT_VIEW ="VIEW";

	
}
