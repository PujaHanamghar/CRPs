package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rolepermission")
public class RolePermissionsMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer perId;
//	private String role;
	private String moduleName;
	private Boolean canView;
	private Boolean canEdit;
	private Boolean canDelete;
	
	@OneToOne
	@JoinColumn(name = "roleId")
	private RoleMaster role;

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Boolean getCanView() {
		return canView;
	}

	public void setCanView(Boolean canView) {
		this.canView = canView;
	}

	public Boolean getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	public RoleMaster getRole() {
		return role;
	}

	public void setRole(RoleMaster role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RolePermissionsMaster [perId=" + perId + ", moduleName=" + moduleName + ", canView=" + canView
				+ ", canEdit=" + canEdit + ", canDelete=" + canDelete + ", role=" + role + "]";
	}

	public RolePermissionsMaster(Integer perId, String moduleName, Boolean canView, Boolean canEdit, Boolean canDelete,
			RoleMaster role) {
		super();
		this.perId = perId;
		this.moduleName = moduleName;
		this.canView = canView;
		this.canEdit = canEdit;
		this.canDelete = canDelete;
		this.role = role;
	}

	public RolePermissionsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
