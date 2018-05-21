package view;

import java.util.ArrayList;

public class PilhaI {
private ArrayList<Integer> pilhas = new ArrayList<>();
	
	public void push(int nome) {
		pilhas.add(nome);
	}
	public int topo() {
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
