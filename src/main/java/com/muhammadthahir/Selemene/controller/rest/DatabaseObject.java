/**
 * 
 */
package com.muhammadthahir.Selemene.controller.rest;



import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhammadthahir.Selemene.config.GlobalVariable;
import com.muhammadthahir.Selemene.config.db.Connection;
import com.muhammadthahir.Selemene.model.ConnectionProperties;


/**
 * @author muhammad.thahir
 *
 */
@RestController
public class DatabaseObject extends GlobalVariable {
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(value="/checkConnection", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> checkConnectionStatus(HttpSession session, @RequestBody ConnectionProperties connectionProperties){							
		Connection  coreConnect = new Connection(connectionProperties.getServerName(), connectionProperties.getUserName(), connectionProperties.getPassword(), connectionProperties.getPort(), connectionProperties.getDriver());		
		Map<String,Object> response = new HashMap<>();
		try {
			response.put("connect", coreConnect.getDriver().checkConnectionIsOpen());
		} catch (SQLException e) { 
			response.put("connect", false);			
			response.put("errMessage", e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/defaultDB", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> checkDefaultDb(HttpSession session){										
		Map<String,Object> response = new HashMap<>();
		response.put("default", DEFAULT_DB);
		return response;
	}
}
