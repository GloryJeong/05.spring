package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA01Create {

	public void create(EntityManager em, EntityTransaction tx) {
	tx.begin();
	tx.commit();
	}
	
}
