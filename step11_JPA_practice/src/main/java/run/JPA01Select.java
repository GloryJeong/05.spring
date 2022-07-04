package run;

import java.util.List;

import javax.persistence.EntityManager;

import entity.User;

public class JPA01Select {
	
	public List<User> allUser(EntityManager em){
		return em.createQuery("select u from User u",User.class).getResultList();
	}
	
	public User select(EntityManager em,Long id) {
		return em.find(User.class,id);
	}
}
