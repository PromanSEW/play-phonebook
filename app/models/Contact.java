package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

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
	
	@Required
	public String homephone;

	public static Finder<Long, Contact> find = new Finder(Long.class, Contact.class);

	public static List<Contact> all() {
		return find.all();
	}
	
	public static Contact getById(Long Id) {
		return find.byId(Id);
	}

	public static void create(Contact contact) {
		contact.save();
	}
	
	public static void update(Contact contact) {
		contact.update();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}