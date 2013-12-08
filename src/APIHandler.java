import java.io.IOException;
import java.io.StringReader;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.apache.commons.io.IOUtils;


public class APIHandler {
	private Format defaultFormat;
	private int fetchInterval = 500;
	private int matchesRequested = 25;
	final private String API_KEY;
	final private String URL_BASE = 
			"https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/";

	public APIHandler(String API_KEY) {
		this.API_KEY = API_KEY;
		this.defaultFormat = Format.JSON;
	}
	
	public APIHandler(String API_KEY, Format defaultFormat) {
		this.API_KEY = API_KEY;
		this.defaultFormat = defaultFormat;
	}
	
	private JsonElement retrieveJsonElement(String siteParameters) {
		JsonElement jsonElement = null;
		try {
			String jsonString = IOUtils.toString(new URL(URL_BASE + 
					"?key=" + API_KEY + siteParameters));
			JsonParser jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(jsonString);
		} catch(IOException e) {
			
		}
		return jsonElement;
	}
	
	public ArrayList<Match> retrieveFullMatchHistory(DotaEntity entity) {
		ArrayList<Match> retrievedMatchList = new ArrayList<Match>();
		if(entity instanceof Player) {
			Player thisPlayer = (Player) entity;
			JsonElement retrievedJson = retrieveJsonElement("&account_id=" + thisPlayer.getAccountID());
		} else if (entity instanceof Hero) {
			
		} else {
			System.out.println("Unknown instance of DotaEntity.");
		}
		
		return retrievedMatchList;
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
