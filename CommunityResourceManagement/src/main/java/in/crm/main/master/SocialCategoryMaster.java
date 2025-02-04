package in.crm.main.master;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="socialCategory")
public class SocialCategoryMaster {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer socialCategoryId;
	private String socialCategoryName; 
	private String socialCategoryDesc;
	public Integer getSocialCategoryId() {
		return socialCategoryId;
	}
	public void setSocialCategoryId(Integer socialCategoryId) {
		this.socialCategoryId = socialCategoryId;
	}
	public String getSocialCategoryName() {
		return socialCategoryName;
	}
	public void setSocialCategoryName(String socialCategoryName) {
		this.socialCategoryName = socialCategoryName;
	}
	public String getSocialCategoryDesc() {
		return socialCategoryDesc;
	}
	public void setSocialCategoryDesc(String socialCategoryDesc) {
		this.socialCategoryDesc = socialCategoryDesc;
	}
	@Override
	public String toString() {
		return "SocialCategoryMaster [socialCategoryId=" + socialCategoryId + ", socialCategoryName="
				+ socialCategoryName + ", socialCategoryDesc=" + socialCategoryDesc + "]";
	}
	public SocialCategoryMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
