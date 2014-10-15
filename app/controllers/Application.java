package controllers;

import play.data.*;
import play.mvc.*;

import models.*;

public class Application extends Controller {

	static Form<Contact> contactForm = Form.form(Contact.class);

	public static Result index() {
		return redirect(routes.Application.contacts());
	}

	public static Result contacts() {
		return ok(views.html.index.render(Contact.all(), contactForm));
	}

	public static Result newContact() {
		Form<Contact> filledForm = contactForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Contact.all(), filledForm));
		} else {
			Contact.create(filledForm.get());
			return redirect(routes.Application.contacts());
		}
	}

	public static Result deleteContact(Long id) {
		Contact.delete(id);
		return redirect(routes.Application.contacts());
	}
}