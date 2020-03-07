package multiplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	private RandomGeneratorService randomGenerator;

	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGenerator) {
		super();
		this.randomGenerator = randomGenerator;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factor1 = randomGenerator.generateRandomFactor();
		int factor2 = randomGenerator.generateRandomFactor();
		return new Multiplication(factor1, factor2);
	}

	@Override
	public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
		Multiplication mul = resultAttempt.getMultiplication();
		int correctResult = mul.getFactor1() * mul.getFactor2();
		boolean correct = correctResult == resultAttempt.getResultAttempt();
		Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct");

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(resultAttempt.getUser(),
				resultAttempt.getMultiplication(), resultAttempt.getResultAttempt(), correct);
		return correct;
	}

}
