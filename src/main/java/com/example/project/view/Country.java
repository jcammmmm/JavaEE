package com.example.project.view;
import java.util.ArrayList;

public class Country {
	private String name;
	private int population;
	private double extension;
	private GovType govType;
	private ArrayList<War> activeWars;
	
	public Country(String name, int population, double extension, GovType govType, ArrayList<War> activeWars) {
		this.name = name;
		this.population = population;
		this.extension = extension;
		this.govType = govType;
		this.activeWars = activeWars;
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
