package com.example.project.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.hibernate.HibernateException;

import java.io.Serializable;

import com.example.project.hibernate.*;


@Named
@SessionScoped
public class DisplayCountries implements Serializable  {

	private static final long serialVersionUID = 1L;
	private Country currCountry; // country focus for further creation, reading and update.
	private static long nextId;
	private String errorMessage;
	private ArrayList<Country> countries;
	private CountryDbDAO cdao;
	
	public DisplayCountries() {
		currCountry = new Country();
		nextId = 0;
		errorMessage = "No error messages.";
		countries = new ArrayList<>();
		cdao = new CountryDbDAO();
	}
	
	private ArrayList<War> getActiveWars(int number) {
		Random rnd = new Random();
		ArrayList<War> activeWars = new ArrayList<>();
		for(int i = 0; i < number; i++)
			activeWars.add(War.values()[rnd.nextInt(War.CONFLICT_NUMBER - 1)]);
		return activeWars;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Country> getCountries() {
		List<CountryDb> countriesFromDB;
		ArrayList<Country> countries = new ArrayList<>();
		try {
			countriesFromDB = cdao.findAll();
			for(CountryDb cdb : countriesFromDB)
				countries.add(cdb.normalizeCountryDb());
		} catch (HibernateException e){
			e.printStackTrace();
		}
		return countries;
	}
		
	public Country getCurrCountry() { return currCountry; }

	public void setCurrCountry(Country currCountry) { this.currCountry = currCountry; }
	
	public String getErrorMessage() { return errorMessage; }
	
	public static long getNextId() { return nextId++; }
	
	public static ArrayList<String> getWarsAvailable() {
		ArrayList<String> arr = new ArrayList<>();
		for(War w : War.values())
			arr.add(w.toString());
		return arr;
	}
	
	public static ArrayList<String> getGovsAvailable() {
		ArrayList<String> arr = new ArrayList<>();
		for(GovType g : GovType.values())
			arr.add(g.toString());
		return arr;
	}

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
		cdao.delete(c.formatToSave());
	}
	
	public String saveCountry() {
		System.out.println(currCountry.toString());
		CountryDb cDb = currCountry.formatToSave();
		long idToCommit = getId();
		if(idToCommit > 0) {
			System.out.println("[DisplayCountries.saveCountry() retr id was. " + getId());
			cDb.setCid(idToCommit + 1);
		} else
			System.out.println("[DisplayCountries.saveCountry() index was -1");
		System.out.println("[DisplayCountry.saveCountry] Saving country with name: " + cDb.toString());
		cdao.save(cDb);
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
	
	public void initDbinMemory() {
		countries = new ArrayList<>();
		this.countries.add(new Country(getNextId(), "alpha", 1000, 1000.0, GovType.Anarchism,      this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "beta",  2000, 2000.0, GovType.AnarchoCapitalism, this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "gamma", 3000, 3000.0, GovType.Capracracy,     this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "delta", 4000, 4000.0, GovType.Communism,      this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "tetha", 5000, 5000.0, GovType.Demarchy,       this.getActiveWars(3)));
		this.countries.add(new Country(getNextId(), "rho",   6000, 6000.0, GovType.Corporatocracy, this.getActiveWars(3)));
	}
	
	public long getId() {
		long max = -1;
		List<CountryDb> countries = cdao.findAll();
		for(CountryDb c : countries)
			if(c.getCid() > max)
				max = c.getCid();
		return max;
	}
}
