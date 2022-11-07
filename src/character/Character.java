package character;

import command.Target;

import java.util.ArrayList;

public class Character implements Target {
	private String name;
	private int strength;
	private int dexterity;
	private int wisdom;
	private int intelligence;
	private int charisma;
	private int constitution;
	private int level;
	private int proficiency;
	private int maxHp;
	private int currentHp;
	private int xp;
	private int initiative;
	private int armourClass;
	private int[] spellSlots;
	private int[] savingThrows;
	private int[] passive;
	private ArrayList<Item> inventory;
	private ArrayList<String> features;
	private String chosenClass;
	private ArrayList<Skill> skills;
	private ArrayList<String> languages;
	private ArrayList<String> proficiencies;
	private ArrayList<Spell> spells = new ArrayList<Spell>();
	private ArrayList<String> attacks;
	private ArrayList<String> defence;
	private ArrayList<Condition> conditions;
	private static ArrayList<Character> playerCharacters = new ArrayList<Character>();

	public static class Builder {
		// Required parameters
		private String name;
		private String chosenClass;

		// Optional parameters - initialized to default values
		private int strength = 0;
		private int dexterity = 0;
		private int wisdom = 0;
		private int intelligence = 0;
		private int charisma = 0;
		private int constitution = 0;
		private int level = 0;
		private int proficiency = 0;
		private int maxHp = 0;
		private int currentHp = 0;
		private int xp = 0;
		private int initiative = 0;
		private int armourClass = 0;
		private int[] spellSlots;
		private int[] savingThrows;
		private int[] passive;
		private ArrayList<Item> inventory = new ArrayList<Item>();
		private ArrayList<String> features = new ArrayList<String>();
		private ArrayList<Skill> skills = new ArrayList<Skill>();
		private ArrayList<String> languages = new ArrayList<String>();
		private ArrayList<String> proficiencies = new ArrayList<String>();
		private ArrayList<Spell> spells = new ArrayList<Spell>();
		private ArrayList<String> attacks = new ArrayList<String>();
		private ArrayList<String> defence = new ArrayList<String>();
		private ArrayList<Condition> conditions = new ArrayList<Condition>();

		public Builder(String name, String chosenClass) {
			this.name = name;
			this.chosenClass = chosenClass;
		}

		public Builder strength(int val) {
			strength = val;
			return this;
		}

		public Builder dexterity(int val) {
			dexterity = val;
			return this;
		}

		public Builder wisdom(int val) {
			wisdom = val;
			return this;
		}

		public Builder intelligence(int val) {
			intelligence = val;
			return this;
		}

		public Builder charisma(int val) {
			charisma = val;
			return this;
		}

		public Builder constitution(int val) {
			constitution = val;
			return this;
		}

		public Builder level(int val) {
			level = val;
			return this;
		}

		public Builder proficiency(int val) {
			proficiency = val;
			return this;
		}

		public Builder maxHp(int val) {
			maxHp = val;
			return this;
		}

		public Builder currentHp(int val) {
			currentHp = val;
			return this;
		}

		public Builder xp(int val) {
			xp = val;
			return this;
		}

		public Builder initiative(int val) {
			initiative = val;
			return this;
		}

		public Builder armourClass(int val) {
			armourClass = val;
			return this;
		}

		public Character build() {
			return new Character(this);
		}

	}
	
	private Character(Builder builder) {
		strength = builder.strength;
		dexterity = builder.dexterity;
		armourClass = builder.armourClass;
		initiative = builder.initiative;
		xp = builder.xp;
		wisdom = builder.wisdom;
		intelligence = builder.intelligence;
		constitution = builder.constitution;
		maxHp = builder.maxHp;
		proficiency = builder.proficiency;
		level = builder.level;
		currentHp = builder.currentHp;
		charisma = builder.charisma;
		name = builder.name;
		chosenClass = builder.chosenClass;
		playerCharacters.add(this);
	}

	public String getName() {
		return name;
	}

	public static ArrayList<Character> getPlayerCharacters() {
		return playerCharacters;
	}

