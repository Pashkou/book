package domain.affiliation;

import java.time.LocalDate;
import java.util.HashMap;

import domain.Affiliation;

public class UnionAffiliation implements Affiliation {
	private HashMap<LocalDate, ServiceCharge> serviceCharges = new HashMap<LocalDate, ServiceCharge>();
	private Integer memberId;
	private double dues;
	
	
	public UnionAffiliation(Integer memberId, double dues) {
		this.memberId = memberId;
		this.dues = dues;
	}

	public UnionAffiliation() {
	}

	public void addServiceCharge(LocalDate localDate, ServiceCharge ser){
		serviceCharges.put(localDate, ser);
	}
	
	public ServiceCharge getServiceCharge(LocalDate localDate){
		return serviceCharges.get(localDate);
	}
}
