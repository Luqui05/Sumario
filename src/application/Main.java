package application;

import entities.Cliente;
import entities.Pedido;
import entities.Produto;
import entities.itemPedido;
import enums.statusPedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de aniversário (DD/MM/YYYY): ");
        String dataString = sc.nextLine();
        Date dataNascimento = sdf.parse(dataString);

        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Digite dados do pedido: ");
        System.out.print("Status: ");
        String stats = sc.next();
        statusPedido status = statusPedido.valueOf(stats);
        Pedido pedido = new Pedido(new Date(), status, cliente);
        System.out.print("Quantos itens no pedido? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Digite os dados do item #" + i);
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nome1 = sc.nextLine();
            System.out.print("Preço do produto: ");
            double preco = sc.nextDouble();

            Produto produto = new Produto(nome1, preco);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            itemPedido itemPedido = new itemPedido(quantidade, preco, produto);
            pedido.adicionarItem(itemPedido);
        }

        System.out.println();
        System.out.println("Sumário pedidos: ");
        System.out.println(pedido);

        sc.close();
    }
}
