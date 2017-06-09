package nl.hu.v1wac.firstapp.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.v1wac.firstapp.model.Country;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;

@Path("/countries")
public class WorldResource {
	
	@GET
	@Produces("application/json")
	public String getWorldService() {
		//System.out.println("Hallo");
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.getAllCountries()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getCode());
			job.add("lat", c.getLatitude());
			job.add("iso3", c.getIso3Code());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("population", c.getPopulation());
			job.add("lng", c.getLongitude());

			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@DELETE
	@Path("{code}")
	@Produces("application/json")
	public String deleteCountry(@PathParam("code") String code) {
		WorldService service = ServiceProvider.getWorldService();
		service.deleteCountry(code);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code", code);
		return job.build().toString();
	}
	
	
	
//Iso3Input=1&landInput=2&hoofdtadInput=3&regioInput=4&continentInput=5&oppervlakteInput=6&onafhankelijkheidsjaarInput=7&inwonersInput=8&levensverwachtingInput=9&GNPInput=10&GNPOudInput=11&LokaleNaamInput=12&RegeringsvormInput=13&HoofdInput=14&LatitudeInput=15&LongitudeInput=16
	@POST
	@Produces("application/json")
	public String saveCountry(@FormParam("Iso3Input") String iso3Input, @FormParam("landInput") String landInput, @FormParam("hoofdtadInput") String hoofdtadInput, @FormParam("regioInput") String regioInput, @FormParam("continentInput") String continentInput, @FormParam("oppervlakteInput") int oppervlakteInput, @FormParam("onafhankelijkheidsjaarInput") int onafhankelijkheidsjaarInput, @FormParam("inwonersInput") int inwonersInput, @FormParam("levensverwachtingInput") int levensverwachtingInput, @FormParam("GNPInput") int GNPInput, @FormParam("GNPOudInput") int GNPOudInput, @FormParam("LokaleNaamInput") String LokaleNaamInput,@FormParam("RegeringsvormInput") String RegeringsvormInput, @FormParam("HoofdInput") String HoofdInput, @FormParam("LatitudeInput") int LatitudeInput, @FormParam("LongitudeInput") int LongitudeInput) {
		System.out.println("Iso3Input " + iso3Input);
		System.out.println("landInput " + landInput);
		System.out.println("hoofdtadInput " + hoofdtadInput);
		System.out.println("regioInput " + regioInput);
		System.out.println("continentInput " + continentInput);
		System.out.println("oppervlakteInput " + oppervlakteInput);
		System.out.println("onafhankelijkheidsjaarInput " + onafhankelijkheidsjaarInput);
		System.out.println("inwonersInput " + inwonersInput);
		System.out.println("levensverwachtingInput " + levensverwachtingInput);
		System.out.println("GNPInput " + GNPInput);
		System.out.println("GNPOudInput" + GNPOudInput);
		System.out.println("LokaleNaamInput " + LokaleNaamInput);
		System.out.println("RegeringsvormInput " + RegeringsvormInput);
		System.out.println("HoofdInput " + HoofdInput);
		System.out.println("LatitudeInput " + LatitudeInput);
		System.out.println("LongitudeInput " + LongitudeInput);
		WorldService service = ServiceProvider.getWorldService();
//		service.saveCountry(code);
//
//		JsonObjectBuilder job = Json.createObjectBuilder();
//		job.add("code", code);
//		return job.build().toString();
//		JsonObjectBuilder job = Json.createObjectBuilder();
		
		Country nieuweCountry = new Country("", iso3Input, landInput, hoofdtadInput, continentInput, regioInput, oppervlakteInput, inwonersInput, RegeringsvormInput, LatitudeInput, LongitudeInput, onafhankelijkheidsjaarInput, levensverwachtingInput, GNPInput, GNPOudInput, LokaleNaamInput, "");
		service.saveCountry(nieuweCountry);
		
		System.out.println("Dit wil ik zien");
		//System.out.println("=====> " + message.getNaam());
		return "";
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	public String updateCountry(@FormParam("iso2") String iso2, @FormParam("iso3") String iso3, @FormParam("land") String land, @FormParam("hoofdtad") String hoofdstad, @FormParam("regio") String regio, @FormParam("continent") String continent, @FormParam("oppervlakte") int oppervlakte, @FormParam("onafhankelijkheidsjaar") int onafhankelijkheidsjaar, @FormParam("inwoners") int inwoners, @FormParam("levensverwachting") int levensverwachting, @FormParam("GNP") int GNP, @FormParam("GNPOud") int GNPOud, @FormParam("lokalenaam") String lokalenaam,@FormParam("regeringsvorm") String regeringsvorm, @FormParam("hoofd") String hoofd, @FormParam("latitude") int latitude, @FormParam("longitude") int longitude, @FormParam("staatshoofd") String staatshoofd) {
		System.out.println("Updating country");
		
		WorldService service = ServiceProvider.getWorldService();
		Country geupdateCountry = new Country(iso2, iso3, land, hoofdstad, continent, regio, oppervlakte, inwoners, regeringsvorm, latitude, longitude, onafhankelijkheidsjaar, levensverwachting, GNP, GNPOud, lokalenaam, staatshoofd);
		service.updateCountry(geupdateCountry);
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("success", true);
		return job.build().toString();
	}

	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getWorldServiceInfo(@PathParam("code") String code) {
		WorldService service = ServiceProvider.getWorldService();
		Country country = service.getCountryByCode(code);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code", country.getCode());
		job.add("name", country.getName());
		job.add("capital", country.getCapital());
		job.add("surface", country.getSurface());
		job.add("government", country.getGovernment());
		job.add("lat", country.getLatitude());
		job.add("iso3", country.getIso3Code());
		job.add("continent", country.getContinent());
		job.add("region", country.getRegion());
		job.add("population", country.getPopulation());
		job.add("lng", country.getLongitude());
		job.add("indepyear", country.getIndepyear());
		job.add("lifeexpectancy", country.getLifeexpectancy());
		job.add("GNP", country.getGNP());
		job.add("GNPOld", country.getGNPOld());
		job.add("localname", country.getLocalname());
		job.add("headofstate", country.getHeadofstate());

		return job.build().toString();
	}

	@Path("/largestsurfaces")
	public String getLargestSurfaces() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.get10LargestSurfaces()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getCode());
			job.add("lat", c.getLatitude());
			job.add("iso3", c.getIso3Code());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("population", c.getPopulation());
			job.add("lng", c.getLongitude());

			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	@Path("/largestpopulations")
	public String getLargestPopulations() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Country c : service.get10LargestPopulations()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getCode());
			job.add("lat", c.getLatitude());
			job.add("iso3", c.getIso3Code());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("population", c.getPopulation());
			job.add("lng", c.getLongitude());

			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
