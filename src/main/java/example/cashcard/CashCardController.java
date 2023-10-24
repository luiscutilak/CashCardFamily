package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Vamos atualizar nossa classe CashCardController para que ele esteja configurado para escutar e lidar com solicitações HTTP
 * inserindo as Annotations.
 */
@RestController
@RequestMapping("/cashcards")

public class CashCardController {

    @GetMapping("/{requestId}")
    /*
     1º Adicionando método manipulador(handler method), findById 
    para lidar com solicitações HTTP recebidas.
     */ 
    public ResponseEntity<CashCard> findById(@PathVariable Long requestId) {
        if (requestId.equals(99L)) {
            CashCard cashCard = new CashCard(99L, 123.45);
            return ResponseEntity.ok(cashCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
