package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNaval extends JFrame {

	private JPanel contentPane;
	private JButton [][] button = new JButton[10][10];
	private JButton btnselect;
	private JButton btnprox;
	int sort;//numero sorteado
	private static int point10 = 0;//flag que guarda o barco de 10 pontos
	int init = 0;//tamanho do array
	int array[] = new int[10];
	private TelaNaval jogo;
	int imgProx;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNaval frame = new TelaNaval();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaNaval() {
		setTitle("John");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblLife = new JLabel("15");
		lblLife.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLife.setBounds(185, 127, 46, 14);
		contentPane.add(lblLife);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Pontos: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(326, 127, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblTentativas = new JLabel("Tentativas: ");
		lblTentativas.setBounds(103, 127, 86, 14);
		contentPane.add(lblTentativas);
		lblTentativas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPoints = new JLabel("0");
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoints.setBounds(386, 127, 46, 14);
		contentPane.add(lblPoints);
		
		JButton btnRestart = new JButton("New button");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaNaval t = new TelaNaval();
				t.setVisible(true);
			}
		});
		btnRestart.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/restart2.png")));
		btnRestart.setBounds(475, 495, 163, 46);
		btnRestart.setContentAreaFilled(false);
		btnRestart.setBorder(null);
		btnRestart.setFocusable(false);
		btnRestart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnRestart);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 152, 410, 407);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		/*SETS OF CURSOR*/
		Toolkit tk = Toolkit.getDefaultToolkit (); 
		Image img= tk.createImage(getClass().getResource("/images/yt.png"));  
		Point hotspot = new Point (15,15) ;
		String nameCursor = "alvo";
		Cursor cursor = tk.createCustomCursor( img , hotspot, nameCursor);
		panel.setCursor(cursor);
		
		JLabel lbl10 = new JLabel("");
		lbl10.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/b10.jpg")));
		lbl10.setBounds(475, 208, 177, 80);
		contentPane.add(lbl10);
		lbl10.setVisible(false);
		
		JLabel lblb5 = new JLabel("");
		lblb5.setBounds(475, 301, 177, 88);
		contentPane.add(lblb5);
		lblb5.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/bbb5.jpg")));
		lblb5.setVisible(false);
		
		JLabel lbl15 = new JLabel("");
		lbl15.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/b15.jpg")));
		lbl15.setBounds(475, 112, 163, 84);
		contentPane.add(lbl15);
		lbl15.setVisible(false);
		
		JLabel lbl20 = new JLabel("");
		lbl20.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/b20.jpg")));
		lbl20.setBounds(475, 22, 165, 80);
		contentPane.add(lbl20);
		lbl20.setVisible(false);
		/*Criação da classe */
		BatalhaNaval jogo = new BatalhaNaval();
		//criação dos buttons
		for (int i =0; i< 10; i++) {
			for(int j=0; j<10; j++) {
				button[i][j] = new JButton("");
				
				button[i][j].setBounds(i*40, j*40, 40, 40);
				button[i][j].setContentAreaFilled(false);
				button[i][j].setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
				button[i][j].setIcon(new ImageIcon(TelaNaval.class.getResource("/images/trans.png")));
				button[i][j].setDisabledIcon(new ImageIcon(TelaNaval.class.getResource("/images/buum.png")));
				button[i][j].setSelectedIcon(new ImageIcon(TelaNaval.class.getResource("/images/buum.png")));
				panel.add(button[i][j]);
				
				
				if(i ==9 && j ==9) {
					for(int k=1; k<5; k++) {
						
						int alex = jogo.sortear();
						int aley = jogo.sortear();
						
						if(k ==2) {//gera os barcos de 10 points
							int flagOk = 1;
							while(flagOk !=0) {
								flagOk=0;
								alex = jogo.sortear();
								aley = jogo.sortear();
								//verifica margem
								while ((alex +1) > 9 ) {
									alex = jogo.sortear();
									aley = jogo.sortear();
									System.out.println("puts");
								}
							
								//verifica colisões
								for(int p=0; p<=1; p++) {
									Icon test = button[alex+p][aley].getDisabledIcon();
									int test2 = test.toString().replaceAll("(\\w+|[0-9]).png", "").length();
									String testando = test.toString().substring(test2, test.toString().length());
									if(!testando.equals("buum.png")) {
										System.out.println("erro no point 10 : "+testando);
										  flagOk++;//ocorreu a colisão
									}
								}//fim do for
							}
							
							for(int y =0; y<=1; y++ ) {
								button[alex+y][aley].setIcon(new ImageIcon(TelaNaval.class.getResource("/images/trans.png")));
								button[alex+y][aley].setDisabledIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(k+y)+".png")));
								button[alex+y][aley].setSelectedIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(k+y)+".png")));
								
							}
							
						}else if(k ==1) {//gera os barcos de 5 points
							for(int l =0; l<3; l++) {
								alex = jogo.sortear();
								aley = jogo.sortear();
								Icon test = button[alex][aley].getDisabledIcon();
								int test2 = test.toString().replaceAll("(\\w+|[0-9]).png", "").length();
								String testando = test.toString().substring(test2, test.toString().length());
								
								while(!testando.equals("buum.png")) {
										System.out.println("erro no point5");
										 alex = jogo.sortear();
										 aley = jogo.sortear();
										 test = button[alex][aley].getDisabledIcon();
										 test2 = test.toString().replaceAll("(\\w+|[0-9]).png", "").length();
										 testando = test.toString().substring(test2, test.toString().length());
										 System.out.println("point 5 depois teste: "+testando);
										 
									
									
								}
								button[alex][aley].setIcon(new ImageIcon(TelaNaval.class.getResource("/images/trans.png")));	
								button[alex][aley].setDisabledIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+k+".png")));
								button[alex][aley].setSelectedIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+k+".png")));
							}
						}
						else if(k == 3) {//criando os submarinos de 15 points
							int flagOk = 1;
							while(flagOk !=0) {
								flagOk=0;
								alex = jogo.sortear();
								aley = jogo.sortear();
								//verifica margem
								while ((alex +2) > 9 ) {
									alex = jogo.sortear();
									aley = jogo.sortear();
									System.out.println("puts");
								}
							
								//verifica colisões
								for(int p=0; p<=2; p++) {
									Icon test = button[alex+p][aley].getDisabledIcon();
									int test2 = test.toString().replaceAll("(\\w+|[0-9]).png", "").length();
									String testando = test.toString().substring(test2, test.toString().length());
								
									if(!testando.equals("buum.png")) {
										System.out.println("erro no point 15 : "+testando);
										  flagOk++;//ocorreu a colisão
									}
								}//fim do for
							}
							
							for(int y=0; y<=2; y++) {
								button[alex+y][aley].setIcon(new ImageIcon(TelaNaval.class.getResource("/images/trans.png")));
								button[alex+y][aley].setDisabledIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(4+y)+".png")));
								button[alex+y][aley].setSelectedIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(4+y)+".png")));
								
							}
						}else if(k ==4) {//criando os submarino de 20 points
							int flagOk = 1;
							
							while(flagOk !=0) {
								flagOk=0;
								alex = jogo.sortear();
								aley = jogo.sortear();
								//verifica margem
								while ((aley +3) > 9 ) {
									alex = jogo.sortear();
									aley = jogo.sortear();
									System.out.println("puts");
								}
								
								//verifica colisões
								for(int p=0; p<=3; p++) {
									Icon test = button[alex][aley+p].getDisabledIcon();
									int test2 = test.toString().replaceAll("(\\w+|[0-9]).png", "").length();
									String testando = test.toString().substring(test2, test.toString().length());
								
								
									if(!testando.equals("buum.png")) {
										System.out.println("erro no point 20 : "+testando);
										  flagOk++;//ocorreu a colisão
									}
								}//fim do for
							}//fim do while
							
							
							for(int y =0; y<=3; y++) {
								
								button[alex][(aley+y)].setIcon(new ImageIcon(TelaNaval.class.getResource("/images/trans.png")));
								button[alex][(aley+y)].setDisabledIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(7+y)+".png")));
								button[alex][(aley+y)].setSelectedIcon(new ImageIcon(TelaNaval.class.getResource("/images/"+(7+y)+".png")));
								
							}
						}
						
					}
				}
				button[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnselect = (JButton)e.getSource();
						btnselect.setEnabled(false);
						Icon s = btnselect.getDisabledIcon();
						int test2 = s.toString().replaceAll("(\\w+|[0-9]).png", "").length();
						String nameButton = s.toString().substring(test2, s.toString().length());
						
						
						
						if(nameButton.equals("buum.png")) {
							jogo.decrementaLife();
							lblLife.setText(Integer.toString(jogo.getLife()));
							
						}else  {
							if(nameButton.equals("1.png")) {
								lblb5.setVisible(true);
							}
							if(nameButton.equals("2.png")||nameButton.equals("3.png")) {
								jogo.setBoat10(jogo.getBoat10()+1);
							}
							if (nameButton.equals("4.png")||nameButton.equals("5.png")||nameButton.equals("6.png")) {
								jogo.setBoat15(jogo.getBoat15()+1);
							}
							if (nameButton.equals("7.png")||nameButton.equals("8.png")||nameButton.equals("9.png")||nameButton.equals("10.png")) {
								jogo.setBoat20(jogo.getBoat20()+1);
							}
							if(jogo.getBoat10() == 2) {
								lbl10.setVisible(true);
							}
							if(jogo.getBoat15() == 3) {
								lbl15.setVisible(true);
							}
							
							if(jogo.getBoat20() == 4) {
								lbl20.setVisible(true);
							}
							jogo.setPoints(jogo.getPoints()+5);
							jogo.addLife();
							lblPoints.setText(Integer.toString(jogo.getPoints()));
							lblLife.setText(Integer.toString(jogo.getLife()));
						}
						
						if(jogo.getLife() ==0) {
							JOptionPane.showMessageDialog(null, "<html>Game Over!<br>seus pontos foram : "+jogo.getPoints()+"!");
							for(int i=0; i<10; i++) {
								for(int j=0; j<10; j++) {
									button[i][j].setEnabled(false);
								}
							}
							
							return;
							
						}
						if(jogo.getPoints() == 50) {
							JOptionPane.showMessageDialog(null, "<html>Parabéns, Você venceu !<br>seus pontos foram : "+jogo.getPoints()+"!");
							for(int i=0; i<10; i++) {
								for(int j=0; j<10; j++) {
									button[i][j].setEnabled(false);
								}
							}
							return;
						}
						
						
					}
				});
			}
			
			
		}
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaNaval.class.getResource("/images/imgtom.jpg")));
		lblNewLabel.setBounds(0, 0, 700, 603);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
}
