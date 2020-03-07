package multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class MultiplicationResultAttempt {
	private final User user;
	private final Multiplication multiplication;
	private final int resultAttempt;
	private final boolean correct; // this class is used to indicate that a result is correct, or not

	MultiplicationResultAttempt() {
		// TODO Auto-generated constructor stub
		user = null;
		multiplication = null;
		resultAttempt = -1;
		correct = false;
	}
}
