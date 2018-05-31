
public class Produto {
private Prateleira prateleira;
private String nome;
private double preco;

public Produto(String n, double p){
	this.nome = n;
	this.preco = p;
}
public Prateleira getPrateleira() {
	return this.prateleira;
}
public void  setPrateleira(Prateleira p) {
	this.prateleira = p;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
@Override
public String toString() {
	String texto = "nome: "+nome+" preco: "+preco;
	if(prateleira == null) {
		texto+=" não tem prateleira";
	}else {
		texto+=" prateleira :"+prateleira.getId();
	}
	return texto;
}



}
