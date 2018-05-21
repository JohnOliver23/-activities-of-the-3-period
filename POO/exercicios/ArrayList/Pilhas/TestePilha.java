package view;

public class TestePilha {
	public static void main(String[] args) {
		PilhaS p = new PilhaS();
		
		/* pilha de String */
		p.push("joão");
		p.push("maria");
		System.out.println(p);
		String topo = p.topo();
		System.out.println(topo);
		p.pop();
		topo = p.topo();
		System.out.println(topo);
		
		/* pilha de String */
		PilhaI pi = new PilhaI();
		pi.push(100);
		pi.push(25);
		int topopi = pi.topo();
		pi.pop();
		topopi = pi.topo();
		System.out.println(topopi);
		
		/*pilha generica */
		Pilha <String> p1 = new Pilha();
		p1.push("joao");
		p1.push("maria");
		System.out.println(p1);
		Pilha <Integer> p2 = new Pilha();
		p2.push(100);
		p2.push(25);
		System.out.println(p2);
		
	}
}
