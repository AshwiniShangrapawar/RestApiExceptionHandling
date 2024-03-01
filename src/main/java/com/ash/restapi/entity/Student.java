package com.ash.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stud_rest_tab")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer stdID;

	@Column(name = "sname")
	private String stdName;

	@Column(name = "sgen")
	private String stdGen;

	@Column(name = "scourse")
	private String stdCourse;

	@Column(name = "saddr")
	private String stdAddr;

	public Integer getStdID() {
		return stdID;
	}

	public void setStdID(Integer stdID) {
		this.stdID = stdID;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdGen() {
		return stdGen;
	}

	public void setStdGen(String stdGen) {
		this.stdGen = stdGen;
	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

	public String getStdAddr() {
		return stdAddr;
	}

	public void setStdAddr(String stdAddr) {
		this.stdAddr = stdAddr;
	}

	public Student(Integer stdID, String stdName, String stdGen, String stdCourse, String stdAddr) {
		super();
		this.stdID = stdID;
		this.stdName = stdName;
		this.stdGen = stdGen;
		this.stdCourse = stdCourse;
		this.stdAddr = stdAddr;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [stdID=" + stdID + ", stdName=" + stdName + ", stdGen=" + stdGen + ", stdCourse=" + stdCourse
				+ ", stdAddr=" + stdAddr + "]";
	}

	


}
