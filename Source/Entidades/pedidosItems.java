package Source.Entidades;

public class pedidosItems {
    private Integer quantidade;
    private Double preco;

    @SuppressWarnings("unused")
    private pedidosItems(){}

    private Produtos produto;

    public pedidosItems(Integer quantidade, Double preco, Produtos produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProduto() {
        return produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public double subTotal(){
        return quantidade * preco;
    }
}
