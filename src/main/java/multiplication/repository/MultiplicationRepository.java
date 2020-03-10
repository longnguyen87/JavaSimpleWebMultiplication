package multiplication.repository;

import org.springframework.data.repository.CrudRepository;

import multiplication.domain.Multiplication;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {

}
