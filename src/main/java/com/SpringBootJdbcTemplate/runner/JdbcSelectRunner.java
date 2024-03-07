package com.SpringBootJdbcTemplate.runner;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.SpringBootJdbcTemplate.mappper.BookRowMapper;
import com.SpringBootJdbcTemplate.model.Book;
@Component
public class JdbcSelectRunner implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		String sql="SELECT * FROM BOOK";
		 RowMapper<Book> rowMapper=new BookRowMapper();
		 List<Book> list=jt.query(sql, rowMapper);
		 //JDK 1.5 - for each
//		 for(Book book : list) {
//			 System.out.println(book);
//		 }
		 
		 //JDK 1.2 - Iterator
//		 Iterator<Book> itr=list.iterator();
//		 while(itr.hasNext()) {
//			 Book book= itr.next();
//			 System.out.println(book);
//		 }
		 //JDK 1.8 - forEach method + Lambda Expression
		 //list.forEach(book -> System.out.println(book));
		 
		 //JDK 1.8 - forEach method + Method Reference
		// list.forEach(System.out::println);
		 
		 List<String> listStr=
		 list.stream()
		 .filter(ob->ob.getBookCost()>400.0)
		 .sorted((ob1,ob2)->ob1.getBookName().compareTo(ob2.getBookName()))
		 .map(ob->ob.getBookName()+", with id: "+ob.getBookId()+" having cost: "+ob.getBookCost())
		 .collect(Collectors.toList())
		 ;
		 listStr.forEach(System.out::println);
		 */
		
		/*
		
		String sql="SELECT * FROM BOOK WHERE BID>?";
		List<Book> list=jt.query(sql, 
				(rs, rowNum)->new Book(rs.getInt("bid"), rs.getString("bname"), rs.getDouble("bcost")), 
				102);
		list.forEach(System.out::println);
		*/
		// OR
		
		/*
			jt.query("SELECT * FROM BOOK WHERE BID>?", 
				(rs, rowNum)->new Book(rs.getInt("bid"), rs.getString("bname"), rs.getDouble("bcost")), 
				102).forEach(System.out::println);
		*/
		//=================
		/*
		// Fetch only one row data
		String sql="SELECT * FROM BOOK WHERE BID=?";
		RowMapper<Book> rowMapper=new BookRowMapper();
		Book book=jt.queryForObject(sql, rowMapper, 103);
		System.out.println(book);
		*/
		
		// Complex Structure
		Book book=jt.queryForObject(
				"SELECT * FROM BOOK WHERE BID=?", 
				(rs, rowNum) -> new Book(
								rs.getInt("bid"),
								rs.getString("bname"),
								rs.getDouble("bcost")
				), 
				102);
		System.out.println(book);
		
	}

}
