package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mural;

public class MuralDAO {
	

	public Mural carregarMeusPosts(int ID_Criador) {
		Mural registrar = new Mural();
		registrar.setId_criador(ID_Criador);
		String sqlSelect = "SELECT Titulo, Conteudo, Resposta FROM post ID_Criador = ? and Aceite = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, registrar.getId_criador());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					registrar.setTitulo(rs.getString("Titulo"));
					registrar.setConteudo(rs.getString("Conteudo"));
					registrar.setResposta(rs.getString("Resposta"));
					registrar.setId_criador(rs.getInt("ID_Criador"));
					registrar.setAceite(rs.getInt("Aceite"));
				} else {
					registrar.setTitulo(null);
					registrar.setConteudo(null);
					registrar.setResposta(null);


				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return registrar;
	}
	
	public List<Mural> carregarTodosPosts() {
		Mural mural;
		
		List<Mural> lista = new ArrayList<Mural>();
		
		String sqlSelect = "SELECT ID, Titulo, Conteudo FROM post where Aceite = 1;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					mural = new Mural();
					mural.setId(rs.getInt("ID"));
					mural.setTitulo(rs.getString("Titulo"));
					mural.setConteudo(rs.getString("Conteudo"));
					
					lista.add(mural);
					
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
