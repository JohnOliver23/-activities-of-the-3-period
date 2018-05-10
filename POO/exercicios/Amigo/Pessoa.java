
public class Pessoa {
	String nome;
	Pessoa amigo;
	public Pessoa(String nome, Pessoa amigo) {
		this.nome = nome;
		this.amigo = amigo;
	}
	public Pessoa(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pessoa getAmigo() {
		return amigo;
	}
	public void setAmigo(Pessoa amigo) {
		this.amigo = amigo;
	}
	@Override
	public String toString() {
		if(amigo.getNome().equals(nome)){
			return "Pessoa [nome=" + nome + ", amigo=" +"ele mesmo" + "]";
		}else if(amigo == null){
			return "Pessoa [nome=" + nome+", amigo = Não tem Amigo";
		}
		return "Pessoa [nome=" + nome + ", amigo=" + amigo.getNome() + "]";
	}
	
	
	
	
	
}
