package com.bsl.hierarchicalprofilemanager.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "admin_master")
public class AdminMaster implements Serializable {

	private static final long serialVersionUID = 9195176796858710042L;

	@Id
	@Column(name = "admin_id")
	private String adminId;

	@Column(unique = true, name = "admin_name")
	private String adminName;

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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partnerMaster")
	private Set<PartnerMaster> partnerMaster;

	@JsonIgnore
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientMaster")
	private Set<ClientMaster> clientMaster;

}