	public int getStrength() {
		return strength;
	}

	public int[] getSpellSlots() {
		return spellSlots;
	}

	public void setSpellSlots(String chosenClass, int level) {
		switch (chosenClass) {
		case "Wizard", "Bard", "Druid", "Sorcerer", "Cleric":
			setPrimarySpellcaster(level);
			break;
		case "Paladin", "Ranger":
			setSecondarySpellcaster(level);
			break;
		case "Warlock":
			setWarlockSpell(level);
		default:
			break;
		}
	}

	private void setSecondarySpellcaster(int level) {
		this.spellSlots = new int[5];
		switch (level) {
		case 1 -> spellSlots[0] = 0;
		case 2 -> spellSlots[0] = 2;
		case 3, 4 -> spellSlots[0] = 3;
		case 5, 6 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 2;
		}
		case 7, 8 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
		}
		case 9, 10 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 2;
		}
		case 11, 12 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
		}
		case 13, 14 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 1;
		}
		case 15, 16 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 2;
		}
		case 17, 18 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 1;
		}
		case 19, 20 -> {
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
		}
		default -> {
		}
		}

	}

	private void setWarlockSpell(int level) {
		this.spellSlots = new int[5];
		switch (level) {
		case 1:
			spellSlots[0] = 1;
			break;
		case 2:
			spellSlots[0] = 2;
			break;
		case 3, 4:
			spellSlots[1] = 2;
			break;
		case 5, 6:
			spellSlots[2] = 2;
			break;
		case 7, 8:
			spellSlots[3] = 2;
			break;
		case 9, 10:
			spellSlots[4] = 2;
			break;
		case 11, 12, 13, 14, 15, 16:
			spellSlots[4] = 3;
			break;
		case 17, 18, 19, 20:
			spellSlots[4] = 4;
			break;
		default:
			break;
		}
	}

	private void setPrimarySpellcaster(int level) {
		this.spellSlots = new int[9];
		switch (level) {
		case 1:
			spellSlots[0] = 2;
			break;
		case 2:
			spellSlots[0] = 3;
			break;
		case 3:
			spellSlots[0] = 4;
			spellSlots[1] = 2;
			break;
		case 4:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			break;
		case 5:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 2;
			break;
		case 6:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			break;
		case 7:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 1;
			break;
		case 8:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 2;
			break;
		case 9:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 1;
			break;
		case 10:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
			break;
		case 11, 12:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
			spellSlots[5] = 1;
			break;
		case 13, 14:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
			spellSlots[5] = 1;
			spellSlots[6] = 1;
			break;
		case 15, 16:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
			spellSlots[5] = 1;
			spellSlots[6] = 1;
			spellSlots[7] = 1;
			break;
		case 17:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 2;
			spellSlots[5] = 1;
			spellSlots[6] = 1;
			spellSlots[7] = 1;
			spellSlots[8] = 1;
			break;
		case 18:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 3;
			spellSlots[5] = 1;
			spellSlots[6] = 1;
			spellSlots[7] = 1;
			spellSlots[8] = 1;
			break;
		case 19:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 3;
			spellSlots[5] = 2;
			spellSlots[6] = 1;
			spellSlots[7] = 1;
			spellSlots[8] = 1;
			break;
		case 20:
			spellSlots[0] = 4;
			spellSlots[1] = 3;
			spellSlots[2] = 3;
			spellSlots[3] = 3;
			spellSlots[4] = 3;
			spellSlots[5] = 2;
			spellSlots[6] = 2;
			spellSlots[7] = 1;
			spellSlots[8] = 1;
			break;
		default:
			break;
		}
	}

	public static void setPlayerCharacters(ArrayList<Character> playerCharacters) {
		Character.playerCharacters = playerCharacters;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getProficiency() {
		return proficiency;
	}

	public void setProficiency(int level) {
		switch (level) {
		case 1, 2, 3, 4:
			this.proficiency = 2;
			break;
		case 5, 6, 7, 8:
			this.proficiency = 3;
			break;
		case 9, 10, 11, 12:
			this.proficiency = 4;
			break;
		case 13, 14, 15, 16:
			this.proficiency = 5;
			break;
		case 17, 18, 19, 20:
			this.proficiency = 6;
			break;
		default:
			this.proficiency = 2;
		}

	}

	public int getMaxHp() {
		return maxHp;
	}

	public int[] getSavingThrows() {
		return savingThrows;
	}

	public int[] getPassive() {
		return passive;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public ArrayList<String> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<String> features) {
		this.features = features;
	}

	public String getChosenClass() {
		return chosenClass;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public ArrayList<String> getLanguages() {
		return languages;
	}

	public ArrayList<String> getProficiencies() {
		return proficiencies;
	}

	public ArrayList<Spell> getSpells() {
		return this.spells;
	}

	public void addSpells(Spell spell) {
		this.spells.add(spell);
	}

	public Spell getSpellList(int position) {
		return spells.get(position);
	}

	public ArrayList<String> getAttacks() {
		return attacks;
	}

	public ArrayList<String> getDefence() {
		return defence;
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int dexMod) {
		this.initiative = (rollDice(20) + dexMod);
	}

	public Character() {

	}

	@Override
	public String toString() {
		return (this.name + " the " + this.chosenClass + " has " + this.intelligence + " intelligence."
				+ "\nproficiency modifier is " + this.proficiency + "\nlevel is " + this.level
				+ "\nexperience points are " + this.xp + "\ninitiative is " + this.initiative);
	}

	public void checkXp(int xp) {
		if (xp <= 299) {
			this.level = 1;
		} else if (xp > 299 && xp < 900) {
			this.level = 2;
		} else if (xp > 899 && xp < 2700) {
			this.level = 3;
		} else if (xp > 2699 && xp < 6500) {
			this.level = 4;
		} else if (xp > 6499 && xp < 14000) {
			this.level = 5;
		} else if (xp > 13999 && xp < 23000) {
			this.level = 6;
		} else if (xp > 22999 && xp < 34000) {
			this.level = 7;
		} else if (xp > 33999 && xp < 48000) {
			this.level = 8;
		} else if (xp > 47999 && xp < 64000) {
			this.level = 9;
		} else if (xp > 63999 && xp < 85000) {
			this.level = 10;
		} else if (xp > 84999 && xp < 100000) {
			this.level = 11;
		} else if (xp > 99999 && xp < 120000) {
			this.level = 12;
		} else if (xp > 119999 && xp < 140000) {
			this.level = 13;
		} else if (xp > 139999 && xp < 165000) {
			this.level = 14;
		} else if (xp > 164999 && xp < 195000) {
			this.level = 15;
		} else if (xp > 194999 && xp < 225000) {
			this.level = 16;
		} else if (xp > 224999 && xp < 265000) {
			this.level = 17;
		} else if (xp > 264999 && xp < 305000) {
			this.level = 18;
		} else if (xp > 304999 && xp < 355000) {
			this.level = 19;
		} else if (xp > 354999) {
			this.level = 20;
		}
	}

	public int rollDice(int diceNumber) {
		int total;
		switch (diceNumber) {
		case 4:
			total = (int) (Math.random() * 4 + 1);
			break;
		case 6:
			total = (int) (Math.random() * 6 + 1);
			break;
		case 8:
			total = (int) (Math.random() * 8 + 1);
			break;
		case 10:
			total = (int) (Math.random() * 10 + 1);
			break;
		case 12:
			total = (int) (Math.random() * 12 + 1);
			break;
		case 20:
			total = (int) (Math.random() * 20 + 1);
			break;
		case 100:
			total = (int) (Math.random() * 100 + 1);
			break;
		default:
			total = (int) (Math.random() * 20 + 1);
			break;
		}
		return total;
	}

	public void combatDamage(int damage) {
		this.currentHp -= damage;
	}

	public void healHp(int heal) {
		this.currentHp += heal;
	}

	public int getArmourClass() {
		return armourClass;
	}

	public void setArmourClass(int armourClass) {
		this.armourClass = armourClass;
	}

}
