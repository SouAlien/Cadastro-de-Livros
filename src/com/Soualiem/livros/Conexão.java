package com.Soualiem.livros;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
public class Conexão {
	Connection con;
	public static Statement st;
	public static ResultSet rt;
	private static ArrayList<String> result= new ArrayList<>();
	public Conexão () {
		try {
			con = DriverManager.getConnection("jdbc:sqlite:res//Livros.ray");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Updatetudo(String autor,String titulo,String genero,String sinopse,String img ){
		String query = "insert into livros (autor,titulo,genero,sinopse,img) values('"+autor+"','"+titulo+"','"+genero+"','"+sinopse+"','"+img+"')";
		Statement st;
		try {
			st = con.createStatement();
			int rt = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro aqui ");
		}
		
	}
	public ArrayList<String> getNomesArrayList(){
		String query = "select *from livros";
		
		try {
			st = con.createStatement();
			rt = st.executeQuery(query);
			
			while(rt.next()){
				result.add(rt.getString("titulo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public void atualizarListaModelo(DefaultListModel<String> e,ArrayList<String> a){
		for (int i = 0; i < a.size(); i++) {
			e.add(i, a.get(i));
		}
	}
	public ArrayList<String> pesquisa(String palavra){
		
		ArrayList<String> result = new ArrayList<String>();
		
		String query = "select titulo from livros where titulo like '"+palavra.concat("%")+"'";
		try {
			st = con.createStatement();
			rt = st.executeQuery(query);
			while(rt.next()){
				result.add(rt.getString("titulo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	public String getItem(int id,String coluna ){
		String query = "select *from livros where id ="+id;
		String result = "erro";		
		try {
			st = con.createStatement();
			rt = st.executeQuery(query);
			
			while(rt.next()){
				result = rt.getString(coluna);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
		
	}
	public String getid(String Buscar, String Coluna,String pegaressaColuna){
		String query = "SELECT * FROM livros WHERE "+Coluna+" = '"+Buscar+"'";
		Integer result = 0;
		String resultString = null;
		try {
			Statement st = con.createStatement();
			ResultSet rt = st.executeQuery(query);
			while(rt.next()){
			if(pegaressaColuna.equalsIgnoreCase("id")){
				 result = rt.getInt("id");
				resultString = result.toString();
			}
			else{
				resultString = rt.getString(pegaressaColuna);
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultString;
		
 }
	public void deletar(String coluna,String item) throws SQLException{
		String query = "delete from livros where "+coluna+" = "+item;
		st = con.createStatement();
		rt = st.executeQuery(query);

		
	}
}

