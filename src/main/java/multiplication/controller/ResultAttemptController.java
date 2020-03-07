package multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
	ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt attempt) {
		return ResponseEntity.ok(new ResultResponse(service.checkAttempt(attempt)));
	}

	@RequiredArgsConstructor
	@NoArgsConstructor(force = true)
	@Getter
	static final class ResultResponse {
		private final boolean correct;
	}
}
