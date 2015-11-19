package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testeExcluir();
	}

	public static void testeExcluir() {
		
		Usuario usu = new Usuario();
		// Alterando o usuário
		usu.setId(4);
		// Cadastrando usuário no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		try {
			usuDAO.excluir(usu);
			System.out.println("Excluído com sucesso!");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void testeAlterar() {
		
		Usuario usu = new Usuario();
		// Alterando o usuário
		usu.setId(4);
		usu.setNome("Usuario III");
		usu.setLogin("usuarioIII");
		usu.setSenha("iii");
		// Cadastrando usuário no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		try {
			usuDAO.alterar(usu);
			System.out.println("Alterado com sucesso!");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void testeCadastrar() {
		
		Usuario usu = new Usuario();
		// Criando o usuário
		usu.setNome("Usuario 3");
		usu.setLogin("usuario3");
		usu.setSenha("12345");
		// Cadastrando usuário no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		try {
			usuDAO.cadastrar(usu);
			System.out.println("Cadastrado com sucesso!");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}