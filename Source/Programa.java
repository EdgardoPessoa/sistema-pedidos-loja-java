package Source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Source.Entidades.Cliente;
import Source.Entidades.Pedidos;
import Source.Entidades.Produtos;
import Source.Entidades.pedidosItems;
import Source.Enums.pedidosStatus;

public class Programa {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com os dados do cliente:");
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Data de aniversario (DD/MM/YYYY): ");
        Date dataAniversario = sdf.parse(scan.next());

        System.out.println();
        System.out.println("Entre o status do pedido: ");
        scan.nextLine();
        System.out.print("Status: ");
        String status = scan.nextLine();
        Date dataHoraAtual = new Date();
        String dataHoraFormatada = sdfHora.format(dataHoraAtual);
        Pedidos pedidos = new Pedidos(dataHoraFormatada, pedidosStatus.valueOf(status), new Cliente(nome, email, dataAniversario));

        System.out.println();
  
        System.out.print("Quantos items para esse pedido: ");
        int quantidadeItems =  scan.nextInt();

        for (int i = 0; i < quantidadeItems; i++){
            System.out.println("Entre os dados do pedido #" + (i+1) + ": ");
            scan.nextLine();
            System.out.print("Nome do produto: ");
            String nomeProduto = scan.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = scan.nextDouble();
            System.out.print("Quantidade: ");
            int quantidadeProduto = scan.nextInt();
            pedidosItems pedidos_items = new pedidosItems(quantidadeProduto, precoProduto, new Produtos(nomeProduto, precoProduto));
            pedidos.adicionarItems(pedidos_items);
        }

        System.out.println(pedidos);
        scan.close();
        
    }
}
