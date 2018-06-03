package fachada;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.Produto;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Conta;
import repositorio.Restaurante;

public class Fachada {

	private static Restaurante restaurante = new Restaurante();
	private static int numconta = 0;
	               /*listar  */
	public static ArrayList<Produto>listarProdutos(){
		return restaurante.getProdutos();
	}
	
	public static ArrayList<Produto>listarProdutos(String nome){
		ArrayList<Produto> aux = new ArrayList<>();
		for(Produto p : restaurante.getProdutos()) {
			if(p.getNome().contains(nome)) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public static ArrayList<Garcom>listarGarcons(){
		return restaurante.getGarcons();
	}
	
	public static ArrayList<Mesa>listarMesas(){
		return restaurante.getMesas();
	}
	public static ArrayList<Conta>listarContas(){
		return restaurante.getContas();
	}
	
	/*criar mesas*/
	public static void criarMesas(int n) {
		Mesa aux;
		for(int i=1; i<=n; i++) {
			aux = new Mesa(i);
			aux.setOcupada(false);
			restaurante.adicionar(aux);
		}
	}
	/*Criar Conta */
	public static Conta criarConta(int idmesa) throws Exception {
		Mesa mesaaux = restaurante.localizarMesa(idmesa);
		if(mesaaux==null) {
			System.out.println("ai");
			throw new Exception("mesa não cadastrada"+idmesa);
		}
		if(mesaaux.isOcupada()) {
			System.out.println("ui");
			throw new Exception("a mesa está ocupada"+idmesa);
             
		}
			numconta++;
			Conta contaaux = new Conta(numconta);
			contaaux.setMesa(mesaaux);
			contaaux.getMesa().setOcupada(true);
			restaurante.adicionar(contaaux);
			return contaaux;
	}
	/*cadastrar Produtos*/
	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		Produto p = restaurante.localizarProduto(nome);
		if (p!=null) {
			throw new Exception("produto ja cadastrado:" + nome);
		}else {
		     p = new Produto(nome,preco);
		     restaurante.adicionar(p);
		     return p;
		}
	}
	
	/*Cadastrar Garcom*/
	public static Garcom cadastrarGarcom(String apelido, int mesainicial, int mesafinal) throws  Exception{
		    Garcom g = new Garcom(apelido);
		    ArrayList<Mesa> mesagarcom = new ArrayList<>();
		    for(int i = mesainicial; i<=mesafinal; i++) {
		    	mesagarcom.add(restaurante.localizarMesa(i));
		    }
		     for(Mesa m: mesagarcom) {
		    	 g.adicionar(m);
		     }
		     restaurante.adicionar(g);
		     return g;
		
	}
	
	/*consultar Conta */
	public static Conta consultarConta(int idmesa) throws Exception {
		Conta aux = restaurante.localizarContaPorMesa(idmesa);
		if(aux==null) {
			throw new Exception("mesa inválida "+idmesa);
		}
			return aux;
		
	}
	
	/*solicitar produto */
	public static Produto solicitarProduto(int idmesa, String nomeproduto) throws Exception {
		Produto p = restaurante.localizarProduto(nomeproduto);
		if(p== null) {
			throw new Exception("produto não cadastrado"+nomeproduto);
		}
		Mesa m = restaurante.localizarMesa(idmesa);
		if(m == null) {
			throw new Exception("mesa inválida"+idmesa);
		}else if(m.isOcupada()== false) {
			throw new Exception("a conta não está em aberta"+idmesa);
		}
		restaurante.localizarContaPorMesa(idmesa).adicionar(p);
		return p;
	}
	
	/*cancelar conta */
	public static void cancelarConta(int idmesa) throws Exception{
		Mesa m = restaurante.localizarMesa(idmesa);
		
		if(m == null) {
			throw new Exception("mesa inválida"+idmesa);
		}else if(m.isOcupada() == false) {
			throw new Exception("a conta não está em aberto !");
		}
		m.remover(m.localizar(idmesa));
		restaurante.remover(m.localizar(idmesa));
	}
	/*transferir a conta */
	public static void transferirConta(int idmesaorigem, int idmesadestino)throws Exception{
		Conta origem = restaurante.localizarContaPorMesa(idmesaorigem);
		if(origem == null) {
			throw new Exception("conta de origem inválida"+idmesaorigem);
		}else if(origem.getMesa().isOcupada() ==false) {
			throw new Exception("a conta de origem não está em aberta"+idmesaorigem);
		}
		Conta destino = restaurante.localizarContaPorMesa(idmesadestino);
		if(origem == null) {
			throw new Exception("conta de destino inválida"+idmesaorigem);
		}else if(origem.getMesa().isOcupada() ==false) {
			throw new Exception("a conta de destino não está em aberta"+idmesaorigem);
		}
		
		for(Produto p : origem.getProdutos()) {
			origem.remover(p);
			destino.adicionar(p);
			
		}
		restaurante.remover(origem);
	}
	/*fechar conta */
	public static void fecharConta(int idmesa)throws Exception {
		Conta aux = restaurante.localizarContaPorMesa(idmesa);
		if(aux == null) {
			throw new Exception("conta não existente"+idmesa);
		}else if(aux.getMesa().isOcupada() ==false) {
			throw new Exception("a conta não está em aberto"+idmesa);
		}else {
			
			String cal = Calendar.getInstance().getTime().toString();
			
			aux.setDtfechamento(cal);
			aux.getMesa().setOcupada(false);
		}
		
	}
	/*calcular Gorjeta */
	public static double calcularGorjeta(String nome) throws Exception {
		Garcom g = restaurante.localizarGarcom(nome);
		if(g==null) {
			throw new Exception("garcom não existente"+nome);
		}else {
			double gorgeta = 0;
			     
			    ArrayList<Conta> contas = restaurante.getContas();
			    for(Conta c: contas) {
			    	if(c.getMesa().getGarcom().getApelido().equals(nome)) {
			    		gorgeta+=c.getTotal();
			    		
			    	}
			    }
				
				
				
			
			return (gorgeta * 10)/100;
		}
		
		
		
	}
	
	
}
