import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFileReader {

	public static void main(String[] args) {
		ArrayList<Team> teamList = new ArrayList<Team>();
		ArrayList<Match> matchList = new ArrayList<Match>();
		try {
			Scanner sc = new Scanner(new File("FBS2017.csv"));
			sc.useDelimiter(",");
			while (sc.hasNextLine()) {
				String date = sc.next();
				
				String winningTeamName = sc.next();
				int winningTeamScore = Integer.parseInt(sc.next());
				
				String losingTeamName = sc.next();
				int losingTeamScore = Integer.parseInt(sc.next());
				
				if (winningTeamName.substring(0, 1).equals("@")) {
					winningTeamName = winningTeamName.substring(1);
				}
				if (losingTeamName.substring(0, 1).equals("@")) {
					losingTeamName = losingTeamName.substring(1);
				}
				
				Team winningTeam = null;
				Team losingTeam = null;
				
				for (Team team : teamList) {
					if (team.name.equals(winningTeamName)) {
						winningTeam = team;
					} else if (team.name.equals(losingTeamName)) {
						losingTeam = team;
					}
				}
				
				if (winningTeam == null) {
					winningTeam = new Team(winningTeamName);
					teamList.add(winningTeam);
				}
				if (losingTeam == null) {
					losingTeam = new Team(losingTeamName);
					teamList.add(losingTeam);
				}
				
				Match match = new Match(winningTeam, losingTeam, winningTeamScore, losingTeamScore);
				match.runMatch();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
