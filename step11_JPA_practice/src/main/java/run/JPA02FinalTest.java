package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPA02FinalTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_CRUD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		JPA02_CRUD service = JPA02_CRUD.getInstance();
		
		try {
			service.create(em, tx);
			service.insert(em, tx, new User(1L,"spring",2));
			service.insert(em, tx, new User(2L,"Java",22));
			service.insert(em, tx, new User(3L,"backEnd",33));
			tx.begin();
			System.out.println(service.allUser(em));
			service.update(em, new User(3L,"test",25));
			System.out.println(service.select(em,3L));
			service.delete(em, 3L);
			System.out.println(service.allUser(em));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}
