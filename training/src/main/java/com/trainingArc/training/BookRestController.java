package com.trainingArc.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
	
	@GetMapping("/book")
	public String get() {
		
		
		
		return "abcd";
	}
	
}
