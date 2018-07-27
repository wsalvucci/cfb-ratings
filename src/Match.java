
public class Match {
	Team winningTeam;
	Team losingTeam;
	int winningScore;
	int losingScore;

	public Match(Team winningTeam, Team losingTeam, int winningScore, int losingScore) {
		this.winningTeam = winningTeam;
		this.losingTeam = losingTeam;
		this.winningScore = winningScore;
		this.losingScore = losingScore;
	}
	
	/**
	 * Creates a sigmoid function and modifies it with the given parameters, then returns the value of the function given the input.
	 * 
	 * @param value The value to be calculated in the function.
	 * @param heightFactor How much to increase the height of the sigmoid curve by.
	 * @param widthFactor How much to decrease the width of the sigmoid curve by.
	 * @param hshift How much to shift the sigmoid curve horizontally. Positive values shift right, negative shift left.
	 * @param vshift How much to shift the sigmoid curve vertically. Positive values shift up, negative shift down.
	 * @param invert Whether the function should be inverted (x --> inf. is less than x --> -inf.)
	 * @return double The value of the function given the parameters.
	 */
	private double sigmoidFunction(double value, double heightFactor, double widthFactor, double hshift, double vshift, boolean invert) {
		double numerator;
		double denominator;
		if (!invert) {
			numerator = heightFactor * Math.pow(Math.E, ((widthFactor * value) - (hshift * widthFactor)));
			denominator = Math.pow(Math.E, ((widthFactor * value) - (hshift * widthFactor))) + 1;
		} else {
			numerator = heightFactor * Math.pow(Math.E, ((-widthFactor * value) - (hshift * widthFactor)));
			denominator = Math.pow(Math.E, ((-widthFactor * value) - (hshift * widthFactor))) + 1;
		}
		return (numerator / denominator) + vshift;
	}
	
	/**
	 * Creates a sigmoid function solved for x instead of y and modifies it with the given parameters, then returns the value of the function
	 * given the input.
	 * 
	 * @param value The value to be calculated in the function.
	 * @param heightFactor How much to increase the height of the sigmoid curve by.
	 * @param widthFactor How much to decrease the width of the sigmoid curve by.
	 * @param hshift Not yet implemented.
	 * @param vshift How much to shift the sigmoid curve vertically. Positive values shift up, negative shift down.
	 * @param invert Whether the function should be inverted (y --> inf. is less than y --> -inf.)
	 * @return double The value of the function given the parameters.
	 */
	private double rotSigmoidFunction(double value, double heightFactor, double widthFactor, double hshift, double vshift, boolean invert) {
		double numerator = widthFactor * value;
		double denominator = 1 - (widthFactor * value);
		if (!invert) {
			return heightFactor * Math.log(numerator / denominator) + vshift;
		} else {
			return heightFactor * -Math.log(numerator / denominator) + vshift;
		}
	}
	
	/**
	 * Takes the rating of a team or person, compares it to the rating of an opponent, and generates an expected performance on a 
	 * scale from 0-1, with 0.5 being a tie, <0.5 being unfavorable for the team, and >0.5 being favorable for the team.
	 * 
	 * @param rating The rating of the team/person.
	 * @param oppRating The rating of the opponent.
	 * @return double Returns the expected performance.
	 */
	private double calculateExpectedPerformance(double rating, double oppRating) {
		return 1 / (1 + Math.pow(10, (oppRating - rating) / 400));
	}
	
	/**
	 * Takes the rating of a team or person, compares their actual performance against their expected performance, then creates a new rating.
	 * 
	 * @param rating The rating of the team/person.
	 * @param actual The actual performance.
	 * @param expected The expected performance.
	 * @return double Returns the new rating of the team/person.
	 */
	private double calculateNewRating(double rating, double actual, double expected) {
		double K = 16;
		return rating + (K * (actual - expected));
	}
	
	public void runMatch() {
		
	}
}
