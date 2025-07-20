package dio.api_loja.model;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Double getPreco() {
        return preco;
    }
}
