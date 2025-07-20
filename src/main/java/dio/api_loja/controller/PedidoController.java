package dio.api_loja.controller;

import dio.api_loja.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();
    @GetMapping
    public List<Pedido> listarProdutos() {
        return pedidos;
    }

    @PostMapping
    public Pedido adicionarProduto(@RequestBody Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        boolean removido = pedidos.removeIf(p -> p.getIdPedido().equals(id));

        if (removido) {
            return ResponseEntity.ok("Pedido removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido não encontrado.");
        }
    }

}
