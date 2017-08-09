/**
 * 
 */
package com.muhammadthahir.Selemene.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammadthahir.Selemene.config.GlobalVariable;


/**
 * @author muhammad.thahir
 *
 */
@RestController
@RequestMapping("/list")
public class DatabaseObject extends GlobalVariable {
		
	@RequestMapping("/db")
	public List<Map<String,Object>> getListOfDatabase(){		
		return null;
	}			
}
