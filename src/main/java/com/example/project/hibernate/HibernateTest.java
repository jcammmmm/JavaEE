package com.example.project.hibernate;
public class HibernateTest {
	public static void main(String[] args) {
		CountryDbDAO cdao = new CountryDbDAO();
		System.out.println(cdao.findAll());
	}
}
