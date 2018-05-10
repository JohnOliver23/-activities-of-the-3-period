
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
		if(amigo == null){
			return "Pessoa [nome=" + nome+", amigo = Não tem Amigo";
		}else if(amigo.getNome().equals(nome)){
			return "Pessoa [nome=" + nome + ", amigo=" +"ele mesmo" + "]";
		
		}
		return "Pessoa [nome=" + nome + ", amigo=" + amigo.getNome() + "]";
	}
	
	public String amigoComum(Pessoa amg) {
		
		if(this.amigo == null)
			return "amigos diferentes";
		else if(amg.getAmigo() == null)
			return "amigos diferentes";
		System.out.println("amigo de "+this.nome+" = "+this.amigo.getNome());
		System.out.println("amigo de "+amg.getNome()+" = "+amg.getAmigo().getNome());
		if (this.amigo.getNome().equals(amg.getAmigo().getNome()))
			return "amigos em comum";
		else
			return "amigos diferentes";
		
		
	}

	
	
	
	
	
}
