package example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashcardApplicationTests {
	@Autowired

	TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcard99", String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
