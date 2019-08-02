package com.example.project.view;

public enum GovType {
	Anarchism, AnarchoCapitalism,Anarchy
	,Aristocracy,Autocracy,Capracracy
	,Communism,Corporatocracy,Demarchy, DefaultGovType;
	
	public static GovType stringToGovType(String s) {
		for(GovType g : GovType.values()) {
			if(g.name().equals(s)) {
				return g;
			}
		}
		return GovType.DefaultGovType;
	}
}
