
public class Main {
 public static void main(String[] args) {
	 Empregado e1 = new Empregado("ze", 500.0);
	 Empregado e2 = new Empregado("pedro", 800.0);
	 Empregado e3 = new Empregado("paulo", 1000.0);
	 
	 Departamento d1 = new Departamento("inf");
	 
	 d1.adicionar(e1);
	 d1.adicionar(e2);
	 d1.adicionar(e3);
	 System.out.println(e1);
	 System.out.println(d1);
}
}
