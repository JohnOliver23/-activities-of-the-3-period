
public class Empregado {
private String nome;
private double salario;
private Departamento departamento;

public Empregado(String n, double s) {
	this.nome = n;
	this.salario = s;
}
public Departamento getDepartamento() {
	return departamento;
}
public void setDepartamento(Departamento departamento) {
	this.departamento = departamento;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}
@Override
public String toString() {
	String texto = "nome = [ "+this.getNome()+" ]"+" salario = ["+this.getSalario()+" ]"+
	"Departamento = [";
	if(this.departamento == null) {
		texto+=" Empregado não tem departamento ]";
	}else {
		texto+= this.departamento+" ]";
	}
	return texto;
}

}
