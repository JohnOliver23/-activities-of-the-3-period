import java.util.ArrayList;

public class Loja {
private ArrayList<Produto> produtos = new ArrayList<>();
private ArrayList<Prateleira> prateleiras = new ArrayList<>();


public void adicionar(Produto p) {
	produtos.add(p);
}

public void adicionar(Prateleira p) {
	prateleiras.add(p);
}
public void remover(Produto p) {
	produtos.remove(p);
}

public void remover(Prateleira p) {
	prateleiras.remove(p);
}

public Produto localizar (String nome) {
	for(Produto p : produtos) {
		if(p.getNome().equals(nome))
			return p;
	}
	return null;
}
public Prateleira localizar (int id) {
	for (Prateleira p : prateleiras) {
		if(p.getId() ==id)
			return p;
	}
	return null;
}

@Override
public String toString(){
	String texto = "produtos = [";
	if(produtos.isEmpty()) {
		texto+=" não tem produto ]";
	}else {
		for(Produto p: produtos) {
			texto+=" "+p;
		}
		texto+="]";
	}
	if(prateleiras.isEmpty()) {
		texto+=" não tem prateleiras";
	}else {
		for(Prateleira pt: prateleiras) {
			texto+=" "+pt;
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
public ArrayList<Prateleira> getPrateleira(){
	return prateleiras;
}

public int totalPrateleira() {
	return prateleiras.size();
}




}
