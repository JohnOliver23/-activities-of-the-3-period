package view;

import java.util.ArrayList;

public class PilhaS {
	private ArrayList<String> pilhas = new ArrayList<>();
	
	public void push(String nome) {
		pilhas.add(nome);
	}
	public String topo() {
		return pilhas.get(pilhas.size()-1);
	}
	
	public void pop () {
		pilhas.remove(pilhas.size()-1);
	}

	@Override
	public String toString() {
		return "PilhaS [pilhas=" + pilhas + "]";
	}
	
}
