package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPA01Update {
	public void update(EntityManager em,User updateUser) {
		User user = em.find(User.class,updateUser.getId());
		if(updateUser.getAge() != 0) {
			user.setAge(updateUser.getAge());
		}
		if(updateUser.getName() != null) {
			user.setName(updateUser.getName());
		}
	}
	
}
