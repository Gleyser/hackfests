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
	private static GenericDAO dao = new GenericDAOImpl();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result sistema() {
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

	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
    
    

}
