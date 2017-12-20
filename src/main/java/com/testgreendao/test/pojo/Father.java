package com.testgreendao.test.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Father entity. @author MyEclipse Persistence Tools
 */

public class Father implements java.io.Serializable {

	// Fields

	private Integer fateherId;
	private String fatherName;
	private Integer fatherAge;
	private String fatherPic;
	private Set sons = new HashSet(0);

	// Constructors

	/** default constructor */
	public Father() {
	}

	/** minimal constructor */
	public Father(String fatherName, Integer fatherAge, String fatherPic) {
		this.fatherName = fatherName;
		this.fatherAge = fatherAge;
		this.fatherPic = fatherPic;
	}

	/** full constructor */
	public Father(String fatherName, Integer fatherAge, String fatherPic, Set sons) {
		this.fatherName = fatherName;
		this.fatherAge = fatherAge;
		this.fatherPic = fatherPic;
		this.sons = sons;
	}

	// Property accessors

	public Integer getFateherId() {
		return this.fateherId;
	}

	public void setFateherId(Integer fateherId) {
		this.fateherId = fateherId;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getFatherAge() {
		return this.fatherAge;
	}

	public void setFatherAge(Integer fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getFatherPic() {
		return this.fatherPic;
	}

	public void setFatherPic(String fatherPic) {
		this.fatherPic = fatherPic;
	}

	public Set getSons() {
		return this.sons;
	}

	public void setSons(Set sons) {
		this.sons = sons;
	}

	@Override
	public String toString() {
		return "Father [fateherId=" + fateherId + ", fatherName=" + fatherName + ", fatherAge=" + fatherAge
				+ ", fatherPic=" + fatherPic + ", sons=" + sons + "]";
	}




	
	

}