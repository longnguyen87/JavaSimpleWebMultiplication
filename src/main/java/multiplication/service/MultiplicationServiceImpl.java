package multiplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;
import multiplication.domain.User;
import multiplication.repository.MultiplicationResultAttemptRepo;
import multiplication.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	private RandomGeneratorService randomGenerator;
	private MultiplicationResultAttemptRepo resultAttemptRepo;
	private UserRepository userRepo;

	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGenerator, MultiplicationResultAttemptRepo resultRepo,
			UserRepository userRepo) {

		super();
		this.randomGenerator = randomGenerator;
		this.resultAttemptRepo = resultRepo;
		this.userRepo = userRepo;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factor1 = randomGenerator.generateRandomFactor();
		int factor2 = randomGenerator.generateRandomFactor();
		return new Multiplication(factor1, factor2);
	}

	@Override
	public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
		Optional<User> user = userRepo.findByAlias(resultAttempt.getUser().getAlias());
		Multiplication mul = resultAttempt.getMultiplication();
		int correctResult = mul.getFactor1() * mul.getFactor2();
		boolean correct = correctResult == resultAttempt.getResultAttempt();
		Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct");

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
				user.orElse(resultAttempt.getUser()), resultAttempt.getMultiplication(),
				resultAttempt.getResultAttempt(), correct);
		resultAttemptRepo.save(checkedAttempt);
		return correct;
	}

	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
		// TODO Auto-generated method stub
		return resultAttemptRepo.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}

}
