package run;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPA02_CRUD {
	static private JPA02_CRUD instance = new JPA02_CRUD();
	JPA01Select select = new JPA01Select();
	private JPA02_CRUD() {
	}
	public static JPA02_CRUD getInstance() {
		return instance;
	}
	
	public void create(EntityManager em,EntityTransaction tx) {
		JPA01Create create =new JPA01Create();
		create.create(em,tx);
	}
	public User select(EntityManager em,Long id) {
		return select.select(em,id);
	}
	public void update(EntityManager em,User updateUser) {
		if(select.select(em,updateUser.getId() ) != null) {
			JPA01Update update = new JPA01Update();
			update.update(em, updateUser);
		}
	}
	public void delete(EntityManager em,Long id) {
		User user=null;
		if((user=select.select(em,id)) != null) {
			JPA01Delete delete = new JPA01Delete();
			delete.delete(em,user);
		}
	}
	public void insert(EntityManager em,EntityTransaction tx,User user) {
		JPA01Insert insert = new JPA01Insert();
		insert.insert(em,tx,user);
	}
	public List<User> allUser(EntityManager em){
		return select.allUser(em);
	}
	
}
