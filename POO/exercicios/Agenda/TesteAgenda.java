import java.util.ArrayList;

public class TesteAgenda {
public static void main(String[] args) {
	
	Agenda agenda = new Agenda("amigos");
	Contato c;
	c = new Contato("joao da silva");
	c.adicionar("8801-0000");
	c.adicionar("8802-0000");
	agenda.adicionar(c);
		
	c = new Contato("jose da silva");
	c.adicionar("9901-0000");
	c.adicionar("9902-0000");
	agenda.adicionar(c);
	
	c = new Contato("joao da cruz");
	c.adicionar("8888-0000");
	c.adicionar("9999-0000");
	agenda.adicionar(c);
	
	c = new Contato("maria de fatima");
	agenda.adicionar(c);
	
	System.out.println();
	System.out.println(agenda);   // nome + telefones
	
	System.out.println("\n---localizar contato por nome joao da silva");
	c = agenda.localizarContatoPorNome("joao da silva");
	if(c!=null)
		System.out.println(c);   // nome + telefones
	else
		System.out.println("contato inexistente"); 
		
		
	System.out.println("\n---localizar contato por numero 9902-0000");
	c = agenda.localizarContatoPorNumero("9902-0000");
	if(c!=null)
		System.out.println(c);   // nome + telefones
	else
		System.out.println("contato inexistente"); 
	
	
	System.out.println("\n---listar contatos contendo silva");
	ArrayList<Contato> lista = agenda.listarContatosPorNome("silva");
	if(lista.size()!=0)   		//if(lista.isEmpty())
		System.out.println(lista);   // nome + telefones
	else
		System.out.println("contatos nao encontrados com nome silva"); 
	

	System.out.println("\n---listar contatos contendo 88");
	lista = agenda.listarContatosPorNumero("88");
	if(lista.size()!=0)  		//if(lista.isEmpty())
		System.out.println(lista);   // nome + telefones
	else
		System.out.println("contatos nao encontrados com numero 88"); 
	
	
	
	System.out.println("\n---listar contatos sem telefone");
	lista = agenda.listarContatosSemTelefone();	
	if(lista.size()!=0)  		//if(lista.isEmpty())
		System.out.println(lista);   // nome + telefones
	else
		System.out.println("nao encontrado contatos sem telefone"); 
	
	
	System.out.println("\n---substituir telefone 8801-0000 por 8801-1111");		
	c = agenda.localizarContatoPorNumero("8801-0000");
	if(c!=null)
		try{
			c.substituir("8801-0000", "8801-1111");  
			System.out.println("numero substituido com sucesso");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	System.out.println("\n---remover jose da silva da agenda");		
	c = agenda.localizarContatoPorNome("jose da silva");
	if(c!=null)
		try{
			agenda.remover(c);  
			System.out.println("contato removido da agenda");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	System.out.println();
	System.out.println(agenda);   // nome + telefones
	
}
}
