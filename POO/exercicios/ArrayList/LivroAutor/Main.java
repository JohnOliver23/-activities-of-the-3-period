
public class Main {
	public static void main(String[] args) {
		Livro livro1 = new Livro("java");
		Livro livro2 = new Livro("PHP");
		
		Autor a1 = new Autor("joão");
		Autor a2 = new Autor("Maria");
		
		livro1.adicionar(a1);
		livro1.adicionar(a2);
		livro2.adicionar(a1);
		livro2.adicionar(a2);
		
		a1.adicionar(livro1);
		a1.adicionar(livro2);
		a2.adicionar(livro1);
		a2.adicionar(livro2);
		
		
		System.out.println(livro1);
		System.out.println(livro2);
		
		System.out.println(a1);
		System.out.println(a2);
		
		Autor au = livro1.localizar("joão");
		if(au!= null) {
			livro1.remover(au);
			au.remover(livro1);
			System.out.println("removido");
		}else {
			System.out.println("autor não existe");
		}
		System.out.println(livro1);
		
		
		
	}
}
