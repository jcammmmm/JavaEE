package com.example.project.view;

import java.util.ArrayList;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class DisplayCountries implements Serializable  {

	private static final long serialVersionUID = 1L;
	private Country currCountry; // country focus for further creation, reading and update.
	private static long nextId;
	private String errorMessage;
	private ArrayList<Country> countries;
	
	public DisplayCountries() {
		currCountry = new Country();
		nextId = 0;
		errorMessage = "No error messages.";
		countries = new ArrayList<>();
		this.countries.add(new Country(getNextId(), "alpha", 1000, 1000.0, GovType.Anarchism,      this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "beta",  2000, 2000.0, GovType.AnarchoCapitalism, this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "gamma", 3000, 3000.0, GovType.Capracracy,     this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "delta", 4000, 4000.0, GovType.Communism,      this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "tetha", 5000, 5000.0, GovType.Demarchy,       this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "rho",   6000, 6000.0, GovType.Corporatocracy, this.getActiveWars(3)));
	}
	
	private ArrayList<War> getActiveWars(int number) {
		Random rnd = new Random();
		ArrayList<War> activeWars = new ArrayList<>();
		for(int i = 0; i < number; i++)
			activeWars.add(War.values()[rnd.nextInt(War.CONFLICT_NUMBER - 1)]);
		return activeWars;
	}

	public ArrayList<Country> getCountries() { return countries; }
		
	public Country getCurrCountry() { return currCountry; }

	public void setCurrCountry(Country currCountry) { this.currCountry = currCountry; }
	
	public String getErrorMessage() { return errorMessage; }
	
	public static long getNextId() { return nextId++; }

	// ------------------------------------------------------
	// CRUD
	// ------------------------------------------------------
	public String createCountry() {
		this.currCountry = new Country();
		return "/editCountry.xhtml";	
	}
	
	public void readCountry() {
		// TO DO
	}
	
	public String updateCountry(Country c) {
		this.currCountry = c;
		return "/editCountry.xhtml";
	}
	
	public void deleteCountry(Country c) {
		countries.remove(c);
	}
	
	public String saveCountry() {
		int idx = countries.indexOf(currCountry);
		System.out.println(currCountry.getName());
		if(idx != -1)
			countries.set(idx, currCountry);
		else
			countries.add(currCountry);
		return "/index.xhtml";
	}
	// ------------------------------------------------------
	// MISC
	// ------------------------------------------------------
	public Country getCountry(long id) {
		for(Country c : countries)
			if(c.getId() == id) 
				return c;
		return null;
	}
	
	public boolean isNameAvailable(String name) {
		for(Country c : countries)
			if(c.getName().equals(name))
				return false;
		return true;
	}
}
