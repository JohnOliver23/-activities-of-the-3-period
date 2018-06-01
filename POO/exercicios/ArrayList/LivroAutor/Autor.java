import java.util.ArrayList;

public class Autor {
private String nome;
private ArrayList<Livro> livros = new ArrayList<>();

public Autor(String nome) {
	this.nome = nome;
}

public void adicionar(Livro l ) {
	livros.add(l);

	
}

public void remover(Livro l) {
	livros.remove(l);
	
}
public Livro localizar(String tit) {
	for(Livro l : livros) {
		if(l.getTitulo().equals(tit)) {
			return l;
		}
	}
	return null;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public ArrayList<Livro> getLivros() {
	return livros;
}

public void setLivros(ArrayList<Livro> livros) {
	this.livros = livros;
}
public String toString() {
	String texto = "nome = "+nome+" Livros = [";
	for (Livro l : livros) {
		texto+=l.getTitulo()+", ";
	}
	texto+=" ]";
	return texto;
}

}
