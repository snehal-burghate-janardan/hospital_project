package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.MedItems;
import project_dto.MedoOrders;



public class MedItemsDao {
	


	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveMedItems(int order_id,MedItems medItems) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedoOrders medoOrders=entityManager.find(MedoOrders.class, order_id);
		medItems.setMedoOrders(medoOrders);
		entityTransaction.begin();
		entityManager.persist(medItems);
		entityTransaction.commit();
	}
	public void updateMedItems(int medItem_id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedItems medItems = entityManager.find(MedItems.class, medItem_id);
		if (medItems != null) {
			medItems.setMedItem_name(name);
			entityTransaction.begin();
			entityManager.merge(medItems);
			entityTransaction.commit();

		}
		else
		System.out.println("id not found");
}

		public void deleteMedItems(int medItem_id ) {
	    EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedItems medItems = entityManager.find(MedItems.class, medItem_id);
		if (medItems != null) {
            entityTransaction.begin();
			entityManager.remove(medItems);
			entityTransaction.commit();

		}
		else
		System.out.println("id not found");

}

		public void getMedItems(int medItem_id ) {
	    EntityManager entityManager=getEntityManager();
     	EntityTransaction entityTransaction=entityManager.getTransaction();
		MedItems medItems = entityManager.find(MedItems.class, medItem_id);
		System.out.println(medItems);

		}
		public List<MedItems> getALlMedItems(){
		EntityManager eManager = getEntityManager();
		Query query=eManager.createQuery("select m from MedItems m");
		List<MedItems> list=query.getResultList();
		return list;
		}

	}




