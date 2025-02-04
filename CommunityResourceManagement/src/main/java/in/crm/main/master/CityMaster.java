package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="city")
public class CityMaster {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer cityId;
	private String  cityName;
	private String cityDesc;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityDesc() {
		return cityDesc;
	}
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}
	public CityMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityMaster(Integer cityId, String cityName, String cityDesc) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityDesc = cityDesc;
	}
	@Override
	public String toString() {
		return "CityMaster [cityId=" + cityId + ", cityName=" + cityName + ", cityDesc=" + cityDesc + "]";
	}
	
	

}
