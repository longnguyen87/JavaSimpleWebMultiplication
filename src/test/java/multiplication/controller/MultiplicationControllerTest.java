package multiplication.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import multiplication.domain.Multiplication;
import multiplication.service.MultiplicationService;


@RunWith(SpringRunner.class)
@WebMvcTest (MultiplicationController.class)
public class MultiplicationControllerTest {
	// First test. Test that the controller will return a random multiplication
	
	@MockBean
	private MultiplicationService service;
	
	@Autowired
	private MockMvc mvc;
	
	private JacksonTester<Multiplication> json;
	
	@Before
	public void setup () {
		JacksonTester.initFields(this, new ObjectMapper());
	}
	
	@Test
	public void getRandomMultiplicationTest () throws Exception {
		Multiplication mockMul = new Multiplication(30, 50);
		given(service.createRandomMultiplication()).willReturn(mockMul);
		MockHttpServletResponse response = mvc.perform(get("/multiplications/random").accept(MediaType.APPLICATION_JSON))
									.andReturn().getResponse();
		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(json.write(mockMul).getJson());
	}
}
