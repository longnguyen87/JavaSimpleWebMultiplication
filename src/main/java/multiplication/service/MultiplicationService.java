package multiplication.service;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
	Multiplication createRandomMultiplication ();
	// Adding additional codes to this interface
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
	
}
