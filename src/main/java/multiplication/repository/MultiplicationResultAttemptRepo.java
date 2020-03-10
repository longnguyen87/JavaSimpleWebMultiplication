package multiplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationResultAttemptRepo extends CrudRepository<MultiplicationResultAttempt, Long> {
	List<MultiplicationResultAttempt> findTop5ByuserAliasOrderByIdDesc(String userAlias);
}
