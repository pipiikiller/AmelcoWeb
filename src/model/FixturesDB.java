package model;

public class FixturesDB {
	private String teamName;
	private String teamId;
	private String played;
	private String playedAtHome;
	private String playedAway;
	private String won;
	private String draw;
	private String lost;
	private String numberOfShots;
	private String yellowCards;
	private String redCards;
	private String goalsFor;
	private String goalsAgaint;
	private String goalDifference;
	private String points;
	private String leagueName;
	private String season;
	private String id;
	
	public FixturesDB(String teamName, String teamId, String played,
			String playedAtHome, String playedAway, String won, String draw,
			String lost, String numberOfShots, String yellowCards,
			String redCards, String goalsFor, String goalsAgaint,
			String goalDifference, String points, String leagueName,
			String season, String id) {
		super();
		this.teamName = teamName;
		this.teamId = teamId;
		this.played = played;
		this.playedAtHome = playedAtHome;
		this.playedAway = playedAway;
		this.won = won;
		this.draw = draw;
		this.lost = lost;
		this.numberOfShots = numberOfShots;
		this.yellowCards = yellowCards;
		this.redCards = redCards;
		this.goalsFor = goalsFor;
		this.goalsAgaint = goalsAgaint;
		this.goalDifference = goalDifference;
		this.points = points;
		this.leagueName = leagueName;
		this.season = season;
		this.id = id;
	}

	@Override
	public String toString() {
		return "FixturesDB [teamName=" + teamName + ", teamId=" + teamId
				+ ", played=" + played + ", playedAtHome=" + playedAtHome
				+ ", playedAway=" + playedAway + ", won=" + won + ", draw="
				+ draw + ", lost=" + lost + ", numberOfShots=" + numberOfShots
				+ ", yellowCards=" + yellowCards + ", redCards=" + redCards
				+ ", goalsFor=" + goalsFor + ", goalsAgaint=" + goalsAgaint
				+ ", goalDifference=" + goalDifference + ", points=" + points
				+ ", leagueName=" + leagueName + ", season=" + season + ", id="
				+ id + "]\n";
	}
	
	
}
