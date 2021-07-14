package com.avinash.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.restapi.model.Book;
import com.avinash.restapi.repository.BookRepository;

//@Component
@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepostiry;

//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book((long)12, "java", "hari"));
//		list.add(new Book((long)13, "advance java", "santosh"));
//		list.add(new Book((long)14, "python", "avi"));
//	}
	
	//get all books
	
	public List<Book> getAllBooks(){
		return (List<Book>)this.bookRepostiry.findAll();
	}
	
	//get single book by id
	
	public Book getBookById(long id) {
		
		Book book = null;
		try {
			//book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepostiry.findById(id);	
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}
	
	//adding  a book
	public Book addBook(Book book) {
		//list.add(book);
		return this.bookRepostiry.save(book);
	}
	
	public void deleteBookById(long id) {
//		list=list.stream().filter(book->{
//			if(book.getId()!=id) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
//		list=list.stream().filter(book->book.getId()!=id)
//				.collect(Collectors.toList());
		this.bookRepostiry.deleteById(id);
	}
	
	public void updateBook(Book book, Long bookId) {
//		list = list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		this.bookRepostiry.save(book);
	}
	
	public void updateBookByObj(Book book) {
//		list = list.stream().map(b->{
//			if(b.getId()==book.getId()) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		this.bookRepostiry.save(book);
	}
}
