
public class PlayerInstance {
	private String accountID, playerSlot, heroID;
	
	public PlayerInstance(String accountID, String playerSlot, String heroID) {
		this.accountID = accountID;
		this.playerSlot = playerSlot;
		this.heroID = heroID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPlayerSlot() {
		return playerSlot;
	}

	public void setPlayerSlot(String playerSlot) {
		this.playerSlot = playerSlot;
	}

	public String getHeroID() {
		return heroID;
	}

	public void setHeroID(String heroID) {
		this.heroID = heroID;
	}
	
}
