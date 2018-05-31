
public class Main {
	public static void main(String[] args) {
		Loja loja1 = new Loja();
		Produto p1, p2, p3, p4;
		p1 = new Produto("arroz", 3.0) ;
		p2 = new Produto("feijao", 5.0) ;
		p3 = new Produto("carne", 12.0) ;
		p4 = new Produto("leite", 2.0) ;
		Prateleira prat1 = new Prateleira(1,10);
		Prateleira prat2 = new Prateleira(2, 20);
		 loja1.adicionar(p1);
		 loja1.adicionar(p2);
		 loja1.adicionar(p3);
		 loja1.adicionar(p4);
		 
		 System.out.println(loja1);
		 
		 prat1.adicionar(p1);
		 prat1.adicionar(p2);
		 prat1.adicionar(p3);
		 prat2.adicionar(p4);
		 
		 System.out.println(loja1);
		 
		 p1.setPrateleira(prat1); // relacionam. inverso
		 p2.setPrateleira(prat1); // relacionam. inverso
		 p3.setPrateleira(prat1); // relacionam. inverso
		 p4.setPrateleira(prat2); // relacionam. inverso
		 
		
		 
		 System.out.println(loja1);
		
		 
		 //qual é o preco do leite
		 Produto p = loja1.localizar("leite");
		 if(p!=null)System.out.println(p);
		 else System.out.println("não existe liete na loja");
		 
		 //qual é o numero da prateleira do leite
		  p = loja1.localizar("leite");
		  if(p!=null) {
			  Prateleira pr = p.getPrateleira();
			  if(pr != null) {
				  int num = pr.getId();
				  System.out.println("prateleira =" +num);
			  }else {
				  System.out.println("não existe prateleira na loja");
			  }
			  
		  }else {
			  System.out.println("não existe leite na loja");
		  }
		  
		// remover o feijao da sua própria prateleira
		  System.out.println(prat1);
		  Produto f = loja1.localizar("feijao");
		  if(f!=null) {
			  Prateleira prat = f.getPrateleira();
			  if(prat!=null) {
				  
				  prat.remover(f);
				  f.setPrateleira(null);
				  
			  }else {
				  System.out.println("não tem prateleira");
			  }
		  }else {
			  System.out.println("não tem feijão");
		  }
		  System.out.println(prat1);
		 
		//transferir arrroz pra prateleira 2
		Produto prod = loja1.localizar("arroz");
		if(prod != null) {
			Prateleira prat = prod.getPrateleira();
			if(prat != null) {
				prat.remover(prod);
				prat2.adicionar(prod);
				prod.setPrateleira(prat2);
			}else {
				System.out.println("não tem prateleira");
			}
			
		}else {
			System.out.println("não existe arroz");
		}
		 loja1.adicionar(prat1);
		 loja1.adicionar(prat2);
		System.out.println("-------------------------------");
		for(Prateleira pt : loja1.getPrateleira()) {
			System.out.println(pt);
		}
		System.out.println("-------------------------------");
		for(Produto pr : loja1.getProduto())
			System.out.println(pr);
	}
	
	
	
	
}
