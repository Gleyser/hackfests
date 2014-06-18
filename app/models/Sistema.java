package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema {
	private String nome;
	private String descricao;
	private Date data;
	private List<Tema> temas;
	private List<Pessoa> pessoas;
	
	public Sistema(){
		this.temas = new ArrayList<Tema>();
		this.pessoas = new ArrayList<Pessoa>();
	}
	public Sistema(String nome, String descricao, String data) {
		this.nome = nome;
		this.descricao = descricao;
		this.temas = new ArrayList<Tema>();
		this.pessoas = new ArrayList<Pessoa>();
		try {
			DateFormat formatador1 = new SimpleDateFormat("dd/MM/yyyy");
			this.data = formatador1.parse(data);
		}	catch (ParseException e) {
            e.printStackTrace();
		} 	catch (Exception e) {
            e.printStackTrace();
			}		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	

}
