package com.muhammadthahir.Selemene.config.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConnection {
	
	public String dbtype = "MySQL";
	public String server = "localhost";
	public String userName ="root";
	public String password = "";
	
	
	@Test
	public void TestQueryMySql() throws SQLException{
		Connection hilihConnect = new Connection(server, userName, password, 0, dbtype);
		CommonQuery cQy = new CommonQuery();
		String sql =cQy.getDatabases(dbtype);
		System.err.println("sql : " + sql);
		List<Map<String, Object>> result = hilihConnect.getQuery_Result(sql);
		System.out.println("database : " + new Gson().toJson(result));
	}
}
