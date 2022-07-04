package jpa.basic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// insert
//		Member member1 = new Member();
//		member1.setId("id1");
//		member1.setAge(27);
//		member1.setUserName("jpa1");
//		em.persist(member1);
		
//		Member member2 = new Member();
//		member2.setId("id2");
//		member2.setAge(28);
//		member2.setUserName("jpa2");
//		em.persist(member2);
		
		// select
//		Member member1 = em.find(Member.class, "id1");
//		System.out.println(member1);
//		
//		Member member01 = em.find(Member.class, "id1");
//		System.out.println(member01);
//		System.out.println(member01 == member1); //true?
//		
		// JPQL : 엔티티 객체를 대상으로 검색하는 객체 지향 쿼리
//		List<Member> allMembers = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println(allMembers);
		
		// 반환타입 명확할 경우 TypedQuery, 불명확할 경우 Query
//		TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class);
//		List<Member> allMembers = typedQuery.getResultList();
//		System.out.println(allMembers);
		 //결과로 반환받는 데이터 객체가 정확히 하나일 때 사용 - 없으면 Exception 발생
//		em.createQuery("select m from Member m", Member.class).getSingleResult(); 
		
		// update : 변경 감지 - 엔터티 조회 및 데이터만 변경하면 자동으로 업데이트 실행됨
		// 모든 멤버변수(필드) set, 업데이트 대상에서 지정되지 않은 멤버변수 데이터는 기존 유지
		// 동작 원리
		/* 
		 * flush() : 내부 쿼리 저장소에 있는 SQL이 DB에 동기화 
		 * 1. flush() <- tx.commit() 자동 호출
		 * 2. 엔티티 스냅샷과 변경된 엔티티를 비교
		 * 3. 변경된 엔티티가 존재하면 update 쿼리를 생성
		 * 4. 쓰기 지연 SQL 저장소에 저장
		 * 5. DB에 전송 -> DB tx.commit();
		 * */
		
		// 영속성 컨텍스트를 초기화 하는 clear가 먼저 실행된다면?? - update 반영 x (영속성에서 준영속이 되었기 때문)
//		em.clear();
//		em.merge(member1);
//		member1.setAge(49);
		
		
		// delete
//		em.remove(member1);
		
		tx.commit();
	}

}
