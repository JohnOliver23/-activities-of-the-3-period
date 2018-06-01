import java.util.ArrayList;

public class Departamento {
private String sigla;
private ArrayList<Empregado> empregados = new ArrayList<>();

public Departamento(String si) {
	this.sigla = si;
}
public void adicionar(Empregado e) {
	empregados.add(e);
	e.setDepartamento(this);
}

public void remover(Empregado e) {
	empregados.remove(e);
	e.setDepartamento(null);
}

public Empregado localizar(String nome) {
	for(Empregado e : empregados) {
		if(e.getNome().equals(nome)) {
			return e;
		}
	}
	return null;
}
@Override
public String toString() {
String texto = "nome = [ "+this.sigla+ "]"+" Empregados = [ ";
for (Empregado e: empregados) {
	texto+= e.getNome()+" ,";
}
texto+=" ]";
return texto;
	
}
}
