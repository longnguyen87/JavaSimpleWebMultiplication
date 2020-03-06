package multiplication.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import multiplication.controller.CheckResultController.ResultResponse;
import multiplication.domain.MultiplicationResultAttempt;
import multiplication.service.MultiplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CheckResultController.class)
public class CheckResultControllerTest {
	@MockBean
	private MultiplicationService service;

	@Autowired
	private MockMvc mvc;
	private JacksonTester<MultiplicationResultAttempt> jsonResult;
	private JacksonTester<ResultResponse> jsonResponse;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void postResultReturnCorrect() throws Exception {
		genericParameterizedTest(true);
	}

	@Test
	public void postResultReturnNotCorrect() throws Exception {
		genericParameterizedTest(false);
	}

	private void genericParameterizedTest(boolean b) throws Exception {
		// given
		given(service.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(b);

	}
}
