package com.trainingArc.training.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


public class BookDTO {

	@Data
	@AllArgsConstructor
	@Builder
	public static class PostInput {
	
	String bookName;
	Integer bookPages;
		
	}
	
	public static class Postoutput {
		
		
		
	}
	
}
