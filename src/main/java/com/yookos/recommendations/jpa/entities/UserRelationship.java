package com.yookos.recommendations.jpa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRelationship {
	@Id
	private long relationshipid;
	
	private long userid;
	private long relateduserid;
	private long creationdate;
	/**
	 * @return the relationshipid
	 */
	public long getRelationshipid() {
		return relationshipid;
	}
	/**
	 * @param relationshipid the relationshipid to set
	 */
	public void setRelationshipid(long relationshipid) {
		this.relationshipid = relationshipid;
	}
	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}
	/**
	 * @return the relateduserid
	 */
	public long getRelateduserid() {
		return relateduserid;
	}
	/**
	 * @param relateduserid the relateduserid to set
	 */
	public void setRelateduserid(long relateduserid) {
		this.relateduserid = relateduserid;
	}
	/**
	 * @return the creationdate
	 */
	public long getCreationdate() {
		return creationdate;
	}
	/**
	 * @param creationdate the creationdate to set
	 */
	public void setCreationdate(long creationdate) {
		this.creationdate = creationdate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRelationship [relationshipid=" + relationshipid
				+ ", userid=" + userid + ", relateduserid=" + relateduserid
				+ ", creationdate=" + new Date(getCreationdate()) + "]";
	}
}
