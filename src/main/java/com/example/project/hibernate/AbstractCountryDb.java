package com.example.project.hibernate;
// default package

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import com.example.project.view.*;

/**
 * AbstractCountryDb entity provides the base persistence definition of the
 * CountryDb entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCountryDb implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long cid;
	private String countryname;
	private Integer population;
	private Double extension;
	private String govtype;
	private Set<WarDb> warDbs = new HashSet<WarDb>(0);

	// Constructors

	/** default constructor */
	public AbstractCountryDb() {
	}

	/** minimal constructor */
	public AbstractCountryDb(Long cid) {
		this.cid = cid;
	}

	/** full constructor */
	public AbstractCountryDb(Long id, String countryname, Integer population, Double extension, String govtype,
			Set<WarDb> warDbs) {
		this.cid = id;
		this.countryname = countryname;
		this.population = population;
		this.extension = extension;
		this.govtype = govtype;
		this.warDbs = warDbs;
	}

	// Property accessors
	
	@Override
	public String toString() {
		return "[AbsCountryDb.toString] " + cid + " " + countryname + " " + population +
				" " + extension + " " + govtype + " " + warDbs;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getExtension() {
		return extension;
	}

	public void setExtension(Double extension) {
		this.extension = extension;
	}

	public String getGovtype() {
		return govtype;
	}

	public void setGovtype(String govtype) {
		this.govtype = govtype;
	}

	public Set<WarDb> getWarDbs() {
		return warDbs;
	}

	public void setWarDbs(Set<WarDb> warDbs) {
		this.warDbs = warDbs;
	}

	/*
	 * Converts a CountryDb instance to a plain Country from old code
	 */
	public Country normalizeCountryDb() {
		WarDb[] warsDb = warDbs.toArray(new WarDb[0]);
		ArrayList<War> wars = new ArrayList<>();

		for (WarDb w : warsDb)
			wars.add(w.normalizeWarDb());
		return new Country(cid, countryname, population, extension, GovType.stringToGovType(govtype), wars);
	}
}