package com.SpringBootJdbcTemplate.mappper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SpringBootJdbcTemplate.model.Book;

public class BookRowMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		//Read from RS, set to object
		//ob.set___(rs.get___("columname"));
		/*
		Book book=new Book();
		book.setBookId(rs.getInt("bid"));
		book.setBookName(rs.getString("bname"));
		book.setBookCost(rs.getDouble("bcost"));
		*/
		Book book=new Book(rs.getInt("bid"), rs.getString("bname"),rs.getDouble("bcost"));
		
		return book;
	}

}
