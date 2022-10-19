package character;

public class Condition {
	private String condDesc;
	private String condName;
	private int condMod;

	public Condition(String condName) {

	}

	public String getCondDesc() {
		return condDesc;
	}

	public void setCondDesc(String condDesc) {
		this.condDesc = condDesc;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public int getCondMod() {
		return condMod;
	}

	public void setCondMod(int condMod) {
		this.condMod = condMod;
	}
}
