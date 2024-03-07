package com.SpringBootJdbcTemplate.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//@Component
public class JdbcTestRunner implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jt;
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(jt.getClass().getName());

		//1. INSERT OPERATION
		String sql="INSERT INTO BOOK VALUES(?,?,?)";
		//1. UPDATE OPERATION
		//String sql="UPDATE BOOK SET BNAME=?, BCOST=? WHERE BID=?";
		//1. DELETE OPERATION
		//String sql="DELETE FROM BOOK WHERE BID=?";

		//2. Execute and get result 
		int count=jt.update(sql, 104, "AI", 900.0);
		//int count=jt.update(sql, "Advanced Java", 900.0, 102);
		//int count=jt.update(sql, 102);
		//3. print result
		System.out.println("NO OF ROWS INSERTED!!: "+count);
	}

}
