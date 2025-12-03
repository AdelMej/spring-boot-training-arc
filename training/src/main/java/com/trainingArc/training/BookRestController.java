package com.trainingArc.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	@GetMapping("/book")
	public String get(@RequestParam String bookName, @RequestParam Integer bookPages) {
		
		System.out.println(bookName);
		System.out.println(bookPages);
		
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
