import java.util.ArrayList;

public class Livro {
	String titulo;
	private ArrayList<Autor> autores = new ArrayList<>();
	
	
	public Livro(String tit) {
		this.titulo = tit;
	}
	public void adicionar(Autor a) {
		autores.add(a);
		
	}
	
	public void remover(Autor a) {
		autores.remove(a);
		
	}
	
	
	public Autor localizar(String nome) {
		for(Autor a: autores) {
			if(a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setNome(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		String texto = "titulo = "+titulo+" Autores = [";
		for (Autor a : autores) {
			texto+=a.getNome()+", ";
		}
		texto+=" ]";
		return texto;
	}

	
	
}
