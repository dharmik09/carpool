package com.munifec.carpool.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ids")
public class DBIDCounter {
	
	@PrimaryKey
	@Column("idname")
	private String idName;
	@Column("nextid")
	private Long nextId;
	
	public DBIDCounter() {
	}
	
	public DBIDCounter(String idName, Long nextId){
		this.idName = idName;
		this.nextId = nextId;
	}
	
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public Long getNextId() {
		return nextId;
	}
	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}
	
}
