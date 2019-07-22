package com.example.project.view;

import java.util.ArrayList;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class DisplayCountries implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Country> countries;
	
	public DisplayCountries() {
		countries = new ArrayList<>();
		this.countries.add(new Country("alpha", 1000, 1000.0, GovType.Anarchism,      this.getActiveWars(3)));
		this.countries.add(new Country("beta",  2000, 2000.0, GovType.AnarchoCapitalism, this.getActiveWars(3)));
		this.countries.add(new Country("gamma", 3000, 3000.0, GovType.Capracracy,     this.getActiveWars(3)));
		this.countries.add(new Country("delta", 4000, 4000.0, GovType.Communism,      this.getActiveWars(3)));
		this.countries.add(new Country("tetha", 5000, 5000.0, GovType.Demarchy,       this.getActiveWars(3)));
		this.countries.add(new Country("rho",   6000, 6000.0, GovType.Corporatocracy, this.getActiveWars(3)));
		System.out.println("sample data added!");
	}
	
	private ArrayList<War> getActiveWars(int number) {
		Random rnd = new Random();
		ArrayList<War> activeWars = new ArrayList<>();
		for(int i = 0; i < number; i++)
			activeWars.add(War.values()[rnd.nextInt(War.CONFLICT_NUMBER - 1)]);
		return activeWars;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public String editCountry(Country c) {
		System.out.println(c.getName());
		return "/editCountry.xhtml?faces-redirect=true";
	}
}
