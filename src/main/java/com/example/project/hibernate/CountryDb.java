package com.example.project.hibernate;
// default package

import java.util.Set;


/**
 * CountryDb entity. @author MyEclipse Persistence Tools
 */
public class CountryDb extends AbstractCountryDb implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CountryDb() {
		super();
	}

	/** default constructor 
     * @param set 
     * @param string 
     * @param extension 
     * @param population 
     * @param name 
     * @param id */
    public CountryDb(long id, String name, int population, double extension, String string, Set<WarDb> set) {
    	super(id, name, population, extension, string, set);
    }

	/** minimal constructor */
    public CountryDb(long cid) {
        super(cid);        
    }
    
    /** full constructor */
    public CountryDb(long id, String countryname, Integer population, Double extension, String govtype, Set<WarDb> warDbs) {
        super(id, countryname, population, extension, govtype, warDbs);        
    }
   
}
