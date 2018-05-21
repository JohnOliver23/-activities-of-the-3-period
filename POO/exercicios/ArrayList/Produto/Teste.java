package view;

import java.util.ArrayList;
import java.util.Iterator;

public class Teste {
	public static void main(String[] args) {
		/*quest�o 1 */
		Produto p1 = new Produto("arroz", 3.00);
		Produto p2 = new Produto("feijao", 5.00);
		Produto p3 = new Produto("carne", 30.00);
		Produto p4 = new Produto("vinho", 15.00);
		Produto p5 = new Produto("oleo", 5.00);
		/*quest�o 2 */
		ArrayList<Produto> produtos = new ArrayList<>();
		
		/*quest�o 3 */
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		produtos.add(p5);
		
		/*quest�o 4 */
		for(Produto p: produtos) {
			System.out.println(p);
		}
		
		/*quest�o 5 */
		for (Produto p : produtos) {
			p.setPreco(p.getPreco()+1.0);
		}
		
		/*quest�o 6 */
		produtos.remove(0);
		
		/*quest�o 7 */
		ArrayList<Produto> produtos2 = new ArrayList<>();
		
		for (Produto p: produtos ) {
			if(p.getPreco() < 10) {
				produtos2.add(p);
			}
		}
		/*quest�o 8 */
		System.out.println("==========================================");
		System.out.println("imprimindo a primeira lista");
		System.out.println(produtos);
		
		System.out.println("==========================================");
		System.out.println("imprimindo a segunda lista");
		System.out.println(produtos2);
		
		/*quest�o 9 */
		 produtos2.get(0).setPreco(4.00);
		
		 /*quest�o 10 */
			System.out.println("==========================================");
			System.out.println("imprimindo a primeira lista");
			System.out.println(produtos);
			
			System.out.println("==========================================");
			System.out.println("imprimindo a segunda lista");
			System.out.println(produtos2);
			
			/*quest�o 11 */
			produtos.removeAll(produtos2);
			
			System.out.println("==========================================");
			System.out.println("imprimindo a primeira lista");
			System.out.println(produtos);
			
			System.out.println("==========================================");
			System.out.println("imprimindo a segunda lista");
			System.out.println(produtos2);
			
			/*Problema */
			/*
			for (Produto p: produtos) {
				if(p.getPreco() > 10.0) {
					produtos.remove(p);
				}
					
			}
			System.out.println(produtos);
			*/
			//n�o remove todos os elementos que era pra remover
			
			/*solu��o 1 PROBLEMA*//*
			for (int i =0; i< produtos.size(); i++) {
				Produto p = produtos.get(i);
				if(p.getPreco() < 10.00) {
					produtos.remove(p);
				}
				i--;
			}
			*/
			/*forma certa */
			
			Iterator i = produtos.iterator(); // obt�m o iterator
			while(i.hasNext()) { //verifica se h� elementos na lista
				Produto p = (Produto) i.next(); // acessa cada elemento da lista
				if(p.getPreco() > 10.00)
					i.remove();// remove o elemento atual
			}
			System.out.println("produtos = "+produtos);
			
			
	}
}
