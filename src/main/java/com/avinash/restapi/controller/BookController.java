package com.avinash.restapi.controller;

import java.util.List;
import java.util.Optional;

import com.avinash.restapi.model.Book;
import com.avinash.restapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//public class BookController {
//
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
//	@ResponseBody
//	public String getBooks() {
//		return "this is testing book first";
//	}
//}

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// @GetMapping("/books")
	// public Book getBooks() {
	// Book book = new Book();
	// book.setId((long) 12345);
	// book.setTitle("advance java");
	// book.setAuthor("santosh kuamr");
	// return book;
	// }

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}

	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);

			// return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") long id) {

		try {
			this.bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long id) {

		try {
			this.bookService.updateBook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/books/")
	public ResponseEntity<Book> updateBookByObj(@RequestBody Book book) {

		try {
			this.bookService.updateBookByObj(book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
