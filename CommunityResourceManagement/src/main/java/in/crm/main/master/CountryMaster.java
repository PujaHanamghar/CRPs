package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class CountryMaster {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer countryId;
	private String countryName;
	private String countryDesc;
	public Integer getCountryId() {
		return countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryDesc() {
		return countryDesc;
	}
	public void setCountryDesc(String countryDesc) {
		this.countryDesc = countryDesc;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "CountryMaster [countryId=" + countryId + ", countryName=" + countryName + ", countryDesc=" + countryDesc
				+ "]";
	}
	public CountryMaster(Integer countryId, String countryName, String countryDesc) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryDesc = countryDesc;
	}
	public CountryMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
