package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.Address;
import project_dto.Branch;

public class AddressDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveAddress(int b_id,Address address) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, b_id);
		address.setBranch(branch);
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
	}
	public void updateAddress(int a_id,String address) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, a_id);
		if(address1!=null) {
		address1.setAddress(address);
		entityTransaction.begin();
        entityManager.merge(address1);
		entityTransaction.commit();
		}
		else
			System.out.println("id not found");
		
	}
	public void deleteAddress(int a_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, a_id);
		if(address1!=null) {
		entityTransaction.begin();
	    entityManager.remove(address1);
		entityTransaction.commit();
		}
			else
			System.out.println("id not found");
}
	  public void getAddress(int a_id) {
		  EntityManager entityManager=getEntityManager();
		  EntityTransaction entityTransaction=entityManager.getTransaction(); 
	      Address address = entityManager.find(Address.class, a_id);
          if (address != null) {
          System.out.println(address);
          } 
          else 
          System.out.println("Id is not found");
}

       public List<Address> getAllAddress() {
    	  EntityManager entityManager=getEntityManager();
 		  EntityTransaction entityTransaction=entityManager.getTransaction(); 
          Query query = entityManager.createQuery("select a from Address a");
          List<Address> list1 = query.getResultList();
          return list1;
       }


		
}


