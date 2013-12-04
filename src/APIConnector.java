import java.io.File;


public class APIConnector {
	private Format defaultFormat;
	final private String API_KEY;

	public APIConnector(String API_KEY) {
		this.API_KEY = API_KEY;
		this.defaultFormat = Format.JSON;
	}
	
	public APIConnector(String API_KEY, Format defaultFormat) {
		this.API_KEY = API_KEY;
		this.defaultFormat = defaultFormat;
	}
	
	public File customParameter(String parameter) {
		return null;
	}
	
	public File fullMatchHistoryForSteamUser(String id) {
		return null;
	}
	
	public File fullMatchHistoryForSteamID(String steamID) {
		return null;
	}
	
	public File fullMatchHistoryForHero(String hero) {
		return null;
	}
	
	public File fullMatchHistoryForSkill(String skill) {
		return null;
	}
	
	public File matchIDHistory(String matchId) {
		return null;
	}
}
