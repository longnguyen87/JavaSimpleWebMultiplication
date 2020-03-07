package multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import multiplication.domain.MultiplicationResultAttempt;
import multiplication.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public final class ResultAttemptController {
	/*
	 * This class will receive user response
	 */
	private final MultiplicationService service;

	@Autowired
	ResultAttemptController(MultiplicationService service) {
		super();
		this.service = service;
	}

	@PostMapping
	ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt attempt) {
		boolean isCorrect = service.checkAttempt(attempt);
		return ResponseEntity.ok(new MultiplicationResultAttempt(attempt.getUser(), attempt.getMultiplication(),
				attempt.getResultAttempt(), isCorrect));
	}

}
