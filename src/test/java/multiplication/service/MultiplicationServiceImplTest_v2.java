package multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

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
		// TODO: Need to change this implementation, that would depend on how
		// MultiplicationResultAttempt was implemented.
		Multiplication mulStub = new Multiplication(50, 60);
		User user = new User("long");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mulStub, 3000, false);
		// Checking condition
		boolean attemptResult = service.checkAttempt(attempt);
		assertThat(attemptResult).isTrue();
	}

	@Test
	public void checkWrongAttemptTest() {
		// Create some stubs, giving wrong value
		Multiplication mulStub = new Multiplication(50, 60);
		User user = new User("long");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mulStub, 3010, false);
		boolean attemptResult = service.checkAttempt(attempt);
		assertThat(attemptResult).isFalse();
	}
}
