package view;

public class Conta {
	private String numero;
	Cliente cliente;
	int saldo;
	
	public Conta(String numero) {
		this.numero = numero;
	}

	public Conta(String numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", cliente=" + cliente + ", saldo="
				+ saldo + ", getNumero()=" + getNumero() + ", getCliente()="
				+ getCliente() + ", getSaldo()=" + getSaldo() + "]";
	}
	
	
	
	
	
	
	
	
	
}
