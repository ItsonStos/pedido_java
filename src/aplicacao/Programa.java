package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.ItemPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade.Enum.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente: ");	
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de Nascimento: (DD/MM/AAAA): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente clientes = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Entre com os dados do pedido: ");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, clientes);
		
		System.out.print("Quantos itens possui em seu pedido? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Entre com dados do #" + (1+i) + " pedido");
			System.out.print("Nome do produto :");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int qnt = sc.nextInt();
			
			Produto produtos = new Produto(nomeProduto, preco);
			ItemPedido ip = new ItemPedido(qnt, preco, produtos);
			
			pedido.addItem(ip);		
			
		}
		
		System.out.println();
		System.out.println("SUMARIO DO PEDIDO");
		System.out.println(pedido);
		


	}

}