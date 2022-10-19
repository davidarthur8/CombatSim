package character;

import java.util.ArrayList;

public class Character {

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
	private int xp;
	private int initiative; 
	private int[] savingThrows;
	private int[] passive;
	private ArrayList<Item> inventory;
	private ArrayList<String> features;
	private String chosenClass;
	private ArrayList<String> skills;
	private ArrayList<String> languages;
	private ArrayList<String> proficiencies;
	private ArrayList<Spell> spells;
	private ArrayList<String> attacks;
	private ArrayList<String> defence;
	private ArrayList<Condition> conditions;
	private static ArrayList<Character> playerCharacters = new ArrayList<Character>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static ArrayList<Character> getPlayerCharacters() {
		return playerCharacters;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
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

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int[] getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(int[] savingThrows) {
		this.savingThrows = savingThrows;
	}

	public int[] getPassive() {
		return passive;
	}

	public void setPassive(int[] passive) {
		this.passive = passive;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
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

	public void setChosenClass(String archeType) {
		this.chosenClass = archeType;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}

	public ArrayList<String> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}

	public ArrayList<String> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(ArrayList<String> proficiencies) {
		this.proficiencies = proficiencies;
	}

	public ArrayList<Spell> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<Spell> spells) {
		this.spells = spells;
	}

	public ArrayList<String> getAttacks() {
		return attacks;
	}

	public void setAttacks(ArrayList<String> attacks) {
		this.attacks = attacks;
	}

	public ArrayList<String> getDefence() {
		return defence;
	}

	public void setDefence(ArrayList<String> defence) {
		this.defence = defence;
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
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

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int dexMod) { 
		this.initiative = (rollDice(20)+dexMod);
	}
	
	public Character() {

	}

	public Character(String name, String chosenClass) {
		this.name = name;
		this.chosenClass = chosenClass;
		this.xp = 121234;
		checkXp(this.xp);
		setInitiative(this.dexterity);
		setProficiency(this.level);

		switch (chosenClass) {
		case "Wizard":
			createWizard(this);
			break;
		case "Barbarian":
			createBarbarian(this);
			break;
		case "Bard":
			createBard(this);
			break;
		case "Cleric":
			createCleric(this);
			break;
		case "Druid":
			createDruid(this);
			break;
		case "Fighter":
			createFighter(this);
			break;
		case "Monk":
			createMonk(this);
			break;
		case "Paladin":
			createPaladin(this);
			break;
		case "Ranger":
			createRanger(this);
			break;
		case "Rogue":
			createRogue(this);
			break;
		case "Warlock":
			createWarlock(this);
			break;
		default:
			System.out.println("Please provide name and chosen class");
		}

		playerCharacters.add(this);
	}

	private void createWarlock(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 2;
		this.constitution = 0;
		this.wisdom = 0;

	}

	private void createRogue(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 4;
		this.constitution = 0;
		this.wisdom = 0;

	}

	private void createRanger(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;

	}

	private void createPaladin(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;

	}

	private void createMonk(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createFighter(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createDruid(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createCleric(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createBard(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createBarbarian(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	private void createWizard(Character character) {
		this.strength = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}

	@Override
	public String toString() {
		return (this.name + " the " + this.chosenClass + " has " + this.intelligence + " intelligence."
				+ "\nproficiency modifier is " + this.proficiency + "\nlevel is " + this.level + "\nexperience points are " + this.xp
				+ "\ninitiative is " + this.initiative);
	}

	public void checkXp(int xp) {
		if (xp < 300) {
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
		switch(diceNumber) {
		case 4:
			total = (int)(Math.random()*4+1);
			break;
		case 6:
			total = (int)(Math.random()*6+1);
			break;
		case 8:
			total = (int)(Math.random()*8+1);
			break;
		case 10:
			total = (int)(Math.random()*10+1);
			break;
		case 12:
			total = (int)(Math.random()*12+1);
			break;
		case 20:
			total = (int)(Math.random()*20+1);
			break;
		case 100:
			total = (int)(Math.random()*100+1);
			break;
		default:
			total = (int)(Math.random()*20+1);
			break;
		}
		System.out.println(total);
		return total;
	}
}
