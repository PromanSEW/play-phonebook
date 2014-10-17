package controllers;

import play.data.*;
import play.mvc.*;

import models.*;
import views.html.*;

public class Application extends Controller {

	static Form<Contact> contactForm = Form.form(Contact.class);

	// Главная
	public static Result index() {
		return redirect(routes.Application.contacts());
	}

	// Контакты
	public static Result contacts() {
		return ok(index.render(Contact.all(), contactForm));
	}

	// Новый контакт
	public static Result newContact() {
		Form<Contact> filledForm = contactForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(index.render(Contact.all(), filledForm));
		} else {
			Contact.create(filledForm.get());
			return redirect(routes.Application.contacts());
		}
	}
	
	// Редактировать контакт
	public static Result editContact() {
		Form<Contact> filledForm = contactForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(edit.render(filledForm.get(), filledForm));
		} else {
			Contact.update(filledForm.get());
			return redirect(routes.Application.contacts());
		}
	}
	
	// Открыть контакт
	public static Result openContact(Long id) {
		return ok(edit.render(Contact.getById(id), contactForm));
	}

	// Удалить контакт
	public static Result deleteContact(Long id) {
		Contact.delete(id);
		return redirect(routes.Application.contacts());
	}
}