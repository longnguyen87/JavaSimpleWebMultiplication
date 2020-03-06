package multiplication.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import multiplication.domain.Multiplication;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest_v1 {
	@MockBean
	private RandomGeneratorService randomGeneratorService;
	
	@Autowired
	private MultiplicationService multiplicationService;
	
	@Test
	public void createRandomMultiplicationTest() {
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		assertThat(multiplication.getFactor1()).isEqualTo(50);
		assertThat(multiplication.getFactor2()).isEqualTo(30);
//		assertThat(multiplication.getResult()).isEqualTo(1500);
	}
	
}
