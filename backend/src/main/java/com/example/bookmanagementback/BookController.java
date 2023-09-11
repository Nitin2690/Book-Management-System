package com.example.bookmanagementback;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class BookController {

	@Autowired
	private BookDao dao;

	@RequestMapping("/getBooks")
	public List<Book> show(){
		List<Book> listbooks = dao.list();
		System.out.println(listbooks);
		return listbooks;
		
	}
	@PostMapping("/postBook")
		public String postBook(@RequestBody Book book) {
			dao.save(book);
			return "successful";
		}
	
	@GetMapping("/editBook/{id}")
	public Book editbook(@PathVariable(name ="id") int id) {
		Book b = dao.get(id);
		return b;
	}
	
	@PutMapping("/updateBook")
	public String updateBook(@RequestBody Book book) {
		dao.update(book);
		return "UpdatedSuccesfully";
		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable(name="id") int id) {
		dao.delete(id);
		return "Deleted Successfully";
		
	}
	
}
