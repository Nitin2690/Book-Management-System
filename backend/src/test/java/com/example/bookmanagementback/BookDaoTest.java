package com.example.bookmanagementback;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




class BookDaoTest {
	
	private BookDao dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("system");
		datasource.setPassword("meena");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new BookDao(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {

		List <Book> ls = dao.list();
		assertTrue(ls.isEmpty());
	}

	@Test
	void testSave() {
		Book b = new Book("The Power", "Joseph murphy","ram das","online",340,120);
		dao.save(b);
	}
	@Test
	void testGet() {
		int id = 4;
		Book b = dao.get(id);
		System.out.println(b);
		assertNotNull(b);
	}

	@Test
	void testUpdate() {
		Book b = new Book();
		b.setId(1);
		b.setName("subtract");
		b.setAuthor("sdf");
		b.setPublisher("unknown");
		b.setNumberofpages(10);
		b.setPrice(10);
		b.setBooktype("paper");
		dao.update(b);

	}
	
	@Test
	void testDelete() {
		int id = 4;
		dao.delete(id);
	}

}
