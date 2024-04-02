package Source.Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Source.Enums.pedidosStatus;

public class Pedidos {
    private Date momento;
    private pedidosStatus status;

    private Produtos produtos;
    private Cliente cliente;
    private List<pedidosItems> items = new ArrayList<>();

    @SuppressWarnings("unused")
    private Pedidos(){}

    public Pedidos(String dataHoraFormatada, pedidosStatus status, Cliente cliente) throws ParseException {
        SimpleDateFormat sdfHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.momento = sdfHora.parse(dataHoraFormatada);
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public pedidosStatus getStatus() {
        return status;
    }

    public void setStatus(pedidosStatus status) {
        this.status = status;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public List<pedidosItems> getItems() {
        return items;
    }

    // Metodos
    
    public void adicionarItems(pedidosItems item){
        items.add(item);
    }

    public void removerItems(pedidosItems item){
        items.remove(item);
    }

    public double total(){
        double total = 0.0;
        for (pedidosItems item : items){
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }

    public String toString(){
        SimpleDateFormat sdfHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String momentoFormatado = sdfHora.format(momento);

        StringBuilder pedidos = new StringBuilder();
        pedidos.append("Horario do pedido: " + momentoFormatado +"\n");
        pedidos.append("Status do pedido: " + status + "\n");
        pedidos.append("Cliente: " + cliente + "\n");
        pedidos.append("Pedidos: " + "\n");

        for (pedidosItems item : items){
            pedidos.append(item.getProduto().getNome())
            .append(", R$")
            .append(item.getPreco())
            .append(", ")
            .append("Quantidade: ").append(item.getQuantidade())
            .append(", ")
            .append("Subtotal: ").append(item.subTotal())
            .append("\n");
        }
        pedidos.append("Preço total: " + total());
        return pedidos.toString();
    }    
}
