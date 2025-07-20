package dio.api_loja.controller;

import dio.api_loja.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private List<Produto> produtos = new ArrayList<>();
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        boolean removido = produtos.removeIf(p -> p.getId().equals(id));

        if (removido) {
            return ResponseEntity.ok("Produto removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        for(Produto p : produtos){
            if (p.getId().equals(id)){
                p.setPreco(produtoAtualizado.getPreco());
                p.setId(produtoAtualizado.getId());
                p.setNome(produtoAtualizado.getNome());
                return ResponseEntity.ok("Produto atualizado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }

}
