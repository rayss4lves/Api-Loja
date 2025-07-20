package dio.api_loja.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    private Long idPedido;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(){
        this.produtos = produtos;
    }
    public Long getIdPedido(){
        return idPedido;
    }

    public void setIdPedido(Long id){
        this.idPedido = id;
    }
}
