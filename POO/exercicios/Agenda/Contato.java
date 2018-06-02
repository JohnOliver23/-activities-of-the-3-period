import java.util.ArrayList;

public class Contato {
private String nome;
private ArrayList<String> telefones = new ArrayList<>();

public Contato(String n) {
	this.nome = n;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public ArrayList<String> getTelefones() {
	return telefones;
}
public void setTelefones(ArrayList<String> telefones) {
	this.telefones = telefones;
}
public void adicionar(String tel) {
	telefones.add(tel);
}

public void remover(String tel) {
	telefones.remove(tel);
}

public String localizar(String tel) {
	for(String t: telefones) {
		if(t.equals(tel)) {
			return t;
		}
	}
	return null;
}

public String localizarParcial(String tel) {
	for(String t: telefones) {
		if(t.contains(tel)) {
			return t;
		}
	}
	return null;
}
public void substituir(String velho, String novo) {
	String aux = this.localizar(velho);
	if(aux!=null) {
		this.remover(aux);
		this.adicionar(novo);
	}
}

@Override
public String toString() {
	String texto = "Contato: Nome: ["+nome+" Telefones: [ ";
	if(telefones.isEmpty()) {
		texto+=" Não tem telefones";
	}else {
		for (String t: telefones) {
			texto+=t+" ,";
		}
		texto+=" ]";
	}
	return texto;
}

}
