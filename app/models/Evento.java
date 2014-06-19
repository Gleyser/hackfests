package models;

import java.util.ArrayList;
import java.util.List;

public class Evento implements Comparable<Evento> {
	private String nome;
	private String descricao;
	private String data;
	private List<Tema> temas;
	private int numDePessoas;

	public Evento(){
		this.temas = new ArrayList<Tema>();
		this.numDePessoas = 0;
	}
	public Evento(String nome, String descricao, String data) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.temas = new ArrayList<Tema>();
		this.numDePessoas = 0;
		
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public int getNumDePessoas() {
		return numDePessoas;
	}
	public void setPessoas(int numDePessoas) {
		this.numDePessoas = numDePessoas;
	}	
	
	public void addParticipanteNoEvento() {
		this.numDePessoas++;
	}
	
	public void addTema(Tema tema) {
		this.temas.add(tema);
		
	}
	
	public boolean removeTema(Tema tema) {
		return this.temas.remove(tema);
		
	}
	
	@Override
	public int compareTo(Evento evento) {
		if (this.numDePessoas > evento.getNumDePessoas()) {
		      return -1;
		    }
	    if (this.numDePessoas < evento.getNumDePessoas()) {
		      return 1;
		    }
	    return 0;
		  
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numDePessoas;
		result = prime * result + ((temas == null) ? 0 : temas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numDePessoas != other.numDePessoas)
			return false;
		if (temas == null) {
			if (other.temas != null)
				return false;
		} else if (!temas.equals(other.temas))
			return false;
		return true;
	}
	
	
	

}
