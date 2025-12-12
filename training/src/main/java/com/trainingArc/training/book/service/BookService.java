package com.trainingArc.training.book.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.trainingArc.training.book.exception.BookCreationException;
import com.trainingArc.training.book.model.BookEntity;
import com.trainingArc.training.book.persistence.BookRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	public String createBook(String bookName, Integer bookPages) throws BookCreationException {
	
		if (bookName == null || StringUtils.isBlank(bookName)) {
			// return "Le bookName ne peut pas être null ou vide";
			throw new BookCreationException("Le nom du Livre ne peut pas être null");
		}
		
		if (bookPages == null || bookPages < 1) {
			throw new BookCreationException("Le nombre de page ne peut pas <= 0");
		}
		
		if(bookPages == null || bookPages <= 0) {
			
			return "Le nombre de page ne peut pas être <= 0";
			
		}

		BookEntity existingbook = bookRepository.findByNameAndPages(bookName, bookPages);

		if (existingbook == null) {
			
			BookEntity newBook = BookEntity.builder()
										.name(bookName)
										.pages(bookPages)
										.build();
			
			bookRepository.save(newBook);
			
			return "le livre a été crée";
			
		} else {
			
			throw new BookCreationException("le livre existe déjà");
		}
		
	}
	
}
