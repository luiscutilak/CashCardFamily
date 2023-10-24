package example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

//Isso iniciará nosso aplicativo Spring Boot e o disponibilizará para nosso teste realizar solicitações a ele.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashcardApplicationTests {

	// Pedimos ao Spring para injetar um auxiliar de teste que nos permitirá fazer solicitações HTTP para o aplicativo em execução localmente.
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {

		// Aqui usamos restTemplate para fazer uma solicitação HTTP GET para o endpoint do nosso aplicativo /cashcards/99.

		/*restTemplate retornará um ResponseEntity, que capturamos em uma variável que chamamos de resposta. ResponseEntity é outro objeto Spring útil que fornece informações valiosas sobre o que aconteceu com nossa solicitação.
		*/

		ResponseEntity<String> response = restTemplate.getForEntity("/cashcard99", String.class);
		
		//Podemos inspecionar muitos aspectos da resposta, incluindo o código de status da resposta HTTP, que esperamos ser 200 OK.
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
