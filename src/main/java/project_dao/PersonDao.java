package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import project_dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public void savePerson(Person person) {
	 EntityManager entityManager=getEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();
	 entityTransaction.begin();
	 entityManager.persist(person);
	 entityTransaction.commit();
	}
	public void updatePerson(int p_id,String name) {
     EntityManager entityManager=getEntityManager();
     EntityTransaction entityTransaction=entityManager.getTransaction();
	 Person person=entityManager.find(Person.class, p_id);
	 if(person!=null) {
	 person.setName(name);
	 entityTransaction.begin();
	 entityManager.merge(person);
	 entityTransaction.commit();
	 }
	 else
		 System.out.println("person not exists");
	}
	public void deletePerson(int p_id) {
		EntityManager entityManager=getEntityManager();
	    EntityTransaction entityTransaction=entityManager.getTransaction();
	    Person person=entityManager.find(Person.class, p_id);
	    if(person!=null) {
	    entityTransaction.begin();
	    entityManager.remove(person);
	    entityTransaction.commit();
	}
	    else
	    	System.out.println("id not exists");
	}
	public void getPerson(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
	
		if(person!=null)
			System.out.println(person);
		else
			System.out.println("id not exists");
		
	}
	public List<Person>getAllperson(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select P from Person p");
		List<Person> list1=query.getResultList();
		return list1;

	}

}
