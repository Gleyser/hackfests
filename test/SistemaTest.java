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
	private Evento evento6;
	private Evento evento7;
	private Evento evento8;
	private Evento evento9;
	private Evento evento10;
	private Tema tema1;
	private Tema tema2;
	private Tema tema3;
	private Tema tema4;
	private Tema tema5;
	
	
	@Before
	public void iniciar(){
		sistema = new Sistema();
		evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014");
		evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014");
		evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014");
		evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014");
		evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/09/2014");
		evento6 = new Evento("Banco de Dados Sequenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados sequenciais", "14/09/2014");
		evento7 = new Evento("Sites Dinamicos", "Esse evento tem o objetivo de realizar atividades com sites dinamicos", "17/08/2014");
		evento8 = new Evento("Aplicações Java", "Esse evento tem o objetivo de realizar atividades com aplicacoes java", "01/09/2014");
		evento9 = new Evento("Estruturas de dados", "Esse evento tem o objetivo de realizar atividades com estruturas de dados", "12/07/2014");
		evento10 = new Evento("Binarios", "Esse evento tem o objetivo de realizar atividades com binarios sem a utilizacao de computador", "11/09/2014");
		
		tema1 = new Tema("Engenharia de Software");
		tema2 = new Tema("Sistemas da Informacao");
		tema3 = new Tema("Banco de Dados");
		tema4 = new Tema("Computacao sem Computador");
		tema5 = new Tema("Desenvolvimento para Web");
		
		evento1.addTema(tema1);
		evento2.addTema(tema5);
		evento3.addTema(tema4);
		evento4.addTema(tema1);
		evento5.addTema(tema3);
		evento6.addTema(tema3);
		evento7.addTema(tema5);
		evento8.addTema(tema1);
		evento9.addTema(tema1);
		evento10.addTema(tema4);
		
		evento1.setPessoas(10);
		evento2.setPessoas(2);
		evento4.setPessoas(8);
		evento10.setPessoas(12);
		
		sistema.addEvento(evento1);
		sistema.addEvento(evento2);
		sistema.addEvento(evento3);
		sistema.addEvento(evento4);
		sistema.addEvento(evento5);
		sistema.addEvento(evento6);
		sistema.addEvento(evento7);
		sistema.addEvento(evento8);
		sistema.addEvento(evento9);
		sistema.addEvento(evento10);
		
		
	}
	
	@Test
	public void testaAdicionarEventoNoSistema(){
		Assert.assertEquals(10, sistema.numDeEventos());
		Assert.assertTrue(sistema.contemEvento(evento1));
		Assert.assertTrue(sistema.contemEvento(evento5));
		Assert.assertEquals(evento1, sistema.getEventos().get(0));
		Assert.assertEquals(evento5, sistema.getEventos().get(4));		
		
	}
	
	@Test
	public void testaRemoverEventoNoSistema(){
		Assert.assertEquals(10, sistema.numDeEventos());
		Assert.assertEquals(evento1, sistema.getEventos().get(0));
		Assert.assertEquals(evento5, sistema.getEventos().get(4));	
		sistema.removeEvento(evento1);
		Assert.assertEquals(evento2, sistema.getEventos().get(0));
		sistema.removeEvento(evento2);
		Assert.assertFalse(sistema.contemEvento(evento2));
		Assert.assertEquals(evento3, sistema.getEventos().get(0));
		Assert.assertEquals(8, sistema.numDeEventos());
		Assert.assertEquals(evento5, sistema.getEventos().get(2));
		Assert.assertFalse(sistema.removeEvento(evento2));
		
	}
	
	@Test
	public void testaEventosPorTema(){
		Assert.assertEquals(4, sistema.EventosPorTema(tema1).size());
		Assert.assertEquals(0, sistema.EventosPorTema(tema2).size());
		Assert.assertEquals(2, sistema.EventosPorTema(tema3).size());
		Assert.assertEquals(2, sistema.EventosPorTema(tema4).size());
		Assert.assertEquals(2, sistema.EventosPorTema(tema5).size());
		Assert.assertEquals(evento1, sistema.EventosPorTema(tema1).get(0));
		Assert.assertEquals(evento2, sistema.EventosPorTema(tema5).get(0));
		sistema.removeEvento(evento1);
		// Testando apos uma remocao
		Assert.assertEquals(evento4, sistema.EventosPorTema(tema1).get(0));
	}
	
	@Test
	public void testaOrdenaPorNumeroDePessoas(){
		Assert.assertEquals(evento10, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(0));
		Assert.assertEquals(evento1, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(1));
		Assert.assertEquals(evento4, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(2));
		Assert.assertEquals(evento2, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(3));
		Assert.assertEquals(evento3, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(4));
		// Adicionar mais no evento 1 para verificar se ele passar a ser o primeiro da lista
		sistema.addMaisUmaPessoaNoEvento(evento1);
		sistema.addMaisUmaPessoaNoEvento(evento1);
		sistema.addMaisUmaPessoaNoEvento(evento1);
		Assert.assertEquals(evento1, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(0));
		// Adicionar mais no evento 10 para verificar se ele volta a ser o primeiro da lista
		sistema.addMaisUmaPessoaNoEvento(evento10);
		sistema.addMaisUmaPessoaNoEvento(evento10);
		Assert.assertEquals(evento10, sistema.EventosOrdenadosPorQuantidadeDePessoas().get(0));
	}

}
