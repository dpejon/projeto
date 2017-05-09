package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RegistrarELogin;

public class RegistrarDAO {
	public int criar(RegistrarELogin registrar) {
		String sqlInsert = "INSERT INTO usuario(Nome,Email, Senha, Login, Nivel) VALUES (?, ?, ?, ?, 1)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, registrar.getNome());
			stm.setString(2, registrar.getEmail());
			stm.setString(3, registrar.getSenha());
			stm.setString(4, registrar.getLogin());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					registrar.setId(rs.getInt(1));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrar.getId();
	}

	public void atualizar(RegistrarELogin registrar) {
		String sqlUpdate = "UPDATE usuario SET Nome=?,Email=?, Senha=?, Login=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, registrar.getNome());
			stm.setString(2, registrar.getNome());
			stm.setString(3, registrar.getSenha());
			stm.setString(4, registrar.getLogin());
			stm.setInt(4, registrar.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE ID = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public RegistrarELogin login(String login, String senha) {
		RegistrarELogin registrar = new RegistrarELogin();
		registrar.setLogin(login);
		registrar.setSenha(senha);
		String sqlSelect = "select ID,Login,Senha from usuario where Login = ? and Senha = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, registrar.getLogin());
			stm.setString(2, registrar.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					registrar.setId(rs.getInt("ID"));
					registrar.setLogin(rs.getString("Login"));
					registrar.setSenha(rs.getString("Senha"));
					
				} else {
					registrar.setId(0);
					registrar.setLogin(null);
					registrar.setSenha(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return registrar;
	}
	

	public RegistrarELogin carregar(String login) {
		RegistrarELogin registrar = new RegistrarELogin();
		registrar.setLogin(login);
		String sqlSelect = "SELECT ID, Login FROM usuario WHERE Login = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, registrar.getLogin());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					registrar.setId(rs.getInt("ID"));
					registrar.setLogin(rs.getString("Login"));

				} else {
					registrar.setId(0);
					registrar.setLogin(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return registrar;
	}
	
	public List<RegistrarELogin> carregarTodasAreas() {
		RegistrarELogin registrar;
		
		List<RegistrarELogin> lista = new ArrayList<RegistrarELogin>();
		
		String sqlSelect = "SELECT * FROM usuario;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					registrar = new RegistrarELogin();
					registrar.setId(rs.getInt("ID"));
					registrar.setNome(rs.getString("Nome"));
					
					
					lista.add(registrar);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
