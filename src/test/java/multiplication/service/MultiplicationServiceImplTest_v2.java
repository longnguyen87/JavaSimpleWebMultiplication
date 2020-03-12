package multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;
import multiplication.domain.User;
import multiplication.repository.MultiplicationResultAttemptRepo;
import multiplication.repository.UserRepository;

/*
 * This class - as created in chapter 3, will mainly concern with testing the CheckAttempt method
 */

public class MultiplicationServiceImplTest_v2 {

	private MultiplicationService service;

	@Mock
	private RandomGeneratorService randomGeneratorService;

	@Mock
	private MultiplicationResultAttemptRepo resultRepo;

	@Mock
	private UserRepository userRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new MultiplicationServiceImpl(randomGeneratorService, resultRepo, userRepo);
	}

	@Test
	public void checkCorrectAttemptTest() {
		// Create some stubs
		// TODO: Need to change this implementation, that would depend on how
		// MultiplicationResultAttempt was implemented.
		Multiplication mulStub = new Multiplication(50, 60);
		User user = new User("long");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mulStub, 3000, false);
		MultiplicationResultAttempt verifiedAttempt = new MultiplicationResultAttempt(user, mulStub, 3000, true);

		given(userRepo.findByAlias("long")).willReturn(Optional.empty());
		// Checking condition
		boolean attemptResult = service.checkAttempt(attempt);
		assertThat(attemptResult).isTrue();
		verify(resultRepo).save(verifiedAttempt);
	}

	@Test
	public void checkWrongAttemptTest() {
		// Create some stubs, giving wrong value
		Multiplication mulStub = new Multiplication(50, 60);
		User user = new User("long");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mulStub, 3010, false);

		given(userRepo.findByAlias("long")).willReturn(Optional.empty());

		boolean attemptResult = service.checkAttempt(attempt);

		assertThat(attemptResult).isFalse();
		verify(resultRepo).save(attempt);
	}

	@Test
	public void retrieveStatsTest() {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("john_doe");
		MultiplicationResultAttempt attempt1 = new MultiplicationResultAttempt(user, multiplication, 3010, false);
		MultiplicationResultAttempt attempt2 = new MultiplicationResultAttempt(user, multiplication, 3051, false);
		List<MultiplicationResultAttempt> latestAttempts = Lists.newArrayList(attempt1, attempt2);
		given(userRepo.findByAlias("john_doe")).willReturn(Optional.empty());
		given(resultRepo.findTop5ByUserAliasOrderByIdDesc("john_doe")).willReturn(latestAttempts);

		// when
		List<MultiplicationResultAttempt> latestAttemptsResult = service.getStatsForUser("john_doe");

		// then
		assertThat(latestAttemptsResult).isEqualTo(latestAttempts);
	}
}
