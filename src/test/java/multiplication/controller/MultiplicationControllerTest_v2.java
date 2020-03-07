package multiplication.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import multiplication.domain.Multiplication;
import multiplication.service.MultiplicationService;

/*
 * In this test class, I will implement different way of testing controller
 * Without using the WebMvcTest annotation
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MultiplicationController.class)
public class MultiplicationControllerTest_v2 {

	@MockBean
	private MultiplicationService service;

	@Autowired
	private MockMvc mvc;
	JacksonTester<Multiplication> json;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void getRandomMultiplicationTest() throws Exception {
		// given
		Multiplication mockMul = new Multiplication(30, 50);
		given(service.createRandomMultiplication()).willReturn(mockMul);
		// when

		this.mvc.perform(get("/multiplications/random").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
