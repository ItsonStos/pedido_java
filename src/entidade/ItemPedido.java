package entidade;

public class ItemPedido {
	private int quantidade;
	private double preco;
	
	private Produto produtos;
	
	
	
	public ItemPedido(int quantidade, double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produtos = produto;
	}
	
	
	public double subTotal() {
		return this.quantidade * this.preco;
	}
	
	@Override
	public String toString() {
		return produtos.getNome()
				+ ", $" 
				+ String.format("%.2f", preco) 
				+ ", Quantity: " 
				+ quantidade + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}

}
