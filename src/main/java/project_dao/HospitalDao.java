package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.Hospital;
import project_dto.Person;

public class HospitalDao {


	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveHospital(Hospital hospital) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
	public void updateHospital(int h_id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, h_id);
		if(hospital!=null) {
		hospital.setHospname(name);
		entityTransaction.begin();
		entityManager.merge(hospital);
		entityTransaction.commit();
		}
		else
			System.out.println("id not exist");
	}
	public void deleteHospital(int h_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, h_id);
		if(hospital!=null) {
		entityTransaction.begin();
		entityManager.remove(hospital);
		entityTransaction.commit();
		}
		else
			System.out.println("id not found");
	}
	public void getHospital(int h_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, h_id);
	
		if(hospital!=null)
			System.out.println(hospital);
		else
			System.out.println("id not exists");
	}
	public List<Hospital>getAllHospital(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select H from Hospital H");
		return query.getResultList();
	}
	
}

