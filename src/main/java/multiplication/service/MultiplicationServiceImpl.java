package multiplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;
@Service
public class MultiplicationServiceImpl implements MultiplicationService	{
	
	private RandomGeneratorService randomGenerator ;
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
				
		return correctResult == resultAttempt.getResultAttempt();
	}
	

}
