package com.example.bookmanagementback;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class BookDao {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BookDao(JdbcTemplate jdbcTemplate2) {
		super();
		this.jdbcTemplate = jdbcTemplate2;
	}

	public List<Book> list(){
		String sql = "SELECT * FROM Books";
		List<Book> listbook = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
		return listbook;
	}
	
	public void save(Book books) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Books").usingColumns("name","author","publisher","booktype","numberofpages","price");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(books);
		insertActor.execute(param);
	}
	
	public Book get(int id) {
		String sql = "Select * from Books where id = ?";
		Object[] args = {id};
		@SuppressWarnings("deprecation")
		Book book = jdbcTemplate.queryForObject(sql, args,BeanPropertyRowMapper.newInstance(Book.class));
		
		return book;
	}

	public void update(Book book) {
		String sql = "UPDATE Books SET name=:name, price=:price, publisher=:publisher, author=:author, booktype=:booktype, numberofpages=:numberofpages WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(book);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	public void delete(int id) {
	String sql = "Delete from Books where id = ?";
	jdbcTemplate.update(sql,id);
	}
	
	
}
