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
	final private String URL_MATCH_HISTORY_BASE = 
			"https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/";

	public APIHandler(String API_KEY) {
		this.API_KEY = API_KEY;
	}
	
	private ArrayList<Match> retrieveMatchesFromJson(String siteParameters) {
		ArrayList<Match> matchList = new ArrayList<Match>();
		JsonElement jsonElement = null;
		try {
			String jsonString = IOUtils.toString(new URL(URL_MATCH_HISTORY_BASE + 
					"?key=" + API_KEY + siteParameters));
			JsonParser jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(jsonString);
			if(jsonElement.isJsonObject()) {
				JsonObject result = jsonElement.getAsJsonObject().getAsJsonObject("result");
				JsonArray jsonMatchList = result.getAsJsonArray("matches");
				for(JsonElement matchListElement : jsonMatchList) {
					Match match = new Match(matchListElement.getAsJsonObject().get("match_id").getAsString());
					match.setLobbyType(matchListElement.getAsJsonObject().get("lobby_type").getAsString());
					match.setMatchSeqNum(matchListElement.getAsJsonObject().get("match_seq_num").getAsString());
					match.setStartTime(matchListElement.getAsJsonObject().get("start_time").getAsLong());
					matchList.add(match);
				}
				return matchList;
			}
		} catch(IOException e) {
			System.out.println("Failed to connect to WebAPI!");
		}
		return null;
	}
	
	public ArrayList<Match> retrieveFullMatchHistory(DotaEntity entity) {
		if(entity instanceof Player) {
			Player thisPlayer = (Player) entity;
			return retrieveMatchesFromJson("&account_id=" + thisPlayer.getAccountID());	
		} else if (entity instanceof Hero) {
			Hero thisHero = (Hero) entity;
			return retrieveMatchesFromJson("&hero_id=" + thisHero.getID());	
		} else {
			System.out.println("Unknown instance of DotaEntity.");
			return null;
		}
	}
	
	public ArrayList<Match> retrieveMatchHistory(DotaEntity entity, SearchConstraints constraints) {
		return null;
	}
	
	//Getters and setters
	
	public int getFetchInterval() {
		return fetchInterval;
	}
	
	public void setFetchInterval(int newInterval) {
		if(newInterval > 0) {
			this.fetchInterval = newInterval;
		} else {
			System.out.println("New fetch interval must be above 0ms.");
		}
	}
	
	public int getMatchesRequested() {
		return matchesRequested;
	}
	
	public void setMatchesRequested(int newMatchesRequested) {
		if(newMatchesRequested > 0 && newMatchesRequested <= 25) {
			matchesRequested = newMatchesRequested;
		}
	}
}
