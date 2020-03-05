package multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
 * This class will return an object that represent a multiplication
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {
	private final int factor1;
	private final int factor2;

	Multiplication() {
		this(0,0);
	}
	
}
