package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import model.bean.beanlogin;
import model.bean.beanprodutos;
import model.dao.ConnectionFactory;

	public class produtoDAO {
	
		private Connection connection;
			
			public produtoDAO() {
				
				this.connection = new ConnectionFactory().getConnection();
			}
		
	

	public void Create(beanprodutos bp) throws SQLException, Exception{

		String sql = "INSERT INTO produto" + 
				"(Nome, Valor, Unidade)" + "values(?,?,?)";	
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, bp.getNome());
			stmt.setString(2, bp.getValor());
			stmt.setString(3, bp.getUnidade());
			stmt.execute();
			stmt.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
		
	
	//Listar na tabela
	public  java.util.List<beanprodutos> readProduto() {
		Connection con = ConnectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		  ResultSet rs = null;
		  java.util.List<beanprodutos> prod = new ArrayList<beanprodutos>();
	try {
		
		 stmt = con.prepareStatement("select * from produto");
	     rs = stmt.executeQuery();
	     while(rs.next()) {
				beanprodutos bp = new beanprodutos();
				
				bp.setId(rs.getInt("idproduto"));
				bp.setNome(rs.getString("Nome"));
				bp.setValor(rs.getString("Valor"));
				bp.setUnidade(rs.getString("Unidade"));
				
				prod.add(bp);
			}
			rs.close();
			stmt.close();
			
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return prod;
		
	}
	//DELETE
	public void DeletP(beanprodutos bp) {
		
		try {
			PreparedStatement stmt  = connection.prepareStatement("delete from produto where idproduto=?");
			stmt.setInt(1, bp.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "produto deletado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//UPDATE
	public void UpdateP(beanprodutos bp) {
			
			Connection con = ConnectionFactory.getConnection(); 
			PreparedStatement stmt = null;
			try {
				 stmt = con.prepareStatement("update produto set Nome=?, Valor=?, Unidade=? where idproduto=?");
				 	
					stmt.setString(1, bp.getNome());
					stmt.setString(2, bp.getValor());
					stmt.setString(3, bp.getUnidade());
					stmt.setInt(4, bp.getId());
					stmt.execute();
					
				JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
	
	
	
	
	
	
	}
	
	
	

