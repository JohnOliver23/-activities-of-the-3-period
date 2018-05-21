package view;

import java.awt.Color;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class TelaForca extends JFrame {
	JButton btn[][] = new JButton[2][13];//Teclado
	String[][] str = new String[][] {{"A","B","C","D","E","F","G","H","I","J","L","K","M"}, {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}};
	JButton btnAtual;
	String[] words;
	private Song audio = new Song();
	private static int option;  //esse atributo tem que ser estatico
	private static TelaForca frame;
	private JPanel contentPane;
	private JTextField txtResposta;
	private final JLabel happy = new JLabel("");
	private final JLabel sad = new JLabel("");
	private final JButton btnPlay = new JButton("");
	//private String nome; 
	private final JogoDaForca jogo;
	private final JButton btnRetry = new JButton("");
	private final JLabel lblWin = new JLabel("");
	private final JLabel lblLose = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaForca(option); //instancia com o parametro
					frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaForca(int option) {
		audio.stop();
		audio.player("exorcismo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("John Oliver e Kamila Freitas");
		setResizable(false);
		
		JLabel gameOver = new JLabel("");
		gameOver.setIcon(new ImageIcon(TelaForca.class.getResource("/images/overflow2.png")));
		gameOver.setBounds(145, 14, 360, 310);
		gameOver.setVisible(false);
		/*happy*/
		/*sad*/
		sad.setIcon(new ImageIcon(TelaForca.class.getResource("/images/sada.png")));
		sad.setBounds(265, 90, 188, 180);
		sad.setVisible(false);
		
		/*jogo*/
		String nome ="";//VAI RECEBER O NOME DA MODALIDADE ESCOLHIDA PARA ENVIAR PRA CLASSE JOGO
		if(option ==1) {
			 nome = "Animal.txt";
		}else if (option ==2) {
			nome = "Cep.txt";
		}else if (option ==3) {
			nome = "Frutas.txt";
		}else if(option ==4) {
			nome = "Curiosidades.txt";
		}else if (option ==5) {
			nome = "Ingles.txt";
		}
		/*CRIAR AS OUTRAS MODALIDADES */
		
		/*--------------------------- */
		
		/*CRIANDO E INICIALIZANDO O JOGO */
		
		jogo = new JogoDaForca(nome);
		String palavraSort = "";
		String dicaSort = "";
		jogo.inicializar();
		palavraSort = jogo.getPalavraSorteada();
		dicaSort = jogo.getDica();
		/*------------------------------------------------------*/
		
		/*botao jogar novamente */
		btnPlay.setBounds(240, 280, 90, 28);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorder(null);
		btnPlay.setEnabled(false);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(option);
				te.setVisible(true);
			}
		});
		/*botao voltar ao menu */
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audio.stop();
				dispose();
				TelaEscolha tela = new TelaEscolha();
				tela.setVisible(true);
				
				
				
			}
		});
		
		JLabel lblCer = new JLabel("0");
		lblCer.setBounds(307, 226, 31, 23);
		lblCer.setVisible(false);
		contentPane.add(lblCer);
		lblCer.setForeground(new Color(0, 255, 0));
		lblCer.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		
		JLabel lblEr = new JLabel("0");
		lblEr.setBounds(395, 228, 31, 19);
		lblEr.setVisible(false);
		contentPane.add(lblEr);
		lblEr.setForeground(new Color(255, 0, 0));
		lblEr.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		
		JLabel lblPal = new JLabel("rinoceronte");
		lblPal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPal.setBounds(290, 250, 149, 19);
		lblPal.setVisible(false);
		lblWin.setBounds(250, 90, 200, 48);
		contentPane.add(lblWin);
		
		lblWin.setIcon(new ImageIcon(TelaForca.class.getResource("/images/wim.png"))); //construtor com parametro
		lblLose.setIcon(new ImageIcon(TelaForca.class.getResource("/images/lose.png")));
		lblLose.setBounds(250, 73, 188, 80);
		lblWin.setVisible(false);
		lblLose.setVisible(false);
		contentPane.add(lblLose);
		contentPane.add(lblPal);
		lblPal.setForeground(new Color(0, 255, 0));
		lblPal.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		btnRetry.setBounds(340, 277, 90, 32);
		btnRetry.setContentAreaFilled(false);
		btnRetry.setBorder(null);
		btnRetry.setEnabled(false);
		
		/*----------------------*/
		contentPane.add(btnRetry);
		contentPane.add(btnPlay);
		happy.setIcon(new ImageIcon(TelaForca.class.getResource("/images/happya.png")));
		happy.setBounds(265, 90, 188, 180);
		happy.setVisible(false);
		contentPane.add(happy);
		contentPane.add(sad);
		contentPane.add(gameOver);
		//lblResult.setBorder(BorderFactory.createEmptyBorder(4, 7, 2, 7));
		
		
		
		JPanel background = new JPanel();
		background.setBackground(new Color(0, 0, 0, 210));
		background.setForeground(Color.BLACK);
		background.setBounds(0, 0, 623, 340);
		background.setVisible(false);
		contentPane.add(background);
		
		JPanel panel = new JPanel();
		panel.setBounds(364, 64, 240, 231);
		contentPane.add(panel);
		panel.setOpaque(false);
		
		JPanel panelPalavra = new JPanel();
		panelPalavra.setBounds(0, 287, 613, 37);
		contentPane.add(panelPalavra);
		panelPalavra.setOpaque(false);
		
		JPanel panelDica = new JPanel();
		panelDica.setBounds(60, 11, 512, 37);
		contentPane.add(panelDica);
		panelDica.setOpaque(false);
		
		
		
		
		/*--------------------------------------------------- */
		
		/*Escrevendo a dica no panel */
		JLabel lblDica = new JLabel(dicaSort);
		lblDica.setForeground(Color.WHITE);
		lblDica.setFont(new Font("Tahoma", Font.BOLD, 16));
		//lblDica.setBounds(88, 58, 72, 14);
		panelDica.add(lblDica);
		/*---------------------------------------------------*/
		
		/*CRIAÇÃO DOS BONEQUIN*/
		JLabel vod6 = new JLabel("");
		vod6.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod6.png")));
		vod6.setBounds(240, 186, 46, 60);
		contentPane.add(vod6);
		vod6.setVisible(false);
		
		JLabel vod5 = new JLabel("");
		vod5.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod5.png")));
		vod5.setBounds(210, 184, 105, 68);
		contentPane.add(vod5);
		vod5.setVisible(false);
		
		JLabel vod3 = new JLabel("");
		vod3.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod3.png")));
		vod3.setBounds(178, 135, 65, 60);
		contentPane.add(vod3);
		vod3.setVisible(false);
		
		JLabel vod2 = new JLabel("");
		vod2.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod4.png")));
		vod2.setBounds(176, 121, 77, 91);
		contentPane.add(vod2);
		vod2.setVisible(false);
		
		JLabel vod1 = new JLabel("");
		vod1.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod1.png")));
		vod1.setBounds(184, 75, 77, 91);
		contentPane.add(vod1);
		vod1.setVisible(false);
		
		JLabel vod4 = new JLabel("");
		vod4.setIcon(new ImageIcon(TelaForca.class.getResource("/images/vod2.png")));
		vod4.setBounds(236, 125, 95, 66);
		contentPane.add(vod4);
		vod4.setVisible(false);
		
		

		
		//vod1.setVisible(false);
		/*---------------------------------------------------------------------------------*/
		
		/*Criação dos buttons da palavra */
		int tamPalavra = palavraSort.length();
		JButton btnPalavra[] = new JButton[tamPalavra];
		for(int i=0; i<tamPalavra; i++) {
			words = palavraSort.split("");
			btnPalavra[i] = new JButton(" ");
			btnPalavra[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			btnPalavra[i].setForeground(Color.WHITE);
			btnPalavra[i].setIcon(new ImageIcon(TelaForca.class.getResource("/images/ty.png")));
			btnPalavra[i].setContentAreaFilled(false);
			btnPalavra[i].setBorder(null);
			btnPalavra[i].setFocusable(false);
			btnPalavra[i].setVerticalTextPosition(SwingConstants.CENTER);
		    btnPalavra[i].setHorizontalTextPosition(SwingConstants.CENTER);
			btnPalavra[i].setFocusable(false);
			btnPalavra[i].setBounds(i*30, 0, 40, 30);
			btnPalavra[i].setMinimumSize(new Dimension(40, 30));
			btnPalavra[i].setMaximumSize(new Dimension(40, 30));
			
			panelPalavra.add(btnPalavra[i]);
			
		}
		/*-----------------------------------------------------------------------------------------------*/
		/*Btn enviar */
		JButton btnEnviar = new JButton("");
		btnEnviar.setContentAreaFilled(false);
		btnEnviar.setBorder(null);
		btnEnviar.setFocusable(false);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tentativa = txtResposta.getText().toUpperCase();
				boolean ganhou = jogo.advinhar(tentativa);
				String[] letras = jogo.getPalavraSorteada().split("");
				for(int i=0; i<letras.length; i++) {
					btnPalavra[i].setText(letras[i]);
				}
				background.setVisible(true);
				gameOver.setVisible(true);
				txtResposta.setEnabled(false);
				btnEnviar.setEnabled(false);
				
				btnPlay.setEnabled(true);
				btnRetry.setEnabled(true);
				desabilita();
				
				lblEr.setVisible(true);
				lblCer.setVisible(true);
				
				lblPal.setVisible(true);
				lblCer.setText(Integer.toString(jogo.getAcertos()));
				lblEr.setText(Integer.toString(jogo.getErros()));
				lblPal.setText(jogo.getPalavraSorteada());
				audio.stop();
				//audio.player("lose");
				
				
				if(ganhou) {
					happy.setVisible(true);
					lblWin.setVisible(true);
					audio.player("win");
				}else {
					vod1.setVisible(true);
					vod2.setVisible(true);
					vod3.setVisible(true);
					vod4.setVisible(true);
					vod5.setVisible(true);
					vod6.setVisible(true);
					sad.setVisible(true);
					lblLose.setVisible(true);
					audio.player("lose");
				}
				
			}
		});
		/*-----------------------------------*/
		/*Criação dos buttons do teclado*/
		 
		for (int i=0; i<2 ;i++){
			for(int j=0; j<13; j++){
				
				btn[i][j] = new JButton(str[i][j]);
				btn[i][j].setFont(new Font("Tahoma", Font.BOLD, 14));
				btn[i][j].setForeground(Color.WHITE);
				btn[i][j].setBounds(j*30, i*30, 30, 30);
				btn[i][j].setIcon(new ImageIcon(TelaForca.class.getResource("/images/ty.png")));
				btn[i][j].setContentAreaFilled(false);
				btn[i][j].setBorder(null);
				btn[i][j].setFocusable(false);
				btn[i][j].setVerticalTextPosition(SwingConstants.CENTER);
			    btn[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				panel.add(btn[i][j]);
				btn[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int flag = 0;
						JButton btn = (JButton)e.getSource();
						String letra = btn.getText();
						//chamar a funcao jogar
						int pos[] = jogo.jogar(letra);
						if(pos != null) {
							for(int i=0; i< pos.length; i++) {
								 btnPalavra[pos[i]].setText(words[pos[i]]);					
								
							}
							
						}
						
							if(jogo.getAcertos() == jogo.getPalavraSorteada().length()) {
								
								background.setVisible(true);
								gameOver.setVisible(true);
								txtResposta.setEnabled(false);
								btnEnviar.setEnabled(false);
								desabilita();
								happy.setVisible(true);
								
								btnPlay.setEnabled(true);
								btnRetry.setEnabled(true);
								
								lblEr.setVisible(true);
								lblCer.setVisible(true);
								lblWin.setVisible(true);
								lblPal.setVisible(true);
								lblCer.setText(Integer.toString(jogo.getAcertos()));
								lblEr.setText(Integer.toString(jogo.getErros()));
								lblPal.setText(jogo.getPalavraSorteada());
								audio.stop();
								audio.player("win");
								
							}
							//*FAZER O BONEQUIN APARECER */
							if(jogo.getErros()==1) {
								vod1.setVisible(true);
							}else if(jogo.getErros()==2) {
								vod2.setVisible(true);
							}else if(jogo.getErros()==3) {
								vod3.setVisible(true);
							}else if(jogo.getErros()==4) {
								vod4.setVisible(true);
							}else if(jogo.getErros()==5) {
								vod5.setVisible(true);
							}else if(jogo.getErros()==6) {
								vod6.setVisible(true);
								background.setVisible(true);
								gameOver.setVisible(true);
								txtResposta.setEnabled(false);
								btnEnviar.setEnabled(false);
								btnPlay.setEnabled(true);
								btnRetry.setEnabled(true);
								desabilita();
								sad.setVisible(true);
								
								lblEr.setVisible(true);
								lblCer.setVisible(true);
								lblLose.setVisible(true);
								lblPal.setVisible(true);
								lblCer.setText(Integer.toString(jogo.getAcertos()));
								lblEr.setText(Integer.toString(jogo.getErros()));
								lblPal.setText(jogo.getPalavraSorteada());
								audio.stop();
								audio.player("lose");
								
								
							}
							
							
							//*--------------------------------------------------------------*/
						
						btn.setBackground(Color.green);
						//btn.setOpaque(true);
						btn.setEnabled(false );
						
					}
				});
			}
		}
		
		/*Sets of cursor */
		Toolkit tk = Toolkit.getDefaultToolkit (); 
		Image img= tk.createImage(getClass().getResource("/images/zombie1.png"));  
		Point hotspot = new Point (6,0) ;
		String nameCursor = "alvo";
		Cursor cursor = tk.createCustomCursor( img , hotspot, nameCursor);
		panel.setCursor(cursor);
		
		/*-----------------------------------------------------------------*/
		txtResposta = new JTextField();
		txtResposta.setBounds(38, 125, 100, 24);
		contentPane.add(txtResposta);
		txtResposta.setColumns(10);
		txtResposta.setOpaque(false);
		txtResposta.setForeground(Color.WHITE);
		txtResposta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtResposta.setCaretColor(Color.WHITE);
		
		btnEnviar.setBounds(52, 163, 70, 25);
		contentPane.add(btnEnviar);
		JLabel back = new JLabel("resposta");
		back.setBounds(0, 0, 623, 340);
		contentPane.add(back);
		back.setIcon(new ImageIcon(TelaForca.class.getResource("/images/village12.jpg")));
		btnEnviar.setCursor(cursor);
		btnRetry.setCursor(cursor);
		btnPlay.setCursor(cursor);
	}
	public void desabilita() {
		for(int i =0; i<2; i++) {
			for(int j = 0; j<13; j++) {
				btn[i][j].setVisible(false);
			}
		}
	}
}
