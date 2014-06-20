package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;



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
		
	@ElementCollection
	private List<String> temas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn (name = "pessoas") 
	private List<Pessoa> PessoasQueConfirmaram;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Evento(){
		this.temas = new ArrayList<String>();
		this.PessoasQueConfirmaram = new ArrayList<Pessoa>();;
	}
	public Evento(String nome, String descricao, String data, String nomeAdmin, String emailAdmin) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.temas = new ArrayList<String>();
		this.nomeAdmin = nomeAdmin;
		this.emailAdmin = emailAdmin;
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
	public List<String> getTemas() {
		return temas;
	}
	public void setTemas(List<String> temas) {
		this.temas = temas;
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
	
	public void addTema(String tema) {
		this.temas.add(tema);
		
	}
	
	public boolean removeTema(String tema) {
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
	
	
	
	
	

}
