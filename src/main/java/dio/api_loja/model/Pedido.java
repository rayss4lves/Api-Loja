package dio.api_loja.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    private Long idPedido;
    private double precoTotal;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    public Long getIdPedido(){
        return idPedido;
    }

    public void setIdPedido(Long id){
        this.idPedido = id;
    }

    public double getPrecoTotal(){
        return precoTotal;
    }

    public void setPrecoTotal(double preco){
        this.precoTotal = preco;
    }

}
