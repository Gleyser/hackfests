package models;


import java.util.ArrayList;
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
		
	}
	
	public int numDeEventos(){
		return this.eventos.size();
	}
	
	public boolean contemEvento(Evento evento){
		return this.eventos.contains(evento);
	}
	

}
