
public class Player extends DotaEntity {
	private String accountID;
	
	
	public Player(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

}
