package multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import multiplication.domain.Multiplication;
import multiplication.service.MultiplicationService;

/*
 * This controller will perform the following functions:
 * 1. return Multiplication for GET: /multiplication/random
 * 2. Received user POST response
 * 3. return Boolean result when user check attempt
 */
@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {
	
	private final MultiplicationService service;
	// Using autowired to inject dependency
	
	@Autowired
	public MultiplicationController(final MultiplicationService service) {
		super();
		this.service = service;
	}
	@GetMapping("/random")
	public Multiplication getRandomMultiplication () {
		// this method will return a Multiplication object
		return service.createRandomMultiplication();
	}
}
