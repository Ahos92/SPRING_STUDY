package com.kgitbank.dbconfig;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTests {

	@Before
	public void loadDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("driver found");
			
		} catch (ClassNotFoundException e) {
			log.error("drvier not found");
		}
	}
	
	
	@Test
	public void test() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "hr";
				
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			log.info("Connection Àß °¡Á®¿È : " + conn);
			
		} catch (SQLException e) {
			log.error("Connection ¸ø °¡Á®¿È : " + e.getMessage());
		}
	}
}
