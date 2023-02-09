package project_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MedoOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String doctorname;
	
	@ManyToOne
	private Encountor encountor;

	@Override
	public String toString() {
		return "MedoOrders [order_id=" + order_id + ", doctorname=" + doctorname + ", encountor=" + encountor + "]";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public Encountor getEncountor() {
		return encountor;
	}

	public void setEncountor(Encountor encountor) {
		this.encountor = encountor;
	}
}
	
	
	


