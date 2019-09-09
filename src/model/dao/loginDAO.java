package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bean.beanlogin;


public class loginDAO {
	private Connection connection;
	
	public loginDAO() {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void Buscar(beanlogin ll) throws SQLException, Exception{
		
				String sql ="Select * from login where usuario"+"(usuario,senha)"+"values(?,?)";
				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, ll.getUsuario());
					stmt.setString(2, ll.getSenha());
					stmt.execute();
					
					stmt.close();
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
	}

	public void Create(beanlogin ll) throws SQLException, Exception{

		String sql = "INSERT INTO login" + 
				"(usuario, senha)" + "values(?,?)";	
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, ll.getUsuario());
			stmt.setString(2, ll.getSenha());
			stmt.execute();
			stmt.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	}