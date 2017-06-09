package nl.hu.v1wac.firstapp.persistence;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1wac.firstapp.model.Country;

public class CountryDAO extends BaseDAO {

		  private ArrayList<Country> selectCountries(String query) {
		    ArrayList<Country> results = new ArrayList<Country>();
		    try (Connection con = super.getConnection()){
		      Statement stmt = con.createStatement();
		      ResultSet dbResultSet = stmt.executeQuery(query);

		      while (dbResultSet.next()) {
		        String code = dbResultSet.getString("code");
		        String name = dbResultSet.getString("name");
		        String continent = dbResultSet.getString("continent");
		        String region = dbResultSet.getString("region");
		        int surfacearea = dbResultSet.getInt("surfacearea");
		        int indepyear = dbResultSet.getInt("indepyear");
		        int population = dbResultSet.getInt("population");
		        int lifeexpectancy = dbResultSet.getInt("lifeexpectancy");
		        int gnp = dbResultSet.getInt("gnp");
		        int gnpold = dbResultSet.getInt("gnpold");
		        String localname = dbResultSet.getString("localname");
		        String governmentform = dbResultSet.getString("governmentform");
		        String headofstate = dbResultSet.getString("headofstate");
		        String code2 = dbResultSet.getString("code2");
		        int latitude = dbResultSet.getInt("latitude");
		        int longitude = dbResultSet.getInt("longitude");
		        String capital = dbResultSet.getString("capital");
		        Country newCountry = new Country(code2, code, name, capital, continent, region, surfacearea, population, governmentform, latitude, longitude, indepyear, lifeexpectancy, gnp, gnpold, localname, headofstate);
		        results.add(newCountry);
		      }
		    }catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		   return results;
		  }

		  public Country findByCode(String code) {
		    	  
			  Country newCountry = new Country();
			  
	    	  String query = "SELECT * FROM country WHERE code = '" + code  +"'";
	    	  
			    try (Connection con = super.getConnection()){
				      Statement stmt = con.createStatement();
				      ResultSet dbResultSet = stmt.executeQuery(query);

				      while (dbResultSet.next()) {
				        String iso3code = dbResultSet.getString("code");
				        String name = dbResultSet.getString("name");
				        String continent = dbResultSet.getString("continent");
				        String region = dbResultSet.getString("region");
				        int surfacearea = dbResultSet.getInt("surfacearea");
				        int indepyear = dbResultSet.getInt("indepyear");
				        int population = dbResultSet.getInt("population");
				        int lifeexpectancy = dbResultSet.getInt("lifeexpectancy");
				        int gnp = dbResultSet.getInt("gnp");
				        int gnpold = dbResultSet.getInt("gnpold");
				        String localname = dbResultSet.getString("localname");
				        String governmentform = dbResultSet.getString("governmentform");
				        String headofstate = dbResultSet.getString("headofstate");
				        String code2 = dbResultSet.getString("code2");
				        int latitude = dbResultSet.getInt("latitude");
				        int longitude = dbResultSet.getInt("longitude");
				        String capital = dbResultSet.getString("capital");
				        newCountry = new Country(code2, iso3code , name, capital, continent, region, surfacearea, population, governmentform, latitude, longitude, indepyear, lifeexpectancy, gnp, gnpold, localname, headofstate);
				      }
				    }catch (SQLException sqle) {
						sqle.printStackTrace();
					}
	    	  
	    	  
	    		return  newCountry;
	    	}
		       
		      
		      public ArrayList<Country> find10LargestPopulations(){
		    	  return selectCountries( "SELECT * FROM COUNTRY GROUP BY POPULATION DESC LIMIT 10");
		      }
		      
		      public ArrayList<Country> find10LargestSurfaces(){
		    	  return selectCountries( "SELECT * FROM COUNTRY GROUP BY SURFACEAREA DESC LIMIT 10");
		      }
		      
		    public boolean delete(Country country) {
		  		boolean result = false;
//		  		boolean countryExists = findByCode(country.getIso3Code()) != null;
//		  		
//		  		if (countryExists) {
		  		if (true) {
		  			String query = "DELETE FROM country WHERE code = '" + country.getIso3Code() + "'"; 
		  					
		  			try (Connection con = getConnection()) {
		  				
		  				Statement stmt = con.createStatement();
		  				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
		  					result = true;
		  				}
		  			} catch (SQLException sqle) {
		  				sqle.printStackTrace();
		  			}
		  		}
		  		
		  		return result;
		  	}
		      
		      public boolean save(Country country) {
		    	  System.out.println(country.getIso3Code() + country.getName() + country.getContinent() + country.getRegion() + country.getSurface() + country.getIndepyear() + country.getPopulation() + country.getLifeexpectancy() + country.getGNP() + country.getGNPOld() + country.getLocalname() + country.getGovernment() + country.getHeadofstate() + "AA" + country.getLatitude() + country.getLongitude() + country.getCapital());
		    	  
		    	  boolean result = false;
//			  		boolean countryExists = findByCode(country.getIso3Code()) != null;
//			  		
//			  		if (!countryExists) {
			  		if (true) {
			  			String query = "INSERT INTO public.COUNTRY (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, code2, latitude, longitude, capital) VALUES ( "+ "'" + country.getIso3Code() + "','"  + country.getName() + "','" + country.getContinent() + "','" + country.getRegion()  + "','" + country.getSurface() + "','" + country.getIndepyear()  + "','" +  country.getPopulation()  + "','" +  country.getLifeexpectancy()  + "','" +  country.getGNP()  + "','" +  country.getGNPOld()  + "','" +  country.getLocalname() + "','" + country.getGovernment() + "','" + country.getHeadofstate() + "','" + country.getCode() + "','" + country.getLatitude() + "','" + country.getLongitude() + "','" + country.getCapital() + "')";
			  			try (Connection con = getConnection()) {
			  				
			  				Statement stmt = con.createStatement();
			  				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
			  					result = true;
			  				}
			  			} catch (SQLException sqle) {
			  				sqle.printStackTrace();
			  			}
			  		}
			  		
			  		return result;
			  	}
		      
		      public boolean update(Country country) {
		    	  System.out.println("DAO update country");
		    	  String query = "UPDATE COUNTRY SET name = '" + country.getName() + "', continent ='" + country.getContinent() + "', region ='" + country.getRegion() + "', surfacearea ='" + country.getSurface() + "', indepyear ='" + country.getIndepyear() + "', population ='" + country.getPopulation() + "', lifeexpectancy ='" + country.getLifeexpectancy() + "', gnp ='" + country.getGNP() + "', gnpold ='" + country.getGNPOld() + "', localname ='" + country.getLocalname() + "', governmentform ='" + country.getGovernment() + "', headofstate ='" + country.getHeadofstate() + "', code2 ='" + country.getCode() + "', latitude ='" + country.getLatitude() + "', longitude ='" + country.getLongitude() + "', capital ='" + country.getCapital() + "' WHERE CODE ='" + country.getIso3Code() + "'";
		    	  
		    	  System.out.println(query);
		    	  
		    	  boolean result = false;
		    	  try (Connection con = getConnection()) {
		  				
		  				Statement stmt = con.createStatement();
		  				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
		  					result = true;
		  				}
		  			} catch (SQLException sqle) {
		  				sqle.printStackTrace();
		  			}
		  			return result;
		  		}
		      	
		  public ArrayList<Country> findAll() { 
		    return selectCountries("SELECT * FROM country"); 
		  }
		}


