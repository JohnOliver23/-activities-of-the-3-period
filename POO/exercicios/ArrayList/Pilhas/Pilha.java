package view;

import java.util.ArrayList;

public class Pilha<T> {
	ArrayList<T> pilhas = new ArrayList<>(); 
	
	public void push (T v) {
		pilhas.add(v);
	}
	
	public T pop() {
		return pilhas.get(pilhas.size()-1);
	}

	@Override
	public String toString() {
		return "Pilha [pilhas=" + pilhas + "]";
	}
	
	
}
