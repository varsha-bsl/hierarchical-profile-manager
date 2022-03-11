package com.bsl.hierarchicalprofilemanager.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "client_master")
public class ClientMaster implements Serializable {

	private static final long serialVersionUID = 9195176796858710042L;

	@Id
	@Column(name = "client_id")
	private String clientId;

	@Column(unique = true, name = "client_name")
	private String clientName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "status")
	private String status;

	@Column(name = "role", columnDefinition = "TEXT")
	private String role;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_on")
	private Timestamp updatedOn;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@JsonIgnore
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_master", referencedColumnName = "admin_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AdminMaster adminMaster;

	@JsonIgnore
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_master", referencedColumnName = "partner_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PartnerMaster partnerMaster;

}
