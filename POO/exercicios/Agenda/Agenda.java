import java.util.ArrayList;

public class Agenda {
	private String nome;
	private ArrayList<Contato> contatos = new ArrayList<>();
	
	public Agenda(String n) {
		this.nome = n;
	}
	
	public void adicionar(Contato c) {
		contatos.add(c);
	}
	public void remover(Contato c) {
		contatos.remove(c);
	}
	public Contato localizarContatoPorNome(String nome) {
		for(Contato c: contatos) {
			if(c.getNome().equals(nome)) {
				return c;
			}
		}
		return null;
	}
	public Contato localizarContatoPorNumero(String tel) {
		String num;
		for(Contato c: contatos) {
			num = c.localizar(tel);
			if(num!= null) {
				return c;
			}
		}
		return null;
	}
	public ArrayList<Contato> listarContatosPorNome(String nome){
		ArrayList<Contato> aux = new ArrayList<>();
		for(Contato c: contatos) {
			if(c.getNome().contains(nome)) {
				aux.add(c);
			}
		}
		return aux;
	}
	
	public ArrayList<Contato> listarContatosPorNumero(String tel){
		ArrayList<Contato> aux = new ArrayList<>();
		String taux;
		for(Contato c: contatos) {
			taux = c.localizarParcial(tel);
			if(taux!=null) {
				aux.add(c);
			}
		}
		return aux;
	}
	public ArrayList<Contato> listarContatosSemTelefone(){
		ArrayList<Contato> aux = new ArrayList<>();
		for(Contato c: contatos) {
			if(c.getTelefones().size() == 0) {
				aux.add(c);
			}
		}
		return aux;
	}
	
	public ArrayList<Contato> listarContato(){
		return contatos;
	}
	
	@Override
	public String toString() {
		String texto = "Agenda: Nome: = "+nome+"\n Contatos = [ ";
		if(contatos.size() ==0) {
			texto+="não tem contatos";
		}else {
			for(Contato c: contatos) {
				texto +=c+" ]\n";
			}
			
		}
		texto+=" ]";
		return texto;
	}
	
}
