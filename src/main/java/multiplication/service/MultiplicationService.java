package multiplication.service;

import java.util.List;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
	/**
	 * Create random multiplication with factors in the range of 11-100
	 * 
	 * @return instance of multiplication object.
	 */
	Multiplication createRandomMultiplication();

	/**
	 * 
	 * @param resultAttempt
	 * @return
	 */
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

	/**
	 * Get statistics for a given user.
	 * 
	 * @param userAlias
	 * @return a list of {@link MultiplicationResultAttempt} object
	 */
	List<MultiplicationResultAttempt> getStatsForUser(final String userAlias);
}
