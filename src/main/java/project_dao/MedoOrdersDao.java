package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.Encountor;
import project_dto.MedoOrders;



public class MedoOrdersDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveMedoOrder( int e_id,MedoOrders medoOrders) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encountor encountor=entityManager.find(Encountor.class, e_id);
		medoOrders.setEncountor(encountor);
		entityTransaction.begin();
		entityManager.persist(medoOrders);
		entityTransaction.commit();
	}
	public void updateMedoOrder(int order_id,String doctorname ) { 
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	     	MedoOrders medoOrders=entityManager.find(MedoOrders.class, order_id);
	     	if(medoOrders!=null) {
			medoOrders.setDoctorname(doctorname);
			entityTransaction.begin();
            entityManager.merge(medoOrders);
            entityTransaction.commit();
	}
			else
			System.out.println("id not found");
}

			public void deleteMedOrder(int order_id) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			MedoOrders medoOrders=entityManager.find(MedoOrders.class, order_id);
			if(medoOrders!=null) {
				entityTransaction.begin();
	            entityManager.remove(medoOrders);
	            entityTransaction.commit();
     }
			else
			System.out.println("id not found");
}

			public void getMedOrder(int order_id) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			MedoOrders medoOrders=entityManager.find(MedoOrders.class, order_id);
			System.out.println(medoOrders);
			}
			public List<MedoOrders>getAllMedorders(){
			EntityManager eManager = getEntityManager();
			Query query= eManager.createQuery("select m from MedoOrders m");
			List<MedoOrders> list=query.getResultList();
			 return list;


			}

		
	}


