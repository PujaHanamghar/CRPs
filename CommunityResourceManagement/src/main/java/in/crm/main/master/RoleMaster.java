package in.crm.main.master;

//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	private String roleName;
	private String roledesc;
	private Boolean roleCanAdd;
	private Boolean roleCanView;
	private Boolean roleCanEdit;
	private Boolean roleCanDelete;
	
//	@OneToMany(mappedBy = "role")  //one role can have many users
//    private List<UserMaster> user;
//	
//	@OneToMany(mappedBy = "role")    //one role can have many permissions
//    private List<RolePermissionsMaster> rolePermission;	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	public Boolean getRoleCanAdd() {
		return roleCanAdd;
	}
	public void setRoleCanAdd(Boolean roleCanAdd) {
		this.roleCanAdd = roleCanAdd;
	}
	public Boolean getRoleCanView() {
		return roleCanView;
	}
	public void setRoleCanView(Boolean roleCanView) {
		this.roleCanView = roleCanView;
	}
	public Boolean getRoleCanEdit() {
		return roleCanEdit;
	}
	public void setRoleCanEdit(Boolean roleCanEdit) {
		this.roleCanEdit = roleCanEdit;
	}
	public Boolean getRoleCanDelete() {
		return roleCanDelete;
	}
	public void setRoleCanDelete(Boolean roleCanDelete) {
		this.roleCanDelete = roleCanDelete;
	}
	@Override
	public String toString() {
		return "RoleMaster [roleId=" + roleId + ", roleName=" + roleName + ", roledesc=" + roledesc + ", roleCanAdd="
				+ roleCanAdd + ", roleCanView=" + roleCanView + ", roleCanEdit=" + roleCanEdit + ", roleCanDelete="
				+ roleCanDelete + "]";
	}
	public RoleMaster(Integer roleId, String roleName, String roledesc, Boolean roleCanAdd, Boolean roleCanView,
			Boolean roleCanEdit, Boolean roleCanDelete) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roledesc = roledesc;
		this.roleCanAdd = roleCanAdd;
		this.roleCanView = roleCanView;
		this.roleCanEdit = roleCanEdit;
		this.roleCanDelete = roleCanDelete;
	}
	public RoleMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
}
