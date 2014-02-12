public class Match {
	private PlayerInstance[] players;
	private String matchID = "", matchSeqNum, lobbyType = "";
	private long startTime;
	
	public Match(String matchID) {
		this.matchID = matchID;
	}

	public PlayerInstance[] getPlayers() {
		return players;
	}

	public void setPlayers(PlayerInstance[] players) {
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
