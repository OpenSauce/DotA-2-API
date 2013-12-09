import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

public class APIHandler {
	private int fetchInterval = 500;
	private int matchesRequested = 25;
	final private String API_KEY;
	final private String URL_MATCH_HISTORY_BASE = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/";

	public APIHandler(String API_KEY) {
		this.API_KEY = API_KEY;
	}

	private ArrayList<Match> retrieveMatchesFromJson(String siteParameters) {
		ArrayList<Match> matchList = new ArrayList<Match>();
		JsonElement jsonElement = null;
		try {
			String jsonString = IOUtils.toString(new URL(URL_MATCH_HISTORY_BASE
					+ "?key=" + API_KEY + siteParameters));
			JsonParser jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(jsonString);
			if (jsonElement.isJsonObject()) {
				JsonObject result = jsonElement.getAsJsonObject()
						.getAsJsonObject("result");
				if (result.getAsJsonObject().get("num_results").getAsInt() > 0) {
					JsonArray jsonMatchList = result.getAsJsonArray("matches");
					for (JsonElement matchListElement : jsonMatchList) {
						Match match = new Match(matchListElement
								.getAsJsonObject().get("match_id")
								.getAsString());
						match.setLobbyType(matchListElement.getAsJsonObject()
								.get("lobby_type").getAsString());
						match.setMatchSeqNum(matchListElement.getAsJsonObject()
								.get("match_seq_num").getAsString());
						match.setStartTime(matchListElement.getAsJsonObject()
								.get("start_time").getAsLong());
						JsonArray playerList = matchListElement
								.getAsJsonObject().getAsJsonArray("player");
						PlayerInstance[] playerArray = new PlayerInstance[10];
						for (int i = 0; i < 3; i++) {
							String accountID = playerList.get(i)
									.getAsJsonObject().get("account_id")
									.getAsString();
							String playerSlot = playerList.get(i)
									.getAsJsonObject().get("player_slot")
									.getAsString();
							String heroID = playerList.get(i).getAsJsonObject()
									.get("hero_id").getAsString();
							playerArray[i] = new PlayerInstance(accountID,
									playerSlot, heroID);
						}
						match.setPlayers(playerArray);
						matchList.add(match);
					}
				}
				return matchList;
			}
		} catch (IOException e) {
			System.out.println("Failed to connect to WebAPI!");
		}
		return null;
	}

	private ArrayList<Match> retrieveAllMatchesFromJson(String siteParameters) {
		ArrayList<Match> fullMatchHistory = new ArrayList<Match>();
		ArrayList<Match> tempMatchHistory = new ArrayList<Match>();
		String lastMatchID = "";
		do {
			tempMatchHistory = retrieveMatchesFromJson(siteParameters + lastMatchID);
			fullMatchHistory.addAll(tempMatchHistory);
			int tempID = Integer.parseInt(tempMatchHistory.get(tempMatchHistory.size()).getMatchID()) - 1;
			lastMatchID = "&start_at_match_id= + tempID";
		} while (tempMatchHistory.size() == 100);
		return fullMatchHistory;
	}

	public ArrayList<Match> retrieveFullMatchHistory(DotaEntity entity) {
		if (entity instanceof User) {
			User thisPlayer = (User) entity;
			return retrieveAllMatchesFromJson("&account_id="
					+ thisPlayer.getAccountID());
		} else if (entity instanceof Hero) {
			Hero thisHero = (Hero) entity;
			return retrieveAllMatchesFromJson("&hero_id=" + thisHero.getID());
		} else {
			System.out.println("Unknown instance of DotaEntity.");
			return null;
		}
	}

	public ArrayList<Match> retrieveMatchHistory(DotaEntity entity,
			SearchConstraints constraints) {
		return null;
	}

	// Getters and setters

	public int getFetchInterval() {
		return fetchInterval;
	}

	public void setFetchInterval(int newInterval) {
		if (newInterval > 0) {
			this.fetchInterval = newInterval;
		} else {
			System.out.println("New fetch interval must be above 0ms.");
		}
	}

	public int getMatchesRequested() {
		return matchesRequested;
	}

	public void setMatchesRequested(int newMatchesRequested) {
		if (newMatchesRequested > 0 && newMatchesRequested <= 25) {
			matchesRequested = newMatchesRequested;
		}
	}
}
