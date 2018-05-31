import java.util.ArrayList;

public class Prateleira {
	private int id;
	private int tamanho;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public Prateleira(int i, int t) {
		this.id = i;
		this.tamanho = t;
	}
	public void adicionar(Produto p) {
		produtos.add(p);
	}
	public void remover(Produto p) {
		produtos.remove(p);
	}
	public Produto localizar(String nome) {
		for(Produto p: produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		String texto = "id = "+id;
		texto+="tamanho = "+tamanho;
		if(produtos.isEmpty()) {
			texto+=" não tem produto";
		}else {
			for(Produto p : produtos) {
				texto +=" "+p;
			}
		}
		return texto;
	}
	public ArrayList<Produto> getProduto(){
		return produtos;
	}
	
	public int totalProduto() {
		return produtos.size();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

