package models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
	private List<Evento> eventos;
	
	public Sistema(){
		this.eventos = new ArrayList<Evento>();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void addEvento(Evento evento){
		this.eventos.add(evento);
	}
	
	public boolean removeEvento(Evento evento){
		return this.eventos.remove(evento);
	}
	
	public List<Evento> EventosPorTema(Tema tema){
		List<Evento> retorno = new ArrayList<Evento>();
		for (Evento evento: this.eventos){
			if (evento.getTemas().contains(tema)){
				retorno.add(evento);
			}
		}
		return retorno;
	}
	
	public List<Evento> EventosOrdenadosPorQuantidadeDePessoas(){
		List<Evento> copiaDeEventos = this.eventos;
		Collections.sort(copiaDeEventos);
		return copiaDeEventos;
	}
	
	public int numDeEventos(){
		return this.eventos.size();
	}
	
	public boolean contemEvento(Evento evento){
		return this.eventos.contains(evento);
	}
	
	public void addMaisUmaPessoaNoEvento(Evento evento){
		if (this.eventos.contains(evento)){
			for (Evento evento1 : this.eventos){
				if (evento1.equals(evento)){
					Evento aux = evento1;
					aux.addParticipanteNoEvento();
					this.eventos.remove(evento1);
					this.eventos.add(aux);
					return;
				}
			}
		}
	}
	

}
