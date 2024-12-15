package com.pcms.UserPlans.Model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserPlans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userPlanId;
	@OneToOne
	@JoinColumn(name="planId", referencedColumnName = "planId")
	private Plans planId;
	private int userId;
	private String planName;
	private String location;
	private double price;
	private String requestedBy;
	private Date requiredFrom;
	private Date requiredUpto;
	private boolean autoTerminated;
	private boolean isAlertRequired;
	private String status;
	private String rejectionComment;
	public int getUserPlanId() {
		return userPlanId;
	}
	public void setUserPlanId(int userPlanId) {
		this.userPlanId = userPlanId;
	}
	public Plans getPlanId() {
		return planId;
	}
	public void setPlanId(Plans planId) {
		this.planId = planId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Date getRequiredFrom() {
		return requiredFrom;
	}
	public void setRequiredFrom(Date requiredFrom) {
		this.requiredFrom = requiredFrom;
	}
	public Date getRequiredUpto() {
		return requiredUpto;
	}
	public void setRequiredUpto(Date requiredUpto) {
		this.requiredUpto = requiredUpto;
	}
	public boolean isAutoTerminated() {
		return autoTerminated;
	}
	public void setAutoTerminated(boolean autoTerminated) {
		this.autoTerminated = autoTerminated;
	}
	public boolean isAlertRequired() {
		return isAlertRequired;
	}
	public void setAlertRequired(boolean isAlertRequired) {
		this.isAlertRequired = isAlertRequired;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRejectionComment() {
		return rejectionComment;
	}
	public void setRejectionComment(String rejectionComment) {
		this.rejectionComment = rejectionComment;
	}
	public UserPlans(int userPlanId, Plans planId, int userId, String planName, String location, double price,
			String requestedBy, Date requiredFrom, Date requiredUpto, boolean autoTerminated, boolean isAlertRequired,
			String status, String rejectionComment) {
		super();
		this.userPlanId = userPlanId;
		this.planId = planId;
		this.userId = userId;
		this.planName = planName;
		this.location = location;
		this.price = price;
		this.requestedBy = requestedBy;
		this.requiredFrom = requiredFrom;
		this.requiredUpto = requiredUpto;
		this.autoTerminated = autoTerminated;
		this.isAlertRequired = isAlertRequired;
		this.status = status;
		this.rejectionComment = rejectionComment;
	}
	public UserPlans() {
		super();
	}
	
	
	
	
	

}
