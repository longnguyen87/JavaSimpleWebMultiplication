package multiplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multiplication.domain.Multiplication;
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
	

}
