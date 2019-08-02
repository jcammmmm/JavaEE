package com.example.project.hibernate;

import com.example.project.view.War;

// default package

/**
 * AbstractWarDb entity provides the base persistence definition of the WarDb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWarDb implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Integer wid;
	private CountryDb countryDb;
	private String warname;

	// Constructors

	/** default constructor */
	public AbstractWarDb() {
	}

	/** minimal constructor */
	public AbstractWarDb(Integer wid) {
		this.wid = wid;
	}

	/** full constructor */
	public AbstractWarDb(Integer wid, CountryDb countryDb, String warname) {
		this.wid = wid;
		this.countryDb = countryDb;
		this.warname = warname;
	}

	// Property accessors

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public CountryDb getCountryDb() {
		return this.countryDb;
	}

	public void setCountryDb(CountryDb countryDb) {
		this.countryDb = countryDb;
	}

	public String getWarname() {
		return this.warname;
	}

	public void setWarname(String warname) {
		this.warname = warname;
	}

	/*
	 * Converts a WarDb instance to a plain War from old code TODO: implement
	 * using valueOf()
	 */
	public War normalizeWarDb() {
		for (War w : War.values())
			if (warname.equals(w.name()))
				return w;
		return War.DefaultWar;
	}
}