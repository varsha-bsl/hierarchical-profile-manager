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
@Table(name = "agent_master")
public class AgentMaster implements Serializable {

	private static final long serialVersionUID = 9195176796858710042L;

	@Id
	@Column(name = "agent_id")
	private String agentId;

	@Column(unique = true, name = "agent_name")
	private String agentName;

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
	@JoinColumn(name = "client_master", referencedColumnName = "client_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ClientMaster clientMaster;

}
