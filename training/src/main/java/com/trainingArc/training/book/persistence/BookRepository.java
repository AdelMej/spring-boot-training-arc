package com.trainingArc.training.book.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingArc.training.book.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
	
	public BookEntity findByNameAndPages(String name, Integer pages);
}
