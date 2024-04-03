package Source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Source.Entidades.Cliente;
import Source.Entidades.Pedidos;
import Source.Entidades.Produto;
import Source.Entidades.PedidosItem;
import Source.Enums.pedidosStatus;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        try (Scanner scan = new Scanner(System.in)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Entre com os dados do cliente:");
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Data de aniversario (DD/MM/YYYY): ");
            Date dataAniversario = sdf.parse(scan.next());

            Cliente cliente = new Cliente(nome, email, dataAniversario);

            System.out.println();
            System.out.println("Entre o status do pedido:");
            System.out.print("Status: ");
            scan.nextLine(); // Consumir a quebra de linha pendente
            pedidosStatus status = pedidosStatus.valueOf(scan.nextLine());

            Pedidos pedidos = new Pedidos(status, cliente);

            System.out.println();
            System.out.print("Quantos items para esse pedido: ");
            int quantidadeItems = scan.nextInt();

            for (int i = 0; i < quantidadeItems; i++) {
                System.out.println("Entre os dados do pedido #" + (i + 1) + ": ");
                scan.nextLine(); // Consumir a quebra de linha pendente
                System.out.print("Nome do produto: ");
                String nomeProduto = scan.nextLine();
                System.out.print("Preço do produto: ");
                double precoProduto = scan.nextDouble();
                System.out.print("Quantidade: ");
                int quantidadeProduto = scan.nextInt();

                PedidosItem item = new PedidosItem(quantidadeProduto, precoProduto, new Produto(nomeProduto, precoProduto));
                pedidos.adicionarItem(item);
            }

            System.out.println(pedidos);
        }
    }
}
