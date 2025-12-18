package com.trainingArc.training.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BookDTO {

	@Data
	@AllArgsConstructor
	@Builder
	public static class PostInput {
	
	@NotNull
	@NotBlank
	String bookName;

	@NotNull
	Integer bookPages;
		
	}
	
	public static class Postoutput {
		
	String bookName;
	Integer bookPages;
		
	}
	
}
