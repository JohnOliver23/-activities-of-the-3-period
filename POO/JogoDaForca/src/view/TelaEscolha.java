package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaEscolha extends JFrame {


	private JPanel contentPane;
	private Song audio = new Song();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolha frame = new TelaEscolha();
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
	public TelaEscolha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("John Oliver e Kamila Freitas");
		setResizable(false);
		/*criação dos objetos*/
		audio.player("exorcismo");
		
		JButton btnAnimais = new JButton("");
		btnAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(1);
				te.setVisible(true);
				
				
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(125, 79, 190, 243);
		contentPane.add(panel);
		panel.setOpaque(false);
		
		
		
		btnAnimais.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnimais.setBounds(153, 228, 141, 38);
		btnAnimais.setContentAreaFilled(false);
		btnAnimais.setBorder(null);
		btnAnimais.setFocusable(false);
		contentPane.add(btnAnimais);
		
		JButton btnPais = new JButton("");
		btnPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(2);
				te.setVisible(true);
				
			}
		});
		btnPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPais.setBounds(153, 91, 141, 38);
		btnPais.setContentAreaFilled(false);
		btnPais.setBorder(null);
		btnPais.setFocusable(false);
		
		contentPane.add(btnPais);
		
		JButton btnFruta = new JButton("");
		btnFruta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(3);
				te.setVisible(true);
				
			}
		});
		btnFruta.setBounds(160, 275, 128, 38);
		btnFruta.setContentAreaFilled(false);
		btnFruta.setBorder(null);
		btnFruta.setFocusable(false);
		contentPane.add(btnFruta);
		
		JButton btnCuri = new JButton("");
		btnCuri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(4);
				te.setVisible(true);
				
			}
		});
		btnCuri.setBounds(160, 134, 141, 38);
		btnCuri.setContentAreaFilled(false);
		btnCuri.setBorder(null);
		btnCuri.setFocusable(false);
		contentPane.add(btnCuri);
		
		JButton btnIngles = new JButton("");
		btnIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.stop();
				dispose();
				TelaForca te = new TelaForca(5);
				te.setVisible(true);
				
			}
		});
		btnIngles.setBounds(153, 180, 138, 38);
		btnIngles.setContentAreaFilled(false);
		btnIngles.setBorder(null);
		btnIngles.setFocusable(false);
		contentPane.add(btnIngles);
		
		/*Sets of cursor */
		Toolkit tk = Toolkit.getDefaultToolkit (); 
		Image img= tk.createImage(getClass().getResource("/images/zombie1.png"));  
		Point hotspot = new Point (6,0) ;
		String nameCursor = "alvo";
		Cursor cursor = tk.createCustomCursor( img , hotspot, nameCursor);
		panel.setCursor(cursor);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaEscolha.class.getResource("/images/frentee.jpg")));
		lblNewLabel_1.setBounds(0, 0, 514, 346);
		contentPane.add(lblNewLabel_1);
	}
	public void tocarMusica() {
		this.audio.player("exorcismo");
	}
}
