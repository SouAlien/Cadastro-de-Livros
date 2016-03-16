package com.Soualiem.livros;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer.Form;

import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.JButton;


public class Janela extends JFrame {

	private static final Component String = null;
	private JPanel contentPane;
	private JTextField autor;
	private JTextField titulo;
	private Generos gen;
	private static String caminhoImagemlabel = "res//livro.jpg";
	public static ImageIcon im = new ImageIcon(caminhoImagemlabel);
	public static String GeneroSelecionado;
	public static JLabel img1;
	public static Conexão con = new Conexão();
	public static String files;
	public static File file;
	public static JEditorPane sinopse1;
	FileInputStream origem;   
	FileOutputStream destino;  
	  
	public static FileChannel fcOrigem;  
	public static  FileChannel fcDestino;  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		getContentPane().setFont(new Font("Bitstream Charter", Font.BOLD, 46));
		getContentPane().setBackground(new Color(176, 224, 230));
		getContentPane().setLayout(null);
		
		JLabel titu = new JLabel("PersonalTeca");
		titu.setFont(new Font("Agent Orange", Font.BOLD, 46));
		titu.setBounds(395, 12, 545, 160);
		getContentPane().add(titu);
		
		JLabel lblMy = new JLabel("My");
		lblMy.setFont(new Font("Purisa", Font.BOLD, 21));
		lblMy.setBounds(345, 108, 112, 49);
		getContentPane().add(lblMy);
		ImageIcon img3 =
				new ImageIcon("res/back.jpg");
		JLabel img = new JLabel(img3);
		img.setBounds(44, 43, 271, 588);
		getContentPane().add(img);
		
		autor = new JTextField();
		autor.setBounds(540, 201, 235, 19);
		getContentPane().add(autor);
		autor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setFont(new Font("Agent Orange", Font.BOLD, 12));
		lblNewLabel_1.setBounds(395, 204, 70, 15);
		getContentPane().add(lblNewLabel_1);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(540, 232, 235, 19);
		getContentPane().add(titulo);
		
		JLabel label = new JLabel("Titulo");
		label.setFont(new Font("Agent Orange", Font.BOLD, 12));
		label.setBounds(395, 230, 70, 15);
		getContentPane().add(label);
		
		JComboBox genero = new JComboBox(gen.getGeneros());
		genero.setSelectedIndex(0);
		genero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 JComboBox cb = (JComboBox)e.getSource();
				
			     GeneroSelecionado = (String)cb.getSelectedItem();
			     
			}
		});
		genero.setBounds(540, 279, 225, 24);
		getContentPane().add(genero);
		
		JLabel label_1 = new JLabel("Genero");
		label_1.setFont(new Font("Agent Orange", Font.BOLD, 12));
		label_1.setBounds(395, 285, 70, 15);
		getContentPane().add(label_1);
		
		
		
		 sinopse1 = new JEditorPane();
		JScrollPane js = new JScrollPane(sinopse1);
		
		js.setBounds(540, 370, 235, 87);
		getContentPane().add(js);
		
		
		
		JLabel label_2 = new JLabel("Sinopse");
		label_2.setFont(new Font("Agent Orange", Font.BOLD, 12));
		label_2.setBounds(395, 423, 127, 15);
		getContentPane().add(label_2);
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxx
		img1 = new JLabel(im);
		
		img1.setForeground(UIManager.getColor("Button.foreground"));
		
		img1.setBounds(832, 203, 217, 229);
		getContentPane().add(img1);
		
		JButton SImg = new JButton("Selecionar Imagem");
		SImg.setFont(new Font("URW Gothic L", Font.BOLD, 10));
		SImg.setBounds(859, 444, 145, 25);
		getContentPane().add(SImg);
		
		JButton salvar = new JButton("Adicionar Livro");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//arquivo que você quer copiar  
				String defaul = "res//livro.jpg";
				try {
					destino = new FileOutputStream("res//"+ file.getName());
					String si = sinopse1.getText().toString();
			        fcOrigem = origem.getChannel();  
			        fcDestino = destino.getChannel();  
			  
			        fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu  
			        defaul = "res//"+ file.getName().toString();
			        origem.close();  
			        destino.close();  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					
				}finally{
					String auto = autor.getText().toString();
					String titu = titulo.getText().toString();
					String sino = sinopse1.getText().toString();
					
					con.Updatetudo(auto, titu, GeneroSelecionado, sino, defaul);
					
			}
				}
		});
		salvar.setBounds(561, 486, 193, 32);
		getContentPane().add(salvar);
		SImg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			JFileChooser jf = new JFileChooser();
			jf.setCurrentDirectory(new File(System.getProperty("user.home")));
			jf.showOpenDialog(getParent());
			jf.setFileFilter(new FileNameExtensionFilter("Arquivos de imagens", "png","jpg","gif"));
			jf.setAcceptAllFileFilterUsed(false);
			 int returnVal=0;
			if (returnVal == JFileChooser.APPROVE_OPTION) { 
			try{
					file = jf.getSelectedFile();
					files = file.getAbsolutePath();
					Image imageUSU = new ImageIcon(files).getImage().getScaledInstance(200, 200, 100);
					
					origem = new FileInputStream(files);
					img1.setIcon(new ImageIcon(imageUSU));
					
					
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Selecione apenas arquivos png/jpg");
						e.printStackTrace();
						
					}
						
					}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1093, 720);
		ImageIcon ref = new ImageIcon("res//back.jpg");
		setTitle("My Personal Teca");
		setResizable(false);
		
		
		

	}
}
