import java.util.ArrayList;

public class Match {
	private Player[] players;
	private String matchID = "";
	private String matchSeqNum;
	private String lobbyType = "";
	private long startTime;
	
	public Match(String matchID) {
		this.matchID = matchID;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public String getMatchID() {
		return matchID;
	}

	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}

	public String getMatchSeqNum() {
		return matchSeqNum;
	}

	public void setMatchSeqNum(String matchSeqNum) {
		this.matchSeqNum = matchSeqNum;
	}

	public String getLobbyType() {
		return lobbyType;
	}

	public void setLobbyType(String lobbyType) {
		this.lobbyType = lobbyType;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
