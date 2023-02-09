package project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.Branch;
import project_dto.Encountor;
import project_dto.Person;

public class EncountorDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveEncountor(int p_id,int b_id,Encountor encountor ) {
		EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Branch branch=entityManager.find(Branch.class, b_id);
		 Person person=entityManager.find(Person.class, p_id);
		 encountor.setPerson(person);
		 List<Branch>list=new ArrayList<Branch>();
		 list.add(branch);
		 encountor.setBranchs(list);
		 if(branch!=null && person!=null) {
		 entityTransaction.begin();
		 entityManager.persist(encountor);
		 entityTransaction.commit();
	}
}
    public void updateEncounter(int e_id,int b_id,String reason){
         EntityManager entityManager=getEntityManager();
	     EntityTransaction entityTransaction=entityManager.getTransaction();
	     Encountor encountor=entityManager.find(Encountor.class, e_id);
	     List<Branch>list=encountor.getBranchs();
	     Branch existingBranch=entityManager.find(Branch.class, b_id);
	     list.add(existingBranch);
	     encountor.setBranchs(list);
	     encountor.setReason(reason);
         entityTransaction.begin();
	     entityManager.merge(encountor);
	     entityTransaction.commit();
}
    public void deleteEncounter(int e_id) {
    	EntityManager eManager = getEntityManager();
    	EntityTransaction eTransaction = eManager.getTransaction();
    	Encountor encountor = eManager.find(Encountor.class, e_id);
    	if(encountor!=null) {
    	eTransaction.begin();
    	eManager.remove(encountor);
    	eTransaction.commit();
    	}
    	else
    	System.out.println("id not found");
    	}
    	public void getEncounterById(int e_id) {
    	EntityManager eManager = getEntityManager();
    	Encountor encountor = eManager.find(Encountor.class, e_id);
    	if(encountor!=null) {
    	System.out.println(encountor);
    	}
    	else
    	System.out.println("id not found");
    	}
    	public List<Encountor> getAllEncounters(){
    	EntityManager eManager = getEntityManager();
    	Query query=eManager.createQuery("select e from Encountor e");
    	List<Encountor> list=query.getResultList();
    	return list;
    	}
}
