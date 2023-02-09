package project_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Encountor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	private String reason;
	 @ManyToOne
	 private Person person;
     @OneToMany
     private List<Branch>branchs;
	
     @Override
	public String toString() {
		return "Encountor [e_id=" + e_id + ", reason=" + reason + ", person=" + person + ", branchs=" + branchs + "]";
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
}
	


