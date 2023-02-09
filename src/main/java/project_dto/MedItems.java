package project_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medItem_id;
	private String medItem_name;
	private double medItem_price;
	

	@ManyToOne
	private MedoOrders medoOrders;


	@Override
	public String toString() {
		return "MedItems [medItem_id=" + medItem_id + ", medItem_name=" + medItem_name + ", medItem_price="
				+ medItem_price + ", medoOrders=" + medoOrders + "]";
	}


	public int getMedItem_id() {
		return medItem_id;
	}


	public void setMedItem_id(int medItem_id) {
		this.medItem_id = medItem_id;
	}


	public String getMedItem_name() {
		return medItem_name;
	}


	public void setMedItem_name(String medItem_name) {
		this.medItem_name = medItem_name;
	}


	public double getMedItem_price() {
		return medItem_price;
	}


	public void setMedItem_price(double medItem_price) {
		this.medItem_price = medItem_price;
	}


	public MedoOrders getMedoOrders() {
		return medoOrders;
	}


	public void setMedoOrders(MedoOrders medoOrders) {
		this.medoOrders = medoOrders;
	}
	
}
