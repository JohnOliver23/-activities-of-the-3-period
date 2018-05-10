
public class Teste {
	public static void main(String[] args) {
	Pessoa joao = new Pessoa("João");
	Pessoa ana = new Pessoa("Ana");
	Pessoa paulo = new Pessoa("Paulo");
	Pessoa julia = new Pessoa("Julia");
	
	joao.setAmigo(ana);
	ana.setAmigo(joao);
	paulo.setAmigo(julia);
	julia.setAmigo(joao);
	julia.setAmigo(julia);
	
	System.out.println(joao);
	System.out.println(ana);
	System.out.println(paulo);
	System.out.println(julia);
	
	
	
}
}
