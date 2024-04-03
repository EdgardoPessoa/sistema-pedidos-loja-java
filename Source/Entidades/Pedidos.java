package Source.Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Source.Enums.pedidosStatus;

public class Pedidos {
    private Date momento;
    private pedidosStatus status;
    private Cliente cliente;
    private List<PedidosItem> itens;

    public Pedidos(pedidosStatus status, Cliente cliente) {
        this.momento = new Date(); // Current time
        this.status = status;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public Date getMomento() {
        return momento;
    }

    public pedidosStatus getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<PedidosItem> getItens() {
        return new ArrayList<>(itens); // Return a copy of the list to prevent external modification
    }

    public void adicionarItem(PedidosItem item) {
        itens.add(item);
    }

    public void removerItem(PedidosItem item) {
        itens.remove(item);
    }

    public double total() {
        double total = 0.0;
        for (PedidosItem item : itens) {
            total += item.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("Horario do pedido: ").append(sdfHora.format(momento)).append("\n");
        sb.append("Status do pedido: ").append(status).append("\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Pedidos:\n");
        for (PedidosItem item : itens) {
            sb.append("Produto: ").append(item.getProduto().getNome()).append(", ");
            sb.append("Preço: R$ ").append(String.format("%.2f", item.getPreco())).append(", ");
            sb.append("Quantidade: ").append(item.getQuantidade()).append(", ");
            sb.append("Subtotal: R$ ").append(item.subTotal()).append("\n");
        }
        sb.append("Preço total: ").append(total());
        return sb.toString();
    }
}
