package controllers;

import java.util.List;

import models.*;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
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

	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
    
    

}
