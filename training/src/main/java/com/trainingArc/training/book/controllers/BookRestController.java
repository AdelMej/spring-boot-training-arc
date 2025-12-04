package com.trainingArc.training.book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainingArc.training.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookRestController {

    private final BookService bookService;

    BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

	
	@GetMapping("/book")
	public String get(@RequestParam String bookName, @RequestParam Integer bookPages) {
		
		System.out.println(bookName);
		System.out.println(bookPages);
		
		String response = bookService.createBook(bookName, bookPages);
		
		return response;
	}
	
}
