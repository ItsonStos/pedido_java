package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.Enum.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private StatusPedido status;
	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	
	public void addItem (ItemPedido item) {
		itens.add(item);
	}
	
	public void removerItem (ItemPedido item) {
		itens.remove(item);
	}
	
	public Pedido() {
		}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public double total() {
		double soma = 0.0;
		for (ItemPedido item : itens) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("instante do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Priço total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
