package com.antoine.book_club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoine.book_club.models.Book;
import com.antoine.book_club.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	// CREATE & UPDATE
	public Book create(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	// READ ONE
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// READ ALL
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	// DELETE
	public void deleteOne(Long id) {
		bookRepo.deleteById(id);
	}
}