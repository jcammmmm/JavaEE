package com.example.project.view;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;


import com.example.project.hibernate.CountryDb;
import com.example.project.hibernate.WarDb;

// It is only a plain object, not a functional bean.
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private int population;
	private double extension;
	private GovType govType;
	private ArrayList<War> activeWars;
	
	public Country() {
		id = DisplayCountries.getNextId();
		name = "";
		population = 0;
		extension = 0.0;
		govType = GovType.Anarchy;
		activeWars = new ArrayList<War>();
	}
	
	public Country(long id, String name, int population, double extension, GovType govType, ArrayList<War> activeWars) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.extension = extension;
		this.govType = govType;
		this.activeWars = activeWars;
	}
	
	public String toString() {
		return "[Country.toString()]: " + id + " " + name + " " + population + " " + extension + " " + govType + " " + activeWars;
	}
	
	/*
	 * This method is used in order to translate Country instances into ContryDb 
	 * instances in order to save them in database.
	 */
	public CountryDb formatToSave() {
		CountryDb cDb = new CountryDb(id, name, population, extension, govType.name(), new HashSet<WarDb>());
		for(Object o : activeWars)
			cDb.getWarDbs().add(new WarDb(1, cDb, o.toString()));
//		activeWars.forEach(war -> cDb.getWarDbs().add(new WarDb(1, cDb, war.name())));
		return cDb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getExtension() {
		return extension;
	}

	public void setExtension(double extension) {
		this.extension = extension;
	}

	public GovType getGovType() {
		return govType;
	}

	public void setGovType(GovType govType) {
		this.govType = govType;
	}

	public ArrayList<War> getActiveWars() {
		return activeWars;
	}

	public void setActiveWars(ArrayList<War> activeWars) {
		this.activeWars = activeWars;
	}

}
