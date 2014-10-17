package models;

import java.util.List;

import play.db.ebean.*;
import play.data.validation.Constraints.Required;

import javax.persistence.*;

@Entity
public class Contact extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String name;
	
	@Required
	public String mobphone;
	
	public String homephone;

	public static Finder<Long, Contact> find = new Finder<Long, Contact>(Long.class, Contact.class);

	// Получить все контакты
	public static List<Contact> all() {
		return find.all();
	}
	
	// CRUD
	
	// Создать контакт (C)
	public static void create(Contact contact) {
		contact.save();
	}
	
	// Получить контакт по его ID (R)
	public static Contact getById(Long Id) {
		return find.byId(Id);
	}

	// Изменить контакт (U)
	public static void update(Contact contact) {
		contact.update();
	}

	// Удалить контакт (D)
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}