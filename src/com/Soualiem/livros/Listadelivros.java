package com.Soualiem.livros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Key;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Listadelivros extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Conexão con = new Conexão();
	public static String o;
	public static JLabel AutorBd;
	public static JLabel generoBd;
	public static JTextArea sinopse;
	public static JLabel imagemLivro;
	public static JLabel NomeBd;
	private JTextField EntradaPesquisa;
	public static DefaultListModel<String> df = new DefaultListModel<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listadelivros frame = new Listadelivros();
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
	public Listadelivros() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1093, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1093, 720);
		ImageIcon ref = new ImageIcon("res//back.jpg");
		setTitle("My Personal Teca");
		setResizable(false);
		
		getContentPane().setFont(new Font("Bitstream Charter", Font.BOLD, 31));
		getContentPane().setBackground(new Color(176, 224, 230));
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel titu = new JLabel("PersonalTeca");
		titu.setFont(new Font("Agent Orange", Font.BOLD, 46));
		titu.setBounds(395, 23, 545, 149);
		getContentPane().add(titu);
		
		JLabel lblMy = new JLabel("My");
		lblMy.setFont(new Font("Purisa", Font.BOLD, 21));
		lblMy.setBounds(345, 108, 112, 49);
		getContentPane().add(lblMy);
		
		JLabel img = new JLabel(new ImageIcon("res//back.jpg"));
		img.setBounds(44, 43, 271, 588);
		getContentPane().add(img);
		
		JScrollPane js = new JScrollPane();
		con.atualizarListaModelo(df, con.getNomesArrayList());
		
		JList<String> list = new JList<String>(df);
		list.setBounds(348, 247, 361, 405);
		
		contentPane.add(list);
		
		imagemLivro = new JLabel("");
		imagemLivro.setBounds(727, 184, 200, 200);
		contentPane.add(imagemLivro);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(724, 396, 70, 15);
		contentPane.add(lblNewLabel);
		
		NomeBd = new JLabel("");
		NomeBd.setBounds(811, 396, 207, 15);
		contentPane.add(NomeBd);
		
		JLabel Autor = new JLabel("Autor:");
		Autor.setFont(new Font("Dialog", Font.BOLD, 14));
		Autor.setBounds(724, 433, 70, 15);
		contentPane.add(Autor);
		
		AutorBd = new JLabel("");
		AutorBd.setBounds(811, 433, 207, 15);
		contentPane.add(AutorBd);
		
		JLabel label = new JLabel("Genero:");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(724, 474, 70, 15);
		contentPane.add(label);
		
		generoBd = new JLabel("");
		generoBd.setBounds(811, 474, 207, 15);
		contentPane.add(generoBd);
		
		sinopse = new JTextArea();
		JScrollPane jsp = new JScrollPane(sinopse);
		sinopse.setEditable(false);
		sinopse.setLineWrap(true);
		jsp.setBounds(793, 517, 254, 135);
		contentPane.add(jsp);
		
		JLabel lblNewLabel_1 = new JLabel("Sinopse");
		lblNewLabel_1.setBounds(884, 490, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		EntradaPesquisa = new JTextField();
		EntradaPesquisa.setBounds(472, 217, 114, 19);
		contentPane.add(EntradaPesquisa);
		EntradaPesquisa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pesquisar");
		lblNewLabel_2.setFont(new Font("Agent Orange", Font.BOLD, 12));
		lblNewLabel_2.setBounds(354, 220, 132, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton pesquisar = new JButton();
		
		Image seta = new ImageIcon("res/seta.png").getImage().getScaledInstance(23, 18, 100);
		pesquisar.setIcon(new ImageIcon(seta));
		
		pesquisar.addActionListener(this);
			
		pesquisar.setBounds(592, 217, 23, 18);
		contentPane.add(pesquisar);
		
		JButton Btdeletar = new JButton("Deletar");
		Btdeletar.setEnabled(false);
		Btdeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Btdeletar.setBounds(930, 655, 117, 25);
		contentPane.add(Btdeletar);
		
		
			
	
		
		setTitle("My Personal Teca");
		setResizable(false);
		
	
		
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	
		        JList list = (JList)evt.getSource();
		        int index = 0;
		        if (evt.getClickCount() == 2) {
		            index = list.locationToIndex(evt.getPoint());
		            o = list.getModel().getElementAt(index).toString();
					AutorBd.setText(con.getid(o, "titulo", "autor"));
					generoBd.setText(con.getid(o, "titulo", "genero"));
					sinopse.setText(con.getid(o, "titulo", "sinopse"));
					NomeBd.setText(o);
					Image i = new ImageIcon(con.getid(o, "titulo", "img")).getImage().getScaledInstance(200, 200, 100);
					imagemLivro.setIcon(new ImageIcon(i));
					
					
		        } 
		        
				
		    }
		});
		
		
		
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
String Itemdapesquisa = EntradaPesquisa.getText();
		
		if(Itemdapesquisa.isEmpty()){
			
			
		}else{
			df.removeAllElements();
			con.atualizarListaModelo(df, con.pesquisa(Itemdapesquisa));
			
		}
		
	}
}
