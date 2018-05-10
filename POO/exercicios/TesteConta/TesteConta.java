package view;

public class TesteConta {
	public static void main(String[] args) {
		Cliente cliAux;
		Conta c1 = new Conta("123", new Cliente("john","cruz das armas"));
		Conta c2 = new Conta("324", new Cliente("Fabricio", "Santa Rita"));
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println();
		
		cliAux = c1.getCliente();
		c1.setCliente(c2.getCliente());
		c2.setCliente(cliAux);
		
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
		
	}
}
