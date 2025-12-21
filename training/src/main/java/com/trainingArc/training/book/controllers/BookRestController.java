package com.trainingArc.training.book.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trainingArc.training.book.dto.BookDTO;
import com.trainingArc.training.book.exception.BookCreationException;
import com.trainingArc.training.book.model.BookEntity;
import com.trainingArc.training.book.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

	
	@GetMapping
	public String get(@RequestParam String bookName, @RequestParam Integer bookPages) {
		
//		log.info(bookName);
//		log.info(String.valueOf(bookPages));
//		
//		String response = bookService.createBook(bookName, bookPages);
//		
//		return response;
	
		return "ok GET";

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO.Postoutput post(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {

		
		log.info(input.getBookName());
		log.info(String.valueOf(input.getBookPages()));
		
		// TODO : Update create book method
		BookEntity newBook = bookService.createBook("", input.getBookName(), input.getBookPages());
		
		// TODO : Update getter issues
		return BookDTO.Postoutput.builder()
				.id(newBook.getId())
				.bookName(newBook.getName())
				.bookPages(newBook.getPages())
				.build();
	}
	
}
