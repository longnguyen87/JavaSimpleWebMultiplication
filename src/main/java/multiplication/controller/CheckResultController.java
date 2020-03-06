package multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import multiplication.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public final class CheckResultController {
	// Need to implement logic for user to check result of multiplication.
	private final MultiplicationService service;
	
	@Autowired
	public CheckResultController(MultiplicationService service) {
		super();
		this.service = service;
	}
	
	@RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse {
        private final boolean correct;
    }
	

}
