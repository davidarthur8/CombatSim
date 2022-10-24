package character;

public class Spell {
	private String spellName;
	private String spellDesc;
	private int spellCost;
	private int spellDamage;

	public Spell(String spellName) {
		this.spellName = spellName;
	}
	
	public Spell() {
		
	}
	
	public Spell(String spellName, String spellDesc, int spellCost, int spellDamage) {
		this.spellName = spellName;
		this.spellDesc = spellDesc;
		this.spellCost = spellCost;
		this.spellDamage = spellDamage;
	}

	public String getSpellName() {
		return spellName;
	}

	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	public String getSpellDesc() {
		return spellDesc;
	}

	public void setSpellDesc(String spellDesc) {
		this.spellDesc = spellDesc;
	}

	public float getSpellCost() {
		return spellCost;
	}

	public void setSpellCost(int spellCost) {
		this.spellCost = spellCost;
	}

	public int getSpellDamage() {
		return spellDamage;
	}

	public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}
}
