package in.ineuron.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 
 * @author Sowmya Peddi
 * Timestamping
 * =============
 * It allows us to keep track of Object. when the object is saved(record inserted) and when the object is lastly
   updated.
   
eg: Here we are assuming bankAccount for our example 
    To keep track of when the bank account opened and lastly modified we make use of Timestamping annotations of hibernate.
    To do this we use annotations like @CreationTimeStamp,@UpdateTimeStamp
    Using @creationTimestamp annotation: The creation time remains same as when object saved, and won't change even after multiple modification.
    @UpdateTImestamp : This annotation helps us to update the modification time whenever user modifies the object this value changes for every modification.

 *
 */

@Entity
public class BankAccount{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AccNo;
	
	@Column(length = 20)
	private String holderName;
	
	private Double balance;
	
	private String type;
	
	@CreationTimestamp
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateTime;
	
	@Version
	private Integer version;
	public Long getAccNo() {
		return AccNo;
	}
	public void setAccNo(Long accNo) {
		AccNo = accNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "BankAccount [AccNo=" + AccNo + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdateTime=" + lastUpdateTime + ", version=" + version + "]";
	}
	
}
