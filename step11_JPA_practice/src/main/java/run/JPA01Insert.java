package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.User;

public class JPA01Insert {

	public void insert(EntityManager em,EntityTransaction tx,User user) {
	tx.begin();
	em.persist(user);
	tx.commit();		
}
	
}
