package com.antoine.book_club.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.antoine.book_club.models.Book;
import com.antoine.book_club.models.User;
import com.antoine.book_club.services.BookService;
import com.antoine.book_club.services.UserService;

@Controller
public class BookController {
	@Autowired
	BookService bookServ;
	@Autowired 
	UserService userServ;
	
	// ----------- READ ALL ---------------//
	@GetMapping("/books")
	public String index(
		@ModelAttribute("userObj") User filledUser,
		HttpSession session, Model model
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("userName", userServ.getOneUser((Long) session.getAttribute("user_id")));
		model.addAttribute("allBooks", bookServ.getAll());
		return "/books/index.jsp";
		
	}
	
	
	// ---------- CREATE -----------------//
	
	@GetMapping("/books/new")
	public String newBook(
		@ModelAttribute("bookObj") Book emptyBook,
		HttpSession session
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "/books/new.jsp";
	}
	
	@PostMapping("/books/new")
	public String processBook(
		@Valid @ModelAttribute("bookObj") Book filledBook,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "/books/new.jsp";
		}
		@SuppressWarnings("unused")
		Book newBook = bookServ.create(filledBook);
		return "redirect:/books";
//		return "redirect:/books/" + newBook.getId();
	}
	// ---------- CREATE -----------------//
	
	// ---------- READ ONE --------------//
	@GetMapping("/books/{id}")
	public String oneBook(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("oneBook", bookServ.getOne(id) );
		return "/books/show.jsp";
	}
	// ---------- READ ONE --------------//
	
	// ---------- UPDATE --------------//
	@GetMapping("/books/{id}/edit")
	public String edit(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("bookObj", bookServ.getOne(id));
		return "/books/edit.jsp";
	}
	@PutMapping("/books/{id}/edit")
	public String update(
		@Valid @ModelAttribute("bookObj") Book filledBook,
		BindingResult results
	) {
		if(results.hasErrors()) {
			return "/books/edit.jsp";
		}
		bookServ.create(filledBook);
		return "redirect:/books";
	}
	// ---------- UPDATE --------------//
	
	// ---------- DELETE --------------//
	@GetMapping("/books/{id}/delete")
	public String delete(
		@PathVariable("id") Long id
	) {
		bookServ.deleteOne(id);
		return "redirect:/books";
	}
	@DeleteMapping("/books/{id}")
	public String deleteBook(
		@PathVariable("id") Long id
	) {
		bookServ.deleteOne(id);
		return "redirect:/books";
	}
	// ---------- DELETE --------------//
}