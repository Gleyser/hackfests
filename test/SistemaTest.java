import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;


public class SistemaTest {
	private Sistema sistema;
	private Evento evento1;
	private Evento evento2;
	private Evento evento3;
	private Evento evento4;
	private Evento evento5;
	
	@Before
	public void iniciar(){
		sistema = new Sistema();
		evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014");
		evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014");
		evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014");
		evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014");
		evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/9/2014");
		
	}
	
	@Test
	public void testaAdicionarEventoNoSistema(){
		sistema.addEvento(evento1);
		sistema.addEvento(evento2);
		sistema.addEvento(evento3);
		sistema.addEvento(evento4);
		sistema.addEvento(evento5);
		Assert.assertEquals(5, sistema.numDeEventos());
		Assert.assertTrue(sistema.contemEvento(evento1));
		Assert.assertTrue(sistema.contemEvento(evento5));
		Assert.assertEquals(evento1, sistema.getEventos().get(0));
		Assert.assertEquals(evento5, sistema.getEventos().get(4));		
		
	}

}
