package controllers;

import java.util.List;

import models.*;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	static Form<Evento> eventoForm = Form.form(Evento.class);
	static Form<Pessoa> pessoaForm = Form.form(Pessoa.class);
	private static GenericDAO dao = new GenericDAOImpl();
	private static int controleInicio;

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result sistema() {
    	controleInicio = controleInicio + 1;
    	if (controleInicio == 1){
    		
    		Evento evento1;
    		Evento evento2;
    		Evento evento3;
    		Evento evento4;
    		Evento evento5;
    		Evento evento6;
    		Evento evento7;
    		Evento evento8;
    		Evento evento9;
    		Evento evento10;
    		
    		String tema1;
    		String tema2;
    		String tema3;
    		String tema4;
    		String tema5;
    		
    		
    		evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014", "Jose", "jose@gmail.com");
    		evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014", "Jose", "jose@gmail.com");
    		evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014", "Jose", "jose@gmail.com");
    		evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014", "Jose", "jose@gmail.com");
    		evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/09/2014", "Jose", "jose@gmail.com");
    		evento6 = new Evento("Banco de Dados Sequenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados sequenciais", "14/09/2014", "Jose", "jose@gmail.com");
    		evento7 = new Evento("Sites Dinamicos", "Esse evento tem o objetivo de realizar atividades com sites dinamicos", "17/08/2014", "Jose", "jose@gmail.com");
    		evento8 = new Evento("Aplicações Java", "Esse evento tem o objetivo de realizar atividades com aplicacoes java", "01/09/2014", "Jose", "jose@gmail.com");
    		evento9 = new Evento("Estruturas de dados", "Esse evento tem o objetivo de realizar atividades com estruturas de dados", "12/07/2014", "Jose", "jose@gmail.com");
    		evento10 = new Evento("Binarios", "Esse evento tem o objetivo de realizar atividades com binarios sem a utilizacao de computador", "11/09/2014", "Jose", "jose@gmail.com");
    		
    		tema1 = "Engenharia de Software";
    		tema2 = "Sistemas da Informacao";
    		tema3 = "Banco de Dados";
    		tema4 = "Computacao Desplugada";
    		tema5 = "Desenvolvimento para Web";
    		
    		// 5 eventos no tema 1
    		evento1.addTema(tema1);
    		evento4.addTema(tema1);
    		evento8.addTema(tema1);
    		evento9.addTema(tema1);
    		evento10.addTema(tema1);
    		
    		// 2 eventos no tema 2
    		evento4.addTema(tema2);
    		evento10.addTema(tema2);
    		
    		// 4 eventos no tema 3
    		evento2.addTema(tema3);		
    		evento4.addTema(tema3);
    		evento5.addTema(tema3);
    		evento6.addTema(tema3);
    		
    		// 4 eventos no tema 4
    		evento1.addTema(tema4);
    		evento3.addTema(tema4);
    		evento4.addTema(tema4);
    		evento10.addTema(tema4);
    		
    		// 3 eventos no tema 5
    		evento1.addTema(tema5);
    		evento2.addTema(tema5);
    		evento7.addTema(tema5);	
    		
    		
    		
    		getDao().persist(evento1);
    		getDao().persist(evento2);
    		getDao().persist(evento3);
    		getDao().persist(evento4);
    		getDao().persist(evento5);
    		getDao().persist(evento6);
    		getDao().persist(evento7);
    		getDao().persist(evento8);
    		getDao().persist(evento9);
    		getDao().persist(evento10);
    		getDao().flush();
    		controleInicio++;
    		
    	}
    	Sistema sistema = new Sistema();
    	List<Evento> result = getDao().findAllByClassName("Evento");
    	sistema.setEventos(result);
    	return ok(views.html.sistema.render(sistema));
    	
    }
    
    @Transactional
    public static Result cadastro() {
    	Sistema sistema = new Sistema();
    	List<Evento> result = getDao().findAllByClassName("Evento");
    	sistema.setEventos(result);
    	return ok(views.html.cadastro.render(sistema));
    	
    }
    
    @Transactional
    public static Result newEvento() {
    	// Todos o eventos do Banco de Dados
    	List<Evento> result = getDao().findAllByClassName("Evento");
    	// O formulario de evento
		Form<Evento> filledForm = eventoForm.bindFromRequest();
		
		
		Evento evento = filledForm.get();
		
		Sistema sistema = new Sistema();
    	sistema.setEventos(result);;
    	if (filledForm.hasErrors()) {
			return badRequest(views.html.cadastro.render(sistema));
		} else {
			// Persiste a meta criada
			getDao().persist(evento);
			// Espelha no Banco de Dados
			getDao().flush();
			return redirect(routes.Application.sistema());
		}
    	
    	
    }
    
    @Transactional
    public static Result participar(Long id) {
    	Evento evento = getDao().findByEntityId(Evento.class, id);
    	Sistema sistema = new Sistema();
    	List<Evento> result = getDao().findAllByClassName("Evento");
    	sistema.setEventos(result);
    	return ok(views.html.evento.render(sistema, evento));
    }
    
    @Transactional
    public static Result addParticipante(Long id) {
    	// Todos o eventos do Banco de Dados
    	List<Evento> result = getDao().findAllByClassName("Evento");
    	// Lista de Pessoa
    	List<Pessoa> pessoas = getDao().findAllByClassName("Pessoa");
    	// O formulario de pessoa
		Form<Pessoa> filledForm = pessoaForm.bindFromRequest();
		Pessoa pessoa = filledForm.get();
		Evento evento = getDao().findByEntityId(Evento.class, id);
		evento.addParticipanteNoEvento(pessoa);
		getDao().removeById(Evento.class, id);
		getDao().flush();
		getDao().persist(evento);
		Sistema sistema = new Sistema();
    	result = getDao().findAllByClassName("Evento");
    	sistema.setEventos(result);
		return ok(views.html.evento.render(sistema, evento));
		}
    	
    	
    	
    	
    

	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
    
    

}
