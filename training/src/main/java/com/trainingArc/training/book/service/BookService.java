package com.trainingArc.training.book.service;

import org.springframework.stereotype.Service;

import com.trainingArc.training.book.model.BookEntity;
import com.trainingArc.training.book.persistence.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	public String createBook(String bookName, Integer bookPages) {
		
		BookEntity existingbook = bookRepository.findByNameAndPages(bookName, bookPages);

		if (existingbook == null) {
			
			BookEntity newBook = BookEntity.builder()
										.name(bookName)
										.pages(bookPages)
										.build();
			
			bookRepository.save(newBook);
			
			return "le livre a été crée";
			
		} else {
			
			return "le livre existe déjà";
		}
		
	}
	
}
