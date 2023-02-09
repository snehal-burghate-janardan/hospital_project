package project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_dto.Branch;
import project_dto.Hospital;
import project_dto.Person;

public class BranchDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveBranch(int h_id,Branch branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, h_id);
		branch.setHospital(hospital);
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
	}
	public void updateBranch(int b_id,String branchname) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, b_id);
		if(branch!=null) {
		branch.setBranchname(branchname);
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		}
		else
			System.out.println("id not found");
	}
	public void deleteBranch(int b_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, b_id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			
		}
		else
			System.out.println("id not found");
		}
	public void getBranch(int b_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, b_id);
		
		if(branch!=null)
			System.out.println(branch);
		else
			System.out.println("id not exists");
	}
	public List<Branch>getAllBranchs(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select b from Branch b");
		List<Branch> list1=query.getResultList();
		return list1;
}
}
