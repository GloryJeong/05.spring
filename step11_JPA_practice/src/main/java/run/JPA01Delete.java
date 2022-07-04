package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.User;

public class JPA01Delete {
	public void delete(EntityManager em,User user) {
		em.remove(user);
	}
}
