package nl.hu.v1wac.firstapp.model;

public class Country {
	private String iso2Code;
	private String iso3Code;
	private String name;
	private String capital;
	private String continent;
	private String region;
	private int surface;
	private int population;
	private String government;
	private int latitude;
	private int longitude;
	private int indepyear;
	private int lifeexpectancy;
	private int GNP;
	private int GNPOld;
	private String localname;
	private String headofstate;



	public Country() {
		
	};
	
	public Country(String iso2cd, String iso3cd, String nm, String cap, String ct, String reg, int sur, int pop, String gov, int lat, int lng, int inyr, int liex, int Gnp, int GnpO, String lona, String hof) {
		iso2Code = iso2cd;
		iso3Code = iso3cd;
		name = nm;
		capital = cap;
		continent = ct;
		region = reg;
		surface = sur;
		population = pop;
		government = gov;
		latitude = lat;
		longitude = lng;
		indepyear = inyr;
		lifeexpectancy = liex;
		GNP = Gnp;
		GNPOld = GnpO;
		localname = lona;
		headofstate = hof;
	}
	
	public String getCode() {
		return iso2Code;
	}
	
	public String getIso3Code() {
		return iso3Code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getRegion() {
		return region;
	}
	
	public double getSurface() {
		return surface;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public String getGovernment() {
		return government;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public int getIndepyear() {
		return indepyear;
	}

	public void setIndepyear(int indepyear) {
		this.indepyear = indepyear;
	}

	public int getLifeexpectancy() {
		return lifeexpectancy;
	}

	public void setLifeexpectancy(int lifeexpectancy) {
		this.lifeexpectancy = lifeexpectancy;
	}

	public int getGNP() {
		return GNP;
	}

	public void setGNP(int gNP) {
		GNP = gNP;
	}

	public int getGNPOld() {
		return GNPOld;
	}

	public void setGNPOld(int gNPOld) {
		GNPOld = gNPOld;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}


	public String getHeadofstate() {
		return headofstate;
	}

	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}
}
