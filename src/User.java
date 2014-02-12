
public class User extends DotaEntity {
	private String currentName;
	
	public User(String ID) {
		this.setID(ID);
	}

	public String getCurrentName() {
		return currentName;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}

}
