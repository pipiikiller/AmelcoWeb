package model;

public class LeaguesDB {
	private String leagueId;
	private String leagueName;
	private int countryId;
	private String country;
	private String historicaData;
	private String fixtures;
	private String liveScore;
	private String numberOfMatches;
	private String lastestMatch;
	
	public LeaguesDB(){
		//to access
	}
	public LeaguesDB(String leagueId, String leagueName,int countryId, String country,
			String historicaData, String fixtures, String liveScore,
			String numberOfMatches, String lastestMatch) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.countryId = countryId;
		this.country = country;
		this.historicaData = historicaData;
		this.fixtures = fixtures;
		this.liveScore = liveScore;
		this.numberOfMatches = numberOfMatches;
		this.lastestMatch = lastestMatch;
	}

	public LeaguesDB(String leagueid, String leagueName, String country, int countryId) {
		super();
		this.leagueId = leagueid;
		this.leagueName = leagueName;
		this.country = country;
		this.countryId = countryId;
	}
	
	public String getCountry(){
		
		return this.country;
	}
	
	public int getCountryId(){
		
		return this.countryId;
	}
	
	public String getLeagueName(){
		return this.leagueName;
	}

	public String getLeagueId(){
		return this.leagueId;
	}
	
	public void setCountry(int countryId, String leagueName, String country, String lastestMatch){
		
		this.countryId = countryId;
		this.leagueName = leagueName;
		this.country = country;
		this.lastestMatch = lastestMatch;
	}


	@Override
	public String toString() {
		return "Leagues [leagueId=" + leagueId + ", leagueName=" + leagueName
				+", countryID="+ countryId + ", country=" + country + ", historicaData=" + historicaData
				+ ", fixtures=" + fixtures + ", liveScore=" + liveScore
				+ ", numberOfMatches=" + numberOfMatches + ", lastestMatch="
				+ lastestMatch + "]\n";
	}
	
	
	
	
	
}
