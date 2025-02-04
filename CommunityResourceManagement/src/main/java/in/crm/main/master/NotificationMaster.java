package in.crm.main.master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notification")

public class NotificationMaster {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer notificationId;
	private String message;                                                                       
    private String deliveryMethod;
    private String status;
	
    public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NotificationMaster [notificationId=" + notificationId + ", message=" + message + ", deliveryMethod="
				+ deliveryMethod + ", status=" + status + "]";
	}
	public NotificationMaster(Integer notificationId, String message, String deliveryMethod, String status) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.deliveryMethod = deliveryMethod;
		this.status = status;
	}
	public NotificationMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	      


}
