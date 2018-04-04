package com.muhammadthahir.Selemene.controller.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhammadthahir.Selemene.config.GlobalVariable;
import com.muhammadthahir.Selemene.config.db.CommonQuery;
import com.muhammadthahir.Selemene.config.db.Connection;

@RestController
public class RestControllerClass {
	private CommonQuery cQy = new CommonQuery();
	
	private String ServerName = "localhost"; 
	
	@RequestMapping(value="/getListOfDatabases")
	public List<Map<String,Object>> getListOfDataBases(HttpSession session) throws SQLException{
		
		String userName="";
		String pass ="";
		String sql="";
		if(session.getAttribute(GlobalVariable.PARAM_DB_TYPE) == null || session.getAttribute(GlobalVariable.PARAM_DB_TYPE) == "" ){			
			session.setAttribute(GlobalVariable.PARAM_DB_TYPE, GlobalVariable.DEFAULT_DB);
		}
		
		String dbType = session.getAttribute(GlobalVariable.PARAM_DB_TYPE).toString();
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(dbType)){
			userName = "sa";
			pass = "123456";						
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(dbType)){
			userName = "postgres";
			pass = "admin";			
		}		
		Connection  coreConnect = new Connection(ServerName, userName, pass, 0, dbType);
		sql = cQy.getDatabases(dbType);		
		return coreConnect.getQuery_Result(sql);
		
	}
			
	
	
	@RequestMapping(value="/getListOfDbObject")
	public List<Map<String, Object>> getListOfDbObject(
			HttpSession session,
			@RequestParam(value="dbname") String DbName,
			@RequestParam(value="objectType") String type) throws SQLException{		
		String userName="";
		String pass ="";
		String sql="";
		if(session.getAttribute(GlobalVariable.PARAM_DB_TYPE) == null || session.getAttribute(GlobalVariable.PARAM_DB_TYPE) == "" ){			
			session.setAttribute(GlobalVariable.PARAM_DB_TYPE, GlobalVariable.DEFAULT_DB);
		}
		String dbType = session.getAttribute(GlobalVariable.PARAM_DB_TYPE).toString();
		if(GlobalVariable.DB_SQL_SERVER.equalsIgnoreCase(dbType)){
			userName = "sa";
			pass = "123456";						
		}
		else if(GlobalVariable.DB_POSTGRESQL.equalsIgnoreCase(dbType)){
			userName = "postgres";
			pass = "admin";			
		}
		
		Connection  coreConnect = new Connection(ServerName, userName, pass, 0, dbType);
		System.out.println("the Db Name : " + DbName);
		System.out.println("the database object  is : " + type);
		
		sql = cQy.getObjectFromDb(dbType, DbName, type);
		System.out.println("the sql nya : " + sql);
		return coreConnect.getQuery_Result(sql);
	}
	
		
	@RequestMapping(value="/switchDBDriver")
	public String changeDefaultDB(@RequestParam(value=GlobalVariable.PARAM_DB_TYPE, required=false) String db_type,HttpSession session){
		session.setAttribute(GlobalVariable.PARAM_DB_TYPE, db_type);
		String msg = "";
		if(db_type != null && db_type !="") msg = "Switching database driver to " + db_type;
		msg +="now the db driver is :" + db_type;
		return msg;
		
	}

	
	
}
