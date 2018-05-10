
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
	
	System.out.println(joao);
	System.out.println(ana);
	System.out.println(paulo);
	System.out.println(julia);
	
	paulo.setAmigo(ana);
	julia.setAmigo(null);
	ana.setAmigo(ana);
	
	
	System.out.println("-----------------------------");
	System.out.println(joao);
	System.out.println(ana);
	System.out.println(paulo);
	System.out.println(julia);
	
	System.out.println("verificar se paulo tem o mesmo amigo de joão");
	System.out.println(paulo.amigoComum(joao));
	
	System.out.println("--------------------------------------------");
	System.out.println("verificar se ana tem o mesmo amigo de julia");
	System.out.println(ana.amigoComum(julia));
	System.out.println(julia.amigoComum(ana));
	
	
	
	
}
}
