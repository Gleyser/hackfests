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
	
	public void EventoOrdenadosPorTema(){
		
	}
	
	public void EventoPorTema(Tema tema){
		
	}
	
	public void EventoOrdenadosPorQuantidadeDePessoas(){
		
	}
	
	public int numDeEventos(){
		return this.eventos.size();
	}
	
	public boolean contemEvento(Evento evento){
		return this.eventos.contains(evento);
	}
	

}
