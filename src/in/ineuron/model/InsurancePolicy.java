package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * 
 * @author Sowmya Peddi
 * 
 * Its temporary memory that holds the data for temporarily.
   Cache at client side will hold server data and uses it across the multiple same requests to reduce the network calls between client(Java Application) and server(DB).
   Hibernate supports 2 levels of caching 
  1. First Level cache (L1 Cache/session Cache/default) 
    -----------------------------------------------------
   Is a session cache that stores copies of entities retrieved from the DB. Enabled by default.
   Improves performance by reducing number of database Queries to be executed.
   Associated to specific session Object, scope: session scope, session closed = cache gone, 
   eg: live Cricket Score, trading, weather report.
   session.save(obj), session.saveOrUpdate(obj),
   session.delete(obj) methods keep the Obj in l1 cache until tx.commit() is called.
   session.get(), session.load() will get the object and keep it in L1 cache and same object will be used across multiple session.get() method calls wit same entity obj id.    
  
   session.evict() : Remove requested Object from L1-Cache (manually removing object).
   session.clear() : Remove all objects from L1-cache.
   In l1-cache, duplicate objects won't be permitted.
 *
 */
@Entity
public class InsurancePolicy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940931891329205809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyNo;
	
	@Column(length = 20)
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	public Long getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Long policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public InsurancePolicy() {
	}
	
	@Override
	public String toString() {
		return "InsurancePolicy [policyNo=" + policyNo + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
	
}
