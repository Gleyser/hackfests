package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity(name = "Evento")
public class Evento implements Comparable<Evento> {
	
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "EVENTO_SEQUENCE", sequenceName = "EVENTO_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@Column	
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private String data;
	
	@Column
	private String nomeAdmin;
	
	@Column
	private String emailAdmin;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Tema> temas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Pessoa> PessoasQueConfirmaram;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Evento(){
		this.temas = new ArrayList<Tema>();
		this.PessoasQueConfirmaram = new ArrayList<Pessoa>();;
	}
	public Evento(String nome, String descricao, String data, String nomeAdmin, String emailAdmin) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.nomeAdmin = nomeAdmin;
		this.emailAdmin = emailAdmin;
		this.temas = new ArrayList<Tema>();
		this.PessoasQueConfirmaram = new ArrayList<Pessoa>();
		
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
		
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	public List<Pessoa> getNumDePessoasQueConfirmaram() {
		return PessoasQueConfirmaram;
	}
	public void setNumDePessoasQueConfirmaram(
			List<Pessoa> numDePessoasQueConfirmaram) {
		this.PessoasQueConfirmaram = numDePessoasQueConfirmaram;
	}
	public void addParticipanteNoEvento(Pessoa pessoa) {
		if (!this.PessoasQueConfirmaram.contains(pessoa)){
		this.PessoasQueConfirmaram.add(pessoa);
		}
	}
	
	public void removerParticipanteNoEvento(Pessoa pessoa) {
		if (this.PessoasQueConfirmaram.contains(pessoa)){
			this.PessoasQueConfirmaram.remove(pessoa);
		}
		
	}
	
	public int numDePessoasQueConfirmaram(){
		return this.PessoasQueConfirmaram.size();
	}
	
	public void addTema(Tema tema) {
		this.temas.add(tema);
		
	}
	
	public boolean removeTema(Tema tema) {
		return this.temas.remove(tema);
		
	}
	
	@Override
	public int compareTo(Evento evento) {
		if (this.PessoasQueConfirmaram.size() > evento.numDePessoasQueConfirmaram()) {
		      return -1;
		    }
	    if (this.PessoasQueConfirmaram.size() < evento.numDePessoasQueConfirmaram()) {
		      return 1;
		    }
	    return 0;
		  
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Pessoa> getPessoasQueConfirmaram() {
		return PessoasQueConfirmaram;
	}
	public void setPessoasQueConfirmaram(List<Pessoa> pessoasQueConfirmaram) {
		PessoasQueConfirmaram = pessoasQueConfirmaram;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((PessoasQueConfirmaram == null) ? 0 : PessoasQueConfirmaram
						.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((emailAdmin == null) ? 0 : emailAdmin.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((nomeAdmin == null) ? 0 : nomeAdmin.hashCode());
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
		if (PessoasQueConfirmaram == null) {
			if (other.PessoasQueConfirmaram != null)
				return false;
		} else if (!PessoasQueConfirmaram.equals(other.PessoasQueConfirmaram))
			return false;
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
		if (emailAdmin == null) {
			if (other.emailAdmin != null)
				return false;
		} else if (!emailAdmin.equals(other.emailAdmin))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeAdmin == null) {
			if (other.nomeAdmin != null)
				return false;
		} else if (!nomeAdmin.equals(other.nomeAdmin))
			return false;
		if (temas == null) {
			if (other.temas != null)
				return false;
		} else if (!temas.equals(other.temas))
			return false;
		return true;
	}
	

}
