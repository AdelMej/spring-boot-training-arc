package com.trainingArc.training.book.service;

import org.springframework.stereotype.Service;

import com.trainingArc.training.book.exception.BookCreationException;
import com.trainingArc.training.book.model.BookEntity;
import com.trainingArc.training.book.persistence.BookRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class BookService {

    private final BookRepository bookRepository  ;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	public BookEntity createBook(String isbn, String bookName, Integer bookPages) throws BookCreationException {
	
		if (isbn == null || isbn.isBlank()) {
			throw new BookCreationException("L'ISBN d'un livre ne peut pas être null ou vide");
		}
		
		if (!BookService.isValidIsbn13(isbn)) {
			throw new BookCreationException("L'ISBN du livre doit être valide");
		}

		if (bookName == null || StringUtils.isBlank(bookName)) {
			// return "Le bookName ne peut pas être null ou vide";
			throw new BookCreationException("Le nom du Livre ne peut pas être null");
		}
		 
		if (bookPages == null || bookPages < 1) {
			throw new BookCreationException("Le nombre de page ne peut pas <= 0");
		}

		// TODO : Update fetch method
		// BookEntity existingbook = bookRepository.findByIsbn(Isbn);
		BookEntity existingbook = bookRepository.findByNameAndPages(bookName, bookPages);
		
		if (existingbook != null) {
			throw new BookCreationException("le livre existe déjà");
		}
		
		// TODO : Update creation
		BookEntity newBook = BookEntity.builder()
									.name(bookName)
									.pages(bookPages)
									.build();
			
		bookRepository.save(newBook);
			
		return newBook;
			
	}
	
	
	public static boolean isValidIsbn13(String rawIsbn) {
		
		if (rawIsbn == null) {
			return false;
		}
		
		String isbn = rawIsbn.replaceAll("[\\s-]+", "");
		
		if (!isbn.matches("\\d{13}")) {
			return false;
		}
		
		return true;
		
//		int sum = 0;
//
//		for (int i = 0; i < 12; i++) {
//			int digit = isbn.charAt(i) - '0';
//			
//			if (i % 2 == 0) {
//				sum += digit;
//			} else {
//				sum += 3 * digit;
//			}
//		}
//
//		int modulo = sum % 10;
//		int expectedCheckDigit = (10 - modulo) % 10;
//		
//		int actualCheckDigit = isbn.charAt(12) - '0';
//		
//		return expectedCheckDigit == actualCheckDigit;
	}
}

