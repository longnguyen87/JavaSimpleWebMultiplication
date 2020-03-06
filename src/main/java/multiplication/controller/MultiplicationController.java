package multiplication.controller;

import org.springframework.web.bind.annotation.RestController;

import multiplication.service.MultiplicationService;

/*
 * This controller will perform the following functions:
 * 1. return Multiplication for GET: /multiplication/random
 * 2. Received user POST response
 * 3. return Boolean result when user check attempt
 */
@RestController
public class MultiplicationController {
	
	private final MultiplicationService service;
	// Using autowired to inject dependency

	public MultiplicationController(final MultiplicationService service) {
		super();
		this.service = service;
	}
	
}
