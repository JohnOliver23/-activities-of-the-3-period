package modelo;

import java.util.ArrayList;

public class Mesa {
	private int id;
	private boolean ocupada;
	private ArrayList<Conta> contas = new ArrayList<>();
	private Garcom garcom;
	
	/*Constructor*/
	public Mesa(int id) {
		this.id = id;
	}
	
	/*Getters and setters */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public Garcom getGarcom() {
		return garcom;
	}
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public Conta localizar(int num) {
		for(Conta c : contas) {
			if(c.getNumero() == num) {
				return c;
			}
		}
		return null;
	}
	public Conta localizarContaPorMesa(int idmesa) {
		for(Conta c : contas) {
			if(c.getMesa().getId() == idmesa) {
				return c;
			}
		}
		return null;

	}
	/*add and remove*/
	public void adicionar(Conta c) {
		contas.add(c);
		c.setMesa(this);
	}
	
	public void remover(Conta c) {
		contas.remove(c);
		c.setMesa(this);
	}
	/*toString*/
	@Override
	public String toString() {
		String texto = "[ Mesa [ id= " + id + "] , Ocupada = [ "+ocupada+" ] Garçom = [";
		if(garcom==null) {
			texto+=" não tem garcom ";
		}else {
			texto+=" "+garcom.getApelido()+" ";
		}
		texto+=" ] ]\n";
		return texto;
		
	}
	
	
	
}
