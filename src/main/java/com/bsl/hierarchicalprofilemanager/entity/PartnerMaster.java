package com.bsl.hierarchicalprofilemanager.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "partner_master")
public class PartnerMaster implements Serializable {

	private static final long serialVersionUID = 9195176796858710042L;

	@Id
	@Column(name = "partner_id")
	private String partnerId;

	@Column(unique = true, name = "partner_name")
	private String partnerName;

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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientMaster")
	private Set<ClientMaster> clientMaster;

}
