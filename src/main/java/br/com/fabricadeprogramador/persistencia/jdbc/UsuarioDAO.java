package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection(); 
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		
		try {
			PreparedStatement prepstm = con.prepareStatement(sql);
			prepstm.setString(1,usu.getNome());
			prepstm.setString(2,usu.getLogin());
			prepstm.setString(3,usu.getSenha());
			prepstm.execute();
			prepstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome = ?,login = ?,senha = ? where id = ?";
		
		try {
			PreparedStatement prepstm = con.prepareStatement(sql);
			prepstm.setString(1,usu.getNome());
			prepstm.setString(2,usu.getLogin());
			prepstm.setString(3,usu.getSenha());
			prepstm.setInt(4,usu.getId());
			prepstm.execute();
			prepstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void excluir(Usuario usu) {
	
		String sql = "delete from usuario where id = ?";
		
		try {
			PreparedStatement prepstm = con.prepareStatement(sql);
			prepstm.setInt(1,usu.getId());
			prepstm.execute();
			prepstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}
}
