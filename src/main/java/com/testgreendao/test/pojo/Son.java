package com.testgreendao.test.pojo;

/**
 * Son entity. @author MyEclipse Persistence Tools
 */

public class Son implements java.io.Serializable {

	// Fields

	private Integer sonId;
	private Father father;
	private String sonName;
	private Integer sonAge;
	private String sonPic;

	// Constructors

	/** default constructor */
	public Son() {
	}

	/** minimal constructor */
	public Son(Father father, String sonName, String sonPic) {
		this.father = father;
		this.sonName = sonName;
		this.sonPic = sonPic;
	}

	/** full constructor */
	public Son(Father father, String sonName, Integer sonAge, String sonPic) {
		this.father = father;
		this.sonName = sonName;
		this.sonAge = sonAge;
		this.sonPic = sonPic;
	}

	// Property accessors

	public Integer getSonId() {
		return this.sonId;
	}

	public void setSonId(Integer sonId) {
		this.sonId = sonId;
	}

	public Father getFather() {
		return this.father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public String getSonName() {
		return this.sonName;
	}

	public void setSonName(String sonName) {
		this.sonName = sonName;
	}

	public Integer getSonAge() {
		return this.sonAge;
	}

	public void setSonAge(Integer sonAge) {
		this.sonAge = sonAge;
	}

	public String getSonPic() {
		return this.sonPic;
	}

	public void setSonPic(String sonPic) {
		this.sonPic = sonPic;
	}

}