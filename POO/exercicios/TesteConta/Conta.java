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
	
	public void debitar(int valor)throws Exception
	{
		if(this.saldo - valor <0)
			throw new Exception("saldo insuficiente");
		saldo -=valor;
		
	}
	
	public void debitar2(int valor) throws SaldoNegativoException{
		if(this.saldo - valor <0)
			throw new SaldoNegativoException();
		saldo -=valor;
	}
	
	public void transferir(int valor, Conta destino)throws Exception {
		this.debitar(valor);
		destino.creditar(valor);
	}
	
	public void transferir2 (int valor, Conta destino)throws Exception {
		try {
			this.debitar(valor);
			destino.creditar(valor);
		}catch(Exception e) {
			throw new Exception("transferencia incorreta");
		}
	}
	
	 
	
	public void creditar (int valor) {
		this.saldo += valor;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", cliente=" + cliente + ", saldo="
				+ saldo + "]";
	}
	
	
	
	
	
	
	
	
	
}
