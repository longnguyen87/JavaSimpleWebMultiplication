package multiplication.service;


import static org.assertj.core.api.Assertions.assertThat; 

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;
import multiplication.domain.User;

/*
 * This class - as created in chapter 3, will mainly concern with testing the CheckAttempt method
 */

public class MultiplicationServiceImplTest_v2 {
	
	private MultiplicationService service;
	
	@Before
	public void init() {
		service = new MultiplicationServiceImpl(new RandomGeneratorServiceImpl());
	}
	@Test
	public void checkCorrectAttemptTest() {
		// Create some stubs
		Multiplication mulStub = new Multiplication(50, 60);
		User user = new User("long");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mulStub	, 3000);
		// Checking condition
		boolean attemptResult = service.checkAttempt(attempt);
		assertThat(attemptResult).isTrue();
	}
}
