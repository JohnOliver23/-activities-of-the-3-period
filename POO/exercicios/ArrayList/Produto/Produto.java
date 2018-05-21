package view;

public class Produto {
	private String nome;
	private double preco;
	
	public Produto(String n, double p) {
		this.nome = n;
		this.preco = p;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}
	
	
	
}
