package dio.api_loja.controller;

import dio.api_loja.model.Pedido;
import dio.api_loja.model.Produto;
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

    @PutMapping("/{id}")
    public ResponseEntity<String> editarProduto(@PathVariable Long id, @RequestBody Pedido novoPedido){
        for(Pedido p : pedidos){
            if(p.getIdPedido().equals(id)){
                p.setIdPedido(novoPedido.getIdPedido());
                p.setProdutos(novoPedido.getProdutos());
                p.setPrecoTotal(novoPedido.getPrecoTotal());
                return ResponseEntity.ok("Produto Editado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }

}
