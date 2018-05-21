package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JogoDaForca {
	private  String[]  palavras;    //  um  array  com  as  n  palavras  (lidas  do  arquivo)      
	private  String[]  dicas;     //  um  array  com  as  n  dicas  (lidas  do  arquivo) 
	private  int  n = 0;  //  quantidade  de  palavras  do  arquivo  (lido  do  arquivo)  
	private  int  sorteio  =  -1;   //  índice  da  palavra  sorteadado  jogo  
	private  int  acertos;      	//  total  de  acertos  do  jogo  
	private  int  erros;      		//  total  de  erros  do  jogo 
	private String palavraSorteada; // 	guardar a palavra sorteada
	
	public JogoDaForca(String arquivo) {
		 try {
		      Scanner arq = new Scanner(new File(arquivo));
		      String linha;
		      String line[];
		      String work;
		      String dik;
		      int i = 0;
		      while (arq.hasNextLine()) {
		        if(i==0) {
		        	this.n = Integer.parseInt(arq.nextLine());
		        	this.palavras = new String[this.n];
		        	this.dicas = new String[this.n];
		        	i=0;
		        }
		        
		        linha = arq.nextLine();
		        line = linha.split(";");
		        work = line[0];
		        dik = line[1];
		        this.palavras[i] = work;
		        this.dicas[i] = dik;
		        i++;
		      }
		 
		      arq.close();
		    } catch (FileNotFoundException e) {
		        System.out.println("arquivo inexistente");
		        System.exit(0);
		    }
		 
		    System.out.println();	  
	}
	
	public void inicializar() {
		this.acertos = this.erros = 0;
		this.sorteio = (int) (0 + Math.random() * this.n);
		this.palavraSorteada= (this.palavras[this.sorteio]);
	}
	
	public int[] jogar(String l) {
		int ocorrencia = 0;//guarda quantas ocorrencias a letra aparece na palavra
		//int posicoes[] = new int[ocorrencia]; /*TA ERRADO, O TAMANHO DE POSIÇÕES VAI SER SEMPRE 0 */
		int posicoes[];
		String[] letras = this.palavras[this.sorteio].split("");
		int i, j;
		for (i=0; i< letras.length; i++){
			if(letras[i].equals(l)) {
				ocorrencia++;
			}
		}
		posicoes = new int[ocorrencia];//ASSIM É O CERTO
		
		if(ocorrencia ==0) {//se não tiver ocorrencia da letra retorna null
			this.erros = (this.erros+1);
			return null;
		}else {
			for(j=i=0; i< letras.length; i++) {
				if (letras[i].equals(l)) {
					posicoes[j] = i;
					j++;
					this.acertos = (this.acertos+1);
					//System.out.println("oi");
				}
			}
			this.palavras[this.sorteio] = this.palavras[this.sorteio].replaceAll(l, "#");
			
		}
		return posicoes;
	}
	
	public  boolean  advinhar(String  palavra) {
		if (this.palavraSorteada.equals(palavra)) {
			this.acertos = (this.palavraSorteada.length());
		}else {
			this.erros = (this.palavraSorteada.length());
		}
		
		return this.palavraSorteada.equals(palavra);
	}
	
	public String[] getPalavra() {
		return palavras;
	}
	
	public int getTamanho() {
		return palavraSorteada.length();
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	public int getErros() {
		return this.erros;
	}

	public String getDica() {
		return this.dicas[this.sorteio];
	}

	public String getPalavraSorteada(){
		return this.palavraSorteada;
	}




	
	
}
