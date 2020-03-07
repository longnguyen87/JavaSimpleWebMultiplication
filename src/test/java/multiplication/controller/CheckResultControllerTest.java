package multiplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import multiplication.domain.Multiplication;
import multiplication.domain.MultiplicationResultAttempt;
import multiplication.domain.User;
import multiplication.service.MultiplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ResultAttemptController.class)
public class CheckResultControllerTest {
	@MockBean
	private MultiplicationService service;

	@Autowired
	private MockMvc mvc;

	private JacksonTester<MultiplicationResultAttempt> jsonResult;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void postResultReturnCorrect() throws Exception {
		genericParameterizedTest(true);
	}

	@Test
	public void postResultReturnFalse() throws Exception {
		genericParameterizedTest(false);
	}

	private void genericParameterizedTest(final boolean b) throws Exception {
		// Step 1: Stub
		given(service.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(b);

		User user = new User("Long");
		Multiplication mul = new Multiplication(50, 70);
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, mul, 3500, b);
		// when
		MockHttpServletResponse response = mvc.perform(
				post("/results").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(attempt).getJson()))
				.andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString())
				.isEqualTo(jsonResult.write(new MultiplicationResultAttempt(user, mul, 3500, b)).getJson());
	}

}
