import org.junit.Test;

import models.*;


public class SistemaTest {
	private Sistema sistema;
	private Evento evento1;
	private Evento evento2;
	private Evento evento3;
	private Evento evento4;
	private Evento evento5;
	
	@Befora
	public void iniciar(){
		Sistema sistema = new Sistema();
		Evento evento = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados acbertos", "11/9/2014");
		sistema.addEvento(evento);
	}
	
	@Test
	public void testaAdicionarEventoNoSistema(){
		sistema.addEvento(evento);
	}

}
