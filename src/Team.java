
public class Team {
	String name;
	double totalRating = 1500;
	double offRating = 1500;
	double defRating = 1500;
	int wins = 0;
	int losses = 0;
	int pointsAgainst = 0;
	int pointsFor = 0;
	double oppOffRating = 0;
	double oppDefRating = 0;
	
	public Team(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return int Returns the total number of games this team has played.
	 */
	public int getTotalGames() {
		return wins + losses;
	}
	
	/**
	 * 
	 * @return double Returns the team's average points against per game.
	 */
	public double avgPointsAgainst() {
		if (getTotalGames() == 0)
			return 0;
		else
			return pointsAgainst / getTotalGames();
	}
	
	/**
	 * 
	 * @return double Returns the team's average points for per game.
	 */
	public double avgPointsFor() {
		if (getTotalGames() == 0)
			return 0;
		else
			return pointsFor / getTotalGames();
	}
	
	/**
	 * 
	 * @return double Returns the team's average opponent offensive rating.
	 */
	public double getAvgOppOffRating() {
		if (getTotalGames() == 0)
			return 0;
		else
			return oppOffRating / getTotalGames();
	}
	
	/**
	 * 
	 * @return double Returns the team's average opponents defensive rating.
	 */
	public double getAvgOppDefRating() {
		if (getTotalGames() == 0)
			return 0;
		else
			return oppDefRating / getTotalGames();
	}
}
