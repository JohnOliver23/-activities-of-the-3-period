package view;

public class testeContaException {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("John","Tambausinho");
		Cliente cliente2 = new Cliente ("Mario","Torre");
		Conta conta1 = new Conta("123",cliente1);
		Conta conta2 = new Conta("456", cliente2);
		System.out.println(cliente1);
		
		try {
			conta1.creditar(50);
			conta1.debitar(70);
			conta1.creditar(20);//nao executa
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------");
		
		try {
			conta1.creditar(50);
			conta1.transferir(130, conta2);
			System.out.println("oi");
			conta1.creditar(100);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			conta1.creditar(50);
			conta1.transferir(270, conta2);
			System.out.println("oi");
			conta1.creditar(50);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		int n =0;
		try {
			int media = 100/n;
		}catch(ArithmeticException e ) {
			System.out.println("divisao invalida");
			e.printStackTrace();
		}
		
		System.out.println("---------------------------");
		try {
			conta1.creditar(50);
			conta1.debitar2(1000);
		}catch(SaldoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	

}
