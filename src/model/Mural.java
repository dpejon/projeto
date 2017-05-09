package model;

import java.io.Serializable;

public class Mural implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String conteudo;
	private String resposta;
	private int area_post;
	private int id_criador;
	private int id_avaliador;
	private int aceite;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public int getArea_post() {
		return area_post;
	}
	public void setArea_post(int area_post) {
		this.area_post = area_post;
	}
	public int getId_criador() {
		return id_criador;
	}
	public void setId_criador(int id_criador) {
		this.id_criador = id_criador;
	}
	public int getId_avaliador() {
		return id_avaliador;
	}
	public void setId_avaliador(int id_avaliador) {
		this.id_avaliador = id_avaliador;
	}
	public int getAceite() {
		return aceite;
	}
	public void setAceite(int aceite) {
		this.aceite = aceite;
	}


}
