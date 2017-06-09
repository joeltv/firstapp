package nl.hu.v1wac.firstapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import nl.hu.v1wac.firstapp.persistence.CountryDAO;
public class WorldService {
	private List<Country> allCountries = new ArrayList<Country>();
	
	public WorldService() {
		
	}
	
	public ArrayList<Country> getAllCountries() {
		CountryDAO countryDAO  = new CountryDAO();
		ArrayList<Country> lCountries = countryDAO.findAll();
		allCountries = lCountries;
		return lCountries;
	}
	
	public boolean deleteCountry(String code) {
		CountryDAO countryDAO  = new CountryDAO();
		Country country = countryDAO.findByCode(code);
		countryDAO.delete(country);
		return true;
	}
	
	public boolean updateCountry(Country country) {
		System.out.println("Service update country");
		CountryDAO countryDAO  = new CountryDAO();
		countryDAO.update(country);
		return true;
	}
	
	public boolean saveCountry(Country country) {
		CountryDAO countryDAO  = new CountryDAO();
		countryDAO.save(country);
		return true;
	}
	
	public List<Country> get10LargestPopulations() {
		Collections.sort(allCountries, new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return c2.getPopulation() - c1.getPopulation();
			};
		});
		
		return allCountries.subList(0, 10);
	}

	public List<Country> get10LargestSurfaces() {
		Collections.sort(allCountries, new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return (int)(c2.getSurface() - c1.getSurface());
			};
		});
		
		return allCountries.subList(0, 10);
	}
	
	public Country getCountryByCode(String code) {
		Country result = null;
		
		for (Country c : allCountries) {
			if (c.getIso3Code().equals(code)) {
				result = c;
				break;
			}
		}
		
		return result;
	}
}
